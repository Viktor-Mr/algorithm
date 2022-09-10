package AcWing._蓝桥._06_双指针与BFS与图论;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/21 22:57
 */
public class _Case07_02全球变暖 {
    static int N = 1010;
    static char[][] tu = new char[N][N];
    static boolean[][] ts = new boolean[N][N];

    static int[] xp = new int[]{1, -1, 0, 0};
    static int[] yp = new int[]{0, 0, -1, 1};
    static int total  ;
    static int bound;

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        for (int i = 1; i <= n; i++) {
            char[] chars = in.readLine().toCharArray();
            m = chars.length;
            for (int j = 1; j <= m; j++) {
                tu[i][j] = chars[j - 1];
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                ans += (dfs(i, j));
                total = 0;
                bound = 0;
            }
        }
        System.out.println(ans);
    }

    //当前位置连通陆地的数量total，以及被淹没陆地的数量bound
    // 若total == bound表示完整淹没的一个岛屿
    private static int dfs(int x, int y) {

        if (tu[x][y] == '.' || ts[x][y]) return 0;
        ts[x][y] = true;
        total ++;
        boolean is_bound = false;//判断岛屿是否被淹没
        for (int i = 0; i < 4; i++) {
            int a = x + xp[i];
            int b = y + yp[i];
            if (a <= 0 || a > n || b <= 0 || b > m) continue;
            if (ts[a][b] ) continue;
            if (tu[a][b] == '.'){
                is_bound = true;
                continue;
            }
            dfs(a, b);
        }
        if (is_bound) bound ++;
        return total == bound ? 1 : 0;
    }


}

