package AcWing._蓝桥._03_数学与简单DP;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/15 14:14
 */
public class _Case07_01地宫取宝 {
    public static void main(String[] args) {
        final int N = 55;
       final   int  MOD = 1000000007;
        int[][][][] dp = new int[N][N][13][14];
        int[][] w = new int[N][N];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int tk = sc.nextInt();
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                w[i][j] = sc.nextInt() + 1;

        //初始化 第一个选不选
        dp[1][1][1][w[1][1]]  = 1;
        dp[1][1][0][0]  = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) continue;

                for (int k = 0; k <= tk; k++) {
                    for (int v = 0; v <= 13; v++) {

                        //不选的两种情况 从上面选 ,从左边选
                        dp[i][j][k][v] = ( dp[i][j][k][v] + dp[i][j-1][k][v]) %MOD;
                        dp[i][j][k][v] = ( dp[i][j][k][v] + dp[i-1][j][k][v] )%MOD;

                        if( k > 0 && v == w[i][j]){
                            for (int c = 0; c < v; c++) {
                                dp[i][j][k][v] = ( dp[i][j][k][v] + dp[i][j-1][k-1][c] ) %MOD;
                                dp[i][j][k][v] = ( dp[i][j][k][v] + dp[i-1][j][k-1][c] ) %MOD;

                            }
                        }
                    }
                }

            }
        }
        int  ans = 0 ;
        for (int i = 0; i <= 13 ; i++) {
            ans = (ans + dp[n][m][tk][i]) % MOD;
        }
        System.out.println(ans);
    }
}
