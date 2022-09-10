package AcWing._蓝桥._03_数学与简单DP;



import sun.java2d.pipe.SpanIterator;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/14 0:08
 */
public class _Case01_02买不到的数 {
    static int n;
    static int m;
    static int N = 10000005;
    static int[] f = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        //if (n > m) {
        //    n = n ^ m;
        //    m = n ^ m;
        //    n = n ^ m;
        //}
        Arrays.fill(f,-1);
        //只要连续 n个数有解, 后面的必然有解
        int ans = 0;

        for (int i = 1; i < 10000000 ; i++) {
            if (!dfs(i, n, m)) {
                ans = i;
            }
        }
        System.out.println(ans);
    }

    private static boolean dfs(int size, int q, int p) {
        if(f[size] != -1) {
            if (f[size] == 1 ) return true;
            else return  false;
         };

        if(size == 0) {
            f[size] = 1;
            return true;
        }

        if(size >= p &&  dfs(size-p,p,q)) {
            f[size] = 1;
            return true;
        }

        if(size >= q &&   dfs(size-q,p,q)){
            f[size] = 1;
            return true;
        }

        f[size] = 0;
        return false;
    }
}
