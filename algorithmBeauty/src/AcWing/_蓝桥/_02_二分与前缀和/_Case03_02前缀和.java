package AcWing._蓝桥._02_二分与前缀和;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/11 13:22
 *
 * 利用树状数组的特点来计算前缀和
 */
public class _Case03_02前缀和 {
    static  int []f;
    static  int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
        int m = sc.nextInt();
       f = new int[n+1];

       //初始化
        for (int i = 1; i <= n; i++) {
            int a = sc.nextInt();
            add(a,i);
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(ask(y) -ask(x-1));
        }
    }

    private static void add(int a, int i) {
        for ( ; i <= n;  i += i&(-i) ){
            f[i]  += a;
        }
    }

    private static int ask(int k) {
        int ans = 0;
        for ( ; k > 0  ; k-= k&(-k) ) {
            ans += f[k];
        }
        return  ans;
    }


}
