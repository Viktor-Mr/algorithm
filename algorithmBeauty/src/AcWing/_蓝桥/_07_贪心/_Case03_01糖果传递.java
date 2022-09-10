package AcWing._蓝桥._07_贪心;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/31 22:50
 */
public class _Case03_01糖果传递 {

    public static void main(String[] args) throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(sc.readLine());

        int a[] = new int[n];
        long f[] = new long[n];
        long  num = 0;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(sc.readLine());
            num += a[i];
        }
        num /= n;

        long k = 0;

        for (int i = n-1; i > 0 ; i--) {
           k  = k + num - a[i];
           f[i] = k;
        }
        f[0] = 0;

        Arrays.sort(f);
        long ans = 0;

        for (int i = 0; i < n; i++) {
            ans += Math.abs(f[i]-f[n/2]);
        }
        System.out.println(ans);
    }

}
