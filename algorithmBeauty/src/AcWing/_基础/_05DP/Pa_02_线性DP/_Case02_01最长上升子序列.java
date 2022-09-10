package AcWing._基础._05DP.Pa_02_线性DP;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2022/4/7 12:37
 */
public class _Case02_01最长上升子序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []f = new int[n+1];
        int []dp = new int[n+1];

        for (int i = 1; i <=n ; i++) f[i] = sc.nextInt();

        int max = 0;
        for (int i = 1; i <= n ; i++) {
            dp[i] = 1;
            for (int j = 1; j < i ; j++)
                if (  f[i] > f[j] && dp[i] <= dp[j]  )
                    dp[i] = dp[j]+1;

            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
