package AcWing._蓝桥._03_数学与简单DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/14 16:36
 */
public class _Case04_02_01背包问题 {

    static int n;
    static int v;
    static int N = 1010;

    static int []dp = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        v = sc.nextInt();
        //dp[i][j]  表用前面i件物品凑出j的最大价值
        for (int i = 1; i <= n; i++) {
            int vi  = sc.nextInt();
            int wi  = sc.nextInt();
            for (int j = v; j >= 1; j--) {
                //选 , 这个物品能放的下
                if ( vi <= j  )
                    dp[j] = Math.max(dp[j],dp[j-vi]+ wi);

            }
        }

        System.out.println(dp[v]);
    }
}
