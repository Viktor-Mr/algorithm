package AcWing._蓝桥._05_树状数组与线段树;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QDecoderStream;

import java.io.*;
import java.util.Arrays;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/18 0:44
 */
public class _Case02_01数星星 {

    static int N = 32010;
    static  int n;
    static int[] pre = new int[N];
    static int[] level = new int[N];


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(in.readLine());

        for (int i = 0; i < n; i++) {
            String[] s = in.readLine().split(" ");
            int x = Integer.parseInt(s[0])+1;

            //判断这个点的前缀和
            level[ask(x)] ++;
            add(x,1);
        }
        for (int i = 0; i <= n-1 ; i++) {
            System.out.println(level[i]);
        }
        in.close();
        out.flush();
        out.close();

    }

    private static void add(int i, int d) {
        for ( ; i < N ; i += i&(-i)){
            pre[i] += d;
        }
    }

    private static int ask(int i) {
        int ans = 0 ;

        for ( ; i > 0 ; i -= i&(-i)) ans += pre[i];

        return ans;
    }
}
