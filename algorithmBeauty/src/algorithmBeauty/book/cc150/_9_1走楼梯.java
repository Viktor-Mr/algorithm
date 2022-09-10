package algorithmBeauty.book.cc150;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/21 9:46
 */
public class _9_1走楼梯 {
    static final int mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(recursion2(n));
        System.out.println(recursion1(n));
    }

    private static int recursion1(int n) {
        if (n <= 0) {
            return 0;
        }
        if(n == 1 ) return 1;
        if (n == 2) {
            return 2;
        }if (n == 3) {
            return 4;
        }
        return recursion1(n-1) + recursion1( n-2) + recursion1(n-3);
    }

    public static int recursion2(int n) {
        if (n <= 0) return 0;
        if ( n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        int x1 = 1;
        int x2 = 2;
        int x3 = 4;
        for (int i = 4; i <= n; i++) {
            int x_1 = x1;
            x1 = x2 % mod;
            x2 = x3 % mod;
            x3 = ((x1 + x2) % mod + x_1) % mod;//注意此处
        }
        return x3;
    }

}
