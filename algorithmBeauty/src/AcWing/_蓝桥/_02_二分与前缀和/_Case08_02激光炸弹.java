package AcWing._蓝桥._02_二分与前缀和;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/13 1:09
 */
public class _Case08_02激光炸弹 {


    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int r;
    static int N = 5010;

    static int[][] f = new int[N][N];

    public static void main(String[] args) throws IOException {
        String[] s = in.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        r = Integer.parseInt(s[1]);
        r = Math.min(5001, r);
        int maxX = 5001;
        int maxY = 5001;
        while (n-- > 0){
            s = in.readLine().split(" ");
            int x = Integer.parseInt(s[0]) + 1;
            int y = Integer.parseInt(s[1]) + 1;
            int w = Integer.parseInt(s[2]);
            f[x][y] = w + f[x][y];
        }
        //预处理前缀和
        for (int i = 1; i <= maxX; i++)
            for (int j = 1; j <= maxY; j++)
                f[i][j] += (f[i - 1][j] + f[i][j - 1] - f[i - 1][j - 1]);

        int ans = 0;
        for (int i = r; i <= maxX; i++) {
            for (int j = r; j <= maxY; j++) {
                ans = Math.max(ans, f[i][j] - f[i - r][j] - f[i][j - r] + f[i - r][j - r]);
            }
        }
        System.out.println(ans);
        in.close();
    }
}
