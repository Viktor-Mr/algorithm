package AcWing._蓝桥._03_数学与简单DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/15 0:59
 */
public class _Case06_01最长上升子序列 {
    static int[] f = new int[1010];
    static int[] dp = new int[1010];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++)
            f[i] = sc.nextInt();

        dp[1] = 1;
        int max = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (dp[j] >= dp[i] && f[j] < f[i]) {
                    dp[i] = dp[j]+1;
                }
            }
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
