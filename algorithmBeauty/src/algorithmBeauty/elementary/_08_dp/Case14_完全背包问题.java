package algorithmBeauty.elementary._08_dp;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/3 21:20
 */
public class Case14_完全背包问题 {
    static int n;
    static int v;

    static int dp[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        v = sc.nextInt();
        int vi = 0;
        int wi = 0;
        dp = new int[v+1];
        for (int i = 1; i <= n; i++) {
            vi = sc.nextInt();
            wi = sc.nextInt();
            for (int j = vi ; j <= v; j++) {
                    dp[j] = Math.max(dp[j-vi]+wi , dp[j]);
            }
        }

        System.out.println(dp[v]);
    }
}
