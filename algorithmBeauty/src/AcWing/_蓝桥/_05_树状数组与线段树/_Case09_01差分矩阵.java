package AcWing._蓝桥._05_树状数组与线段树;

import java.io.*;


/**
 * @author fu-xiao-liu
 * @Date 2021/11/18 23:15
 */
public class _Case09_01差分矩阵 {
    static int N = 1010;
    static int[][] a = new int[N][N];
    static int[][] b = new int[N][N];
    static int n, m, q, c, x1, x2, y1, y2;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = in.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        q = Integer.parseInt(s[2]);
        for (int i = 1; i <= n; i++) {
            s = in.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                a[i][j] = Integer.parseInt(s[j - 1]);
                insert(i,j,i,j,a[i][j]);
            }
        }
        while (q-- > 0) {
            s = in.readLine().split(" ");
            x1 = Integer.parseInt(s[0]);
            y1 = Integer.parseInt(s[1]);
            x2 = Integer.parseInt(s[2]);
            y2 = Integer.parseInt(s[3]);
            c = Integer.parseInt(s[4]);
            insert(x1,y1,x2,y2,c);
        }
        //计算矩阵
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // a[i] = b[i] + a[i-1]
                a[i][j] = a[i - 1][j] + a[i][j - 1] - a[i - 1][j - 1] + b[i][j];
                out.write(a[i][j] + " ");
            }
            out.write("\n");
        }
        out.flush();
    }
    //b[i]  =  a [i] - a[i-1]
    private static void insert(int x1, int y1, int x2, int y2, int c) {
        b[x1][y1] += c;
        b[x1][y2 + 1] -= c;
        b[x2 + 1][y1] -= c;
        b[x2 + 1][y2 + 1] += c;
    }
}
