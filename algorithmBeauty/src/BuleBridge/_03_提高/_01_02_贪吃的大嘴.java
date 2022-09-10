package BuleBridge._03_提高;

import com.sun.deploy.ui.UIFactory;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/12/1 17:11
 */
public class _01_02_贪吃的大嘴 {
    static int N = 55;
    static int M = 20010;
    static int[] f = new int[M];
    static int[] v = new int[N];
    static int[] w = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int cnt = 0;
        while (n-- > 0) {
            int vi = sc.nextInt();
            int si = sc.nextInt();
            int k = 1;
            while (k <= si) {
                ++cnt;
                v[cnt] = vi * k;
                w[cnt] =  k;
                si -= k;
                k *= 2;
            }
            if (si > 0) {
                ++cnt;
                v[cnt] = si * vi;
                w[cnt] = si ;
            }
        }
        n = cnt;
        Arrays.fill(f,2010);
        f[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = m; j >= v[i] ; j --) {
                f[j] = Math.min(f[j], f[j-v[i] ] + w[i]);
            }
        }
        if (f[m] <= 2000) System.out.println(f[m]);
        else System.out.println("><");
    }
}
