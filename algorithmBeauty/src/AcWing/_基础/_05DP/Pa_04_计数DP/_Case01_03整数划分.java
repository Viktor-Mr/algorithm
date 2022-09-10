package AcWing._基础._05DP.Pa_04_计数DP;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2022/4/8 18:35
 */
public class _Case01_03整数划分 {
    public static final int M = (int) (1e9 + 7);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n + 1][n + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - j][j]) % M;
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = ans +  dp[n][i];
            ans %= M;
        }
        System.out.println(ans);
    }
}
