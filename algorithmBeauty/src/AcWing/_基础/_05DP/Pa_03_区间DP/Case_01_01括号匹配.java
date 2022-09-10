package AcWing._基础._05DP.Pa_03_区间DP;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2022/1/29 8:16
 */
public class Case_01_01括号匹配 {
    final static int N = 110;
    static int[][] dp = new int[N][N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.next();
            if (s.charAt(0) == 'e') break;
            int n = s.length();
            for (int len = 2; len <= n; len++) {
                for (int i = 0; i + len <= n ; i++) {
                    int j = i + len -1;
                    dp[i][j] = 0;
                    if (s.charAt(i) == '(' && s.charAt(j) == ')' || s.charAt(i) == '[' && s.charAt(j) == ']')
                        dp[i][j] = dp[i+1][j-1] + 2;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.max(dp[i][j],dp[i][k]+ dp[k+1][j]);
                    }
                }
            }
            System.out.println(dp[0][n-1]);
        }
    }
}
