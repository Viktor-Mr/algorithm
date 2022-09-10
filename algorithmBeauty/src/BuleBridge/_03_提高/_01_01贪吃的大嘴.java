package BuleBridge._03_提高;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/12/1 0:04
 */
public class _01_01贪吃的大嘴 {
    private static final int N = 55;
    private static final int M = 20010;
    static int [][]f = new int[N][M];
    //前i组,体积为j时的最小蛋糕数
    // 无论那组 ,体积为0时的蛋糕数都是零
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int n = sc.nextInt();
        for (int i = 0; i < N; i++){
            Arrays.fill(f[i],20010);

        }

        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            int vi = sc.nextInt();
            int si = sc.nextInt();
            for (int j = 0; j <= v; j++) {
                for (int k = 0; k <= si && k * vi <= j; k++) {
                    f[i][j] = Math.min(f[i][j],f[i-1][j-vi*k]+k);
                }
            }
        }
        for (int i = 0; i <=n ; i++ ) {
            for (int j = 0; j <= v; j++) {
                System.out.print(f[i][j] + " ");
            }
            System.out.println();
        }

        if (f[n][v] < 20010) System.out.println(f[n][v]);
        else System.out.println("><");
    }
}
