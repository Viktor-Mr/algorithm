package AcWing._蓝桥._07_贪心;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/2 10:34
 */
public class _Case05_01付账问题 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        double s = sc.nextDouble();
        int []f = new int[n];
        for (int i = 0; i < n; i++) f[i] = sc.nextInt();
        Arrays.sort(f);
        double avg = s/n;
        double avgg = avg;
        double nes = 0 ;
        double ans = 0 ;
        for (int i = 0; i < n; i++) {
            if (f[i] < avgg) {
                nes = f[i];
                avgg = avgg + (avgg - f[i])/(n-i-1);
            }
            else {
                nes = avgg;
            }
            ans += (nes -avg) * (nes -avg);
        }

        System.out.printf( "%.4f", Math.sqrt(ans/n));
    }
}
