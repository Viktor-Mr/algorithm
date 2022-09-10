package algorithmBeauty.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/23 13:47
 */
public class _02_采药 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int m = sc.nextInt();
        int []dp = new int[t+1];


        for (int i = 1; i <= m; i++) {
            int vt = sc.nextInt();
            int v = sc.nextInt();
            if (vt > t) continue;
            //dp[vt] = Math.max(v,dp[vt]);
            for (int j = t; j >= vt ; j--) {
                dp [j] = Math.max(dp[j],dp[j-vt] + v);
            }
        }
        System.out.println(dp[t]);
    }
}
