package AcWing._蓝桥._08_数论;

import com.sun.org.apache.bcel.internal.generic.IFEQ;
import sun.security.util.AuthResources_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/23 12:13
 */
public class _Case01_01等差数列 {
    static int N = 100100;
    static int [ ]a = new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt( in.readLine());
        String[] s = in.readLine().split(" ");
        for (int i = 1; i <= n; i++)
            a[i] = Integer.parseInt(s[i-1]);
        Arrays.sort(a,1,n+1);

        // 每一项 和 第一项的差, 最后d是每一项和第一项的差的最大公约数
        for (int i = 2; i <= n ; i++) {
            a[0] = gcd(a[0],a[i] - a[i-1]);
        }

        if (a[0] != 0) System.out.println((a[n]- a[1])/a[0] +1);
        else System.out.println(n);
    }

    private static int gcd(int a, int b) {
        return  b == 0 ? a:gcd(b , a%b);
    }
}
