package AcWing._基础._05DP.Pa_01_背包问题;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2022/4/8 20:48
 * 对三维数组进行优化 二维
 */
public class _Case02_02完全背包问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int v = sc.nextInt();

        int[] vi = new int[n + 1];
        int[] wi = new int[n + 1];
        int[][] f = new int[n + 1][v + 1];

        for (int i = 1; i <= n; i++) {
            vi[i] = sc.nextInt();
            wi[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++)
            for (int j = vi[i]; j <= v; j++)
                f[i][j] = Math.max(f[i - 1][j] , f[i][j - vi[i]] + wi[i] );

        System.out.println(f[n][v]);
    }
}
