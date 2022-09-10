package algorithmBeauty.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/23 12:53
 */
public class _01_数字组合 {
    public static void main(String[] args) {
        way1();
        //way2();
    }
    private static void way2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int []dp = new int[m+1];
        int []dp2 = new int[m+1];

        dp[0] = 1;
        dp2[0] = 1;
        for (int i = 1; i <= n; i++) {
            int v =sc.nextInt();

            for (int j = v; j <= m; j++) {
                dp[j] += dp2[j - v];
            }
            dp2 = dp.clone();
        }
        System.out.println(dp[m]);
    }


    private static void way1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int []dp = new int[m+1];

        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
           int v = sc.nextInt();
            for (int j = m; j >= v ; j--) {
                dp[j] += dp[j - v];
            }
        }
        System.out.println(dp[m]);
    }
}
