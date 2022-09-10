package AcWing._基础._05DP.Pa_01_背包问题;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2022/4/8 21:10
 * 滚动数组
 */
public class _Case02_03完全背包问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int v = sc.nextInt();

        int[] vi = new int[n + 1];
        int[] wi = new int[n + 1];
        int[] f = new int[v + 1];

        for (int i = 1; i <= n; i++) {
            vi[i] = sc.nextInt();
            wi[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++)
            for (int j = vi[i]; j <= v; j++)
                f[j] = Math.max(f[j] , f[j - vi[i]] + wi[i] );

        System.out.println(f[v]);
    }
}
