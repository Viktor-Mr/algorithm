package AcWing._蓝桥._02_二分与前缀和;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/12 13:19
 */
public class _Case08_01激光炸弹 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int r;
    static int[][] f = new int[5010][5010];

    public static void main(String[] args) throws IOException {
        String[] s = in.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        r = Integer.parseInt(s[1])-1;
        int maxX = 0;
        int maxY = 0;
        for (int i = 0; i < n; i++) {
            s = in.readLine().split(" ");
            int x = Integer.parseInt(s[0]) + 1;
            int y = Integer.parseInt(s[1]) + 1;
            int w = Integer.parseInt(s[2]);
            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
            f[x][y] = w + f[x][y];
        }

        //计算前缀和
        for (int i = 1; i <= maxX; i++)
            for (int j = 1; j <= maxY; j++)
                f[i][j] = f[i][j - 1] + f[i][j];

        int ans = 0;
        //炸弹覆盖的范围
        //如果半径超出范围,也能加,但是只能加范围内的
        for (int i = 1; i <= maxX; i++) {
            for (int j = 1; j <= maxY; j++) {
                int num = 0;

                //xn表示能加到的行
                int xn = i+r;
                if ( i + r >= maxX) xn = maxX;
                //yn表示能加到的列
                int yn = j + r;
                if ( j + r >= maxY) yn = maxY;

                //每一行的炸弹数量相加
                for (int h = i; h <= xn; h++) {
                    num = num + f[h][yn] - f[h][j-1];
                }
                ans = Math.max(ans, num);
            }
        }
        System.out.println(ans);
    }
}
