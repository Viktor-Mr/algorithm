package AcWing._蓝桥._03_数学与简单DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/14 16:36
 */
public class _Case04_01_01背包问题 {

    static int n;
    static int v;
    static int N = 1010;

    static int [][]dp = new int[N][N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        v = sc.nextInt();
        //dp[i][j]  表用前面i件物品凑出j的最大价值
        for (int i = 1; i <= n; i++) {
            int vi  = sc.nextInt();
            int wi  = sc.nextInt();
            for (int j = 1; j <= v; j++) {
                //选 , 这个物品能放的下
                if ( vi <= j  ) {
                    dp[i][j] = Math.max(dp[i][j] , dp[i-1][j-vi]+ wi);
                }
                //不选
                 dp[i][j] = Math.max(dp[i][j] , dp[i-1][j]);
            }
        }



        System.out.println(dp[n][v]);
    }
}
