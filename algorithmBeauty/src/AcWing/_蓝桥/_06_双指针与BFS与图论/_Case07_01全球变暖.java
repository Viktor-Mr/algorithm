package AcWing._蓝桥._06_双指针与BFS与图论;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/21 21:47
 */
public class _Case07_01全球变暖 {
    static int N = 1010;
    static char[][] tu = new char[N][N];
    static boolean[][] ts = new boolean[N][N];
    static char[][] tu2 = new char[N][N];
    static boolean[][] ts2 = new boolean[N][N];
    static int[] xp = new int[]{1, -1, 0, 0};
    static int[] yp = new int[]{0, 0, -1, 1};

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        for (int i = 1; i <= n; i++) {
            char[] chars = in.readLine().toCharArray();
            m = chars.length;
            for (int j = 1; j <= m; j++) {
                tu[i][j] = chars[j - 1];
                tu2[i][j] = chars[j - 1];

            }
        }
        int MaxAns = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                MaxAns += (dfs2(i, j));
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (tu[i + 1][j] == '.' || tu[i - 1][j] == '.' || tu[i][j + 1] == '.' || tu[i][j - 1] == '.') continue;
                    ans += (dfs(i, j));
            }
        }
        System.out.println(MaxAns - ans);
    }

    private static int dfs(int x, int y) {
        if (tu[x][y] == '.' || ts[x][y]) return 0;
        ts[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int a = x + xp[i];
            int b = y + yp[i];
            if (a <= 0 || a > n || b <= 0 || b > m) continue;
            if (ts[a][b] || tu[a][b] == '.') continue;
            dfs(a, b);
        }
        return 1;
    }

    private static int dfs2(int x, int y) {
        if (tu2[x][y] == '.' || ts2[x][y]) return 0;
        ts2[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int a = x + xp[i];
            int b = y + yp[i];
            if (a <= 0 || a > n || b <= 0 || b > m) continue;
            if (ts2[a][b] || tu2[a][b] == '.') continue;
            dfs2(a, b);
        }
        return 1;
    }
}
