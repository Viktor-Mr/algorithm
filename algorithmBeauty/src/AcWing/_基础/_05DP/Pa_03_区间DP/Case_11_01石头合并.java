package AcWing._基础._05DP.Pa_03_区间DP;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2022/1/28 21:32
 */
public class Case_11_01石头合并 {

    final static int N = 310;
    static int[][] dp = new int[N][N];
    static int[] s = new int[N];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 1; i <= n; i++) s[i] =  s[i-1] + input.nextInt();

        for (int len = 2; len <=n ; len++) {
            for (int i = 1; i + len - 1 <= n; i++) { //起点
                int j = i + len -1;              //终点
                dp[i][j] = Integer.MAX_VALUE; //初始化
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + s[j] - s[i-1]);
                }
            }
        }
        System.out.println(dp[1][n]);
    }
}
