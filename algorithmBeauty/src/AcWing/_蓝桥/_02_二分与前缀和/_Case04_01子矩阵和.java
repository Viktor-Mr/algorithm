package AcWing._蓝桥._02_二分与前缀和;

import java.io.*;
/**
 * @author fu-xiao-liu
 * @Date 2021/11/11 14:09
 */
public class _Case04_01子矩阵和 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));




    public static void main(String[] args) throws IOException {
        String[] init = in.readLine().split(" ");
        int n = Integer.parseInt(init[0]);
        int m = Integer.parseInt(init[1]);
        int q = Integer.parseInt(init[2]);
        int [][] f = new int[n+1][m+1];
        for (int i = 1; i <= n ; i++) {
            int a = 0;
             init = in.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                a= Integer.parseInt(init[j-1]);
                f[i][j] = a +f[i][j-1];
            }
        }


        for (int k = 0; k < q; k++) {
            init = in.readLine().split(" ");
            int x1 = Integer.parseInt(init[0]);
            int y1 = Integer.parseInt(init[1]);
            int x2 = Integer.parseInt(init[2]);
            int y2 = Integer.parseInt(init[3]);
            //一行一行加
            int ans = 0;
            for (int i = x1; i <= x2; i++) {
                ans += (f[i][y2]  - f[i][y1-1]);
            }
           out.write(ans + "\n");
        }
        in.close();
        out.flush();
        out.close();
    }
}
