package AcWing._蓝桥._05_树状数组与线段树;

import java.io.*;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/18 22:15
 */
public class _Case08_01差分数组 {
    static int N = 100010;
    static int[] d = new int[N];
    static int[] f = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        s = in.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            f[i] = Integer.parseInt(s[i - 1]);
            d[i] = f[i] - f[i-1];
        }


        //差分数组  d[i]  = a[i] - a[i-1]   a[i] = d[i] + a[i-1]
        while (m-- > 0){
             s = in.readLine().split(" ");
             int l = Integer.parseInt(s[0]);
             int r = Integer.parseInt(s[1]);
             int c = Integer.parseInt(s[2]);
             d[l] += c;
             d[r+1] -= c;
        }

        for (int i = 1; i <= n; i++) {
            f[i] = f[i-1] + d[i];
            out.write(f[i] + " ");
        }
        out.flush();
    }
}
