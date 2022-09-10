package AcWing._蓝桥._07_贪心;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/31 21:59
 * DP 加  状态机
 */


public class _Case01_03股票买卖III {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        int dp[][] = new int[n+1][2];

        dp[0][1] = (int) (1f/-0f);
        for (int i = 1; i <= n; i++) {
            //不持有股票 和 持有股票的收益
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]  + a[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - a[i]);
        }
        System.out.println(dp[n][0]);
    }
}
