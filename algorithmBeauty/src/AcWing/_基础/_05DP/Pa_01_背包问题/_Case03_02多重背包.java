package AcWing._基础._05DP.Pa_01_背包问题;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2022/4/8 22:53
 */
public class _Case03_02多重背包 {
    static int N = 12000;
    static int[] v = new int[N];
    static int[] w = new int[N];
    static int[] f = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int cnt = 0;
        while (n-- > 0){
            int vi = sc.nextInt();
            int wi = sc.nextInt();
            int si = sc.nextInt();

            int k = 1;
            while ( k <= si ){
                cnt++;
                v[cnt] = vi * k;
                w[cnt] = wi * k;
                si -=k;
                k *= 2;
            }
            if (si > 0){
                cnt++;
                v[cnt] = vi * si;
                w[cnt] = wi * si;
            }
        }
        for (int i = 1; i <= cnt; i++) {
            for (int j = m; j >= v[i] ; j--) {
                f[j] = Math.max(f[j] , f[j - v[i]]+ w[i]);
            }
        }
        System.out.println(f[m]);
    }
}
