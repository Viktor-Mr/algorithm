package AcWing._基础._05DP.Pa_01_背包问题;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/30 22:27
 */
public class _Case05_01分组背包 {
    static int N = 110;
    static int [][]vi = new int[N][N];
    static int [][]wi = new int[N][N];
    static int []si = new int[N];

    static int []f = new int[N];

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int  n = sc.nextInt();
        int  v = sc.nextInt();
        for (int i = 1; i <= n; i++) {
             si[i] = sc.nextInt();
            for (int j = 1; j <= si[i] ; j++) {
                 vi[i][j] = sc.nextInt();
                 wi[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = v; j >= 0 ; j--) {
                for (int k = 1; k <= si[i] ; k++) {
                    if (vi[i][k] <= j) {
                        f[j] = Math.max(f[j],f[j - vi[i][k]] + wi[i][k]);

                    }
                }
            }
        }
        System.out.println(f[v]);

    }
}
