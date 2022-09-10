package AcWing._蓝桥._05_树状数组与线段树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/17 22:15
 */
public class _Case01_01动态求连续区间和 {
    static int N = 100010;
    static  int n;
    static int[] pre = new int[N];
    static int[] c = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] s = in.readLine().split(" ");
         n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        String[] s2 = in.readLine().split(" ");
        for(int i = 1;i <= n;i++) c[i] = Integer.parseInt(s2[i - 1]);

        //初始化
        for (int i = 1; i <= n; i++)  add(i,c[i]);


        for (int i = 0; i < m; i++) {
            s = in.readLine().split(" ");
            if (Integer.parseInt(s[0]) == 0)
                System.out.println(ask(Integer.parseInt(s[2])) - ask(Integer.parseInt(s[1])-1));
            else add(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
        }

    }

    private static void add(int i, int d) {
        for ( ; i <= n ; i += i&(-i)){
            pre[i] += d;
        }
    }

    private static int ask(int i) {
        int ans = 0 ;

        for ( ; i > 0 ; i -= i&(-i)) ans += pre[i];

        return ans;
    }
}
