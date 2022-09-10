package AcWing._基础._05DP.Pa_01_背包问题;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2022/4/8 19:38
 * 对优化二维数组 ,使用一维数组解决
 */
public class _Case01_02背包问题 {
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

        // 算法过程，因为f[0][0~m]初始就为0，因此初始化可以省略
        for (int i = 1; i <= n; i++) {// 先循环物品
            for (int j = v; j >= vi[i]; j--) {// 再循环容量
                f[j] = Math.max(f[j], j - vi[i] >= 0 ? f[j - vi[i]] + wi[i] : 0); // j - vi[i] > 0 才能选第i件物品
            }
        }
        System.out.println(f[v]);

    }
}
