package AcWing._蓝桥._09_复杂DP;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2022/1/27 21:37
 */
public class _Case03_01密码脱落 {
    final static int N = 1010;
    static int[][] dp = new int[N][N];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        int n = s.length();
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len  <= n ; i++) {
                int j = i + len - 1;
                if (len == 1) dp[i][j] = 1;
                else {
                    if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i + 1][j - 1] + 2;
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i + 1][j], dp[i][j - 1]));
                }
            }
        }
        System.out.println(n-dp[0][n-1]);

    }
}

