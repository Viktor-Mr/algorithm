package AcWing._蓝桥._01_递归与递推;

import java.io.*;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/4 0:36
 */
public class _Case02_01全排列 {
    static int n;
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] a;
    static int[] d;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(in.readLine());
        a = new int[n];
        d = new int[n];

        dfs(0);
        in.close();
        out.flush();
        out.close();
    }

    private static void dfs(int k) throws IOException {
        if (k == n) {
            for (int j = 0; j < n; j++) {
                out.write(a[j] + " ");
            }
            out.write("\n");
        }

        for (int i = 0; i < n; i++) {

            if ( d[i] == 0){  //这位上的数没被使用过
                a[k] = i+1;    //标记这个数
                d[i] = 1;   //标记状态 这个数使用过了
                dfs(k+1);
                d[i] = 0;
            }


        }

    }
}
