package AcWing._基础._05DP.Pa_04_计数DP;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2022/4/8 18:23
 */
public class _Case01_01整数划分 {
    public static final int M = (int) (1e9 + 7);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //定义DP数组 从前1~i中选，体积为j
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 1;//一个数都不选是一种方案

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k * i <= j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k * i]) % M;
                }
            }
        }
        System.out.println(dp[n][n]);
    }
}
