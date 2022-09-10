package AcWing._基础._05DP.Pa_02_线性DP;

import java.util.Scanner;


/**
 * @author fu-xiao-liu
 * @Date 2022/4/7 12:40
 */
public class _Case06_01编辑距离 {
    static String[] fs = new String[1010];
    static int[][] dp = new int[1010][1000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= n; i++) fs[i] = " " + sc.next();

        while (m-- > 0) {
            String s = " " + sc.next();
            int nums = sc.nextInt();
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (find(s, i) <= nums) ans++;

            }
            System.out.println(ans);
        }
    }

    static int find(String s, int x) {
        int n = s.length()-1;
        int m = fs[x].length()-1;

        //初始化当
        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int i = 0; i <= m; i++) dp[0][i] = i;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1);
                if (s.charAt(i) == fs[x].charAt(j)) dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i][j]);
                else dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, dp[i][j]);
            }
        }


        return dp[n][m];
    }
}
