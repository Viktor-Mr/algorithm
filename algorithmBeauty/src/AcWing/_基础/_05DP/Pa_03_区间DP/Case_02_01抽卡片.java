package AcWing._基础._05DP.Pa_03_区间DP;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2022/1/29 22:35
 * Poj 1651
 */
public class Case_02_01抽卡片 {
    static final int N = 110;
    static int []num  = new int[N];
    static int [][]dp  = new int[N][N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            num[i] = sc.nextInt();
        }

        for (int len = 2; len < n; len++) {   //长度
            for (int i = 1; i + len <= n; i++) {  //起点
                int j = i + len  ;  //终点
                dp[i][j] = Integer.MAX_VALUE;  //寻找最小值,初始化为最大
                for (int k = i+1; k < j ; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + num[k] * num[i] * num[j]);
                }
            }
        }
        System.out.println(dp[1][n]);
    }
}
