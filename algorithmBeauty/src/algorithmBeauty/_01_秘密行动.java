package algorithmBeauty;

import java.util.Scanner;

public class _01_秘密行动 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n+1];
        for (int i = 1; i <= n; i++) {
            num[i] = sc.nextInt();
        }
        /**
         * 通过局部最优解求得全局最优解
         */
        //数组dp[n][0]保存的是通过爬的方式上到第n层
        //dp[n][1]保存的是通过跳跃的方式上到第n层
        int [][]dp = new int [n+1][2];
        dp[1][0] = num[1]; //通过爬的方式上第一层
        dp[1][1] = 0;       //通过跳跃的方式上第一层

        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.min(dp[i-1][0],dp[i-1][1]) + num[i];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-2][0]) ;

        }
        System.out.println(Math.min(dp[n][0],dp[n][1]));

    }
}
