package AcWing._基础._05DP.Pa_01_背包问题;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2022/4/8 20:25
 * 三维数组
 */
public class _Case02_01完全背包问题 {
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
            for (int j = 0; j <= v; j++)
                for (int k = 0; k * vi[i] <= j; k++)
                    f[i][j] = Math.max(f[i - 1][j - vi[i] * k] + wi[i] * k, f[i][j] );

        System.out.println(f[n][v]);


    }
}
