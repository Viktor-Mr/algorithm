package AcWing._蓝桥._07_贪心;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/31 17:40
 */
public class _Case01_02股权买卖II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n+1];
        int dp[] = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
         dp[2] = ( (a[2] > a[1]) ? a[2]-a[1] : 0);
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + ( (a[i] > a[i-1]) ? a[i] - a[i-1] : 0);
        }
        System.out.println(dp[n]);
    }
}
