package AcWing._基础._05DP.Pa_04_计数DP;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2022/4/8 18:32
 */
public class _Case01_02整数划分 {
    public static final int M = (int) (1e9 + 7);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //定义DP数组 从前1~i中选，的体积最大
        int[] dp = new int[n + 1];
        dp[0] = 1;//一个数都不选是一种方案
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                    dp[j] = (dp[j] + dp[j - i] )% M;

            }
        }
        System.out.println(dp[n]);
    }
}
