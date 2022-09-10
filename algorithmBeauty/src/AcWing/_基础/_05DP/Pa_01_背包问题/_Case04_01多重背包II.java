package AcWing._基础._05DP.Pa_01_背包问题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/30 22:27
 */
public class _Case04_01多重背包II {
    static int N = 12000;
    static int[] v = new int[N];
    static int[] w = new int[N];
    static int[] f = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int cnt = 0;
        while (n-- > 0) {
            s = in.readLine().split(" ");
            int vi = Integer.parseInt(s[0]);
            int wi = Integer.parseInt(s[1]);
            int si = Integer.parseInt(s[2]);
            int k = 1;
            while (k <= si) {
                cnt++;
                v[cnt] = vi * k;
                w[cnt] = wi * k;
                si -= k;
                k *= 2;
            }
            if (si > 0) {
                cnt++;
                v[cnt] = vi * si;
                w[cnt] = wi * si;
            }
        }
        n = cnt ;
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= v[i] ; j--) {
                f[j] = Math.max(f[j],f[j-v[i]]+w[i]);
            }
        }
        System.out.println(f[m]);

    }
}
