package AcWing._蓝桥._12_12届第一场;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2022/4/1 20:43
 */
public class _3417砝码称重01 {

    //j的取值其实是 -m ~ +m，因为数组下标不能为负，所以所有第二维偏移到0 ~ 2m。B是偏移量。
    static int N = 110, M = 200010, B = M / 2;

    static int n, m;
    static int[] w = new int[N];
    static boolean[][] f = new boolean[N][M];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            m += w[i]; //所有砝码总重量
        }


        f[0][B] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = -m; j <= m; j++) {
                //不选
                f[i][j + B] = f[i - 1][j + B];
                //如果放在左边大于等于 -m
                if (j - w[i] >= -m) f[i][j + B] |= f[i - 1][j - w[i] + B];

                //如果放在右边小于等于 m
                if (j + w[i] <= m) f[i][j + B] |= f[i - 1][j + w[i] + B];

            }
        }
        int res = 0;
        for (int j = 1; j <= m; j++)
            if (f[n ][j + B])
                res++;

        System.out.println(res);
    }
}
