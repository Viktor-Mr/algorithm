package AcWing._蓝桥._06_双指针与BFS与图论;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/21 21:10
 */
public class _Case06_01地牢大师 {
    static int N = 110;
    static char[][][] tu = new char[N][N][N];
    static int[][][] ts = new int[N][N][N];  //标记走过的步数
    static int l, n, m;
    static int sl, sn, sm;
    static int[] lp = {0, 0, 1, -1, 0, 0};
    static int[] xp = {0, 0, 0, 0, 1, -1};
    static int[] yp = {1, -1, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        l = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);
        m = Integer.parseInt(s[2]);
        while (l != 0) {
            for (int k = 1; k <= l; k++) {
                for (int i = 1; i <= n; i++) {
                    char[] chars = in.readLine().toCharArray();
                    for (int j = 1; j <= m; j++) {
                        tu[k][i][j] = chars[j - 1];
                        if (tu[k][i][j] == 'S') {
                            sl = k;
                            sn = i;
                            sm = j;
                        }
                    }
                }
                in.readLine(); //读入空行
            }
            int b = bfs();
            if (b != -1) System.out.println("Escaped in " + b + " minute(s).");
            else System.out.println("Trapped!");

            s = in.readLine().split(" ");
            l = Integer.parseInt(s[0]);
            n = Integer.parseInt(s[1]);
            m = Integer.parseInt(s[2]);
        }
    }

    private static int bfs() {
        //初始化
        for (int i = 0; i <= l; i++) for (int j = 0; j <= n; j++) Arrays.fill(ts[i][j], -1);
        ts[sl][sn][sm] = 0;
        LinkedList<PD> queue = new LinkedList<>();
        queue.add(new PD(sl, sn, sm));

        while (!queue.isEmpty()) {
            PD poll = queue.poll();

            for (int i = 0; i <= 5; i++) {
                int nl = poll.l + lp[i];
                int nx = poll.n + xp[i];
                int ny = poll.m + yp[i];

                if (nl <= 0 || nl > l || nx <= 0 || nx > n || ny <= 0 || ny > m) continue;
                if (tu[nl][nx][ny] == '#' || ts[nl][nx][ny] != -1) continue;
                ts[nl][nx][ny] = ts[poll.l][poll.n][poll.m] + 1;
                if (tu[nl][nx][ny] == 'E') return ts[nl][nx][ny];

                queue.add(new PD(nl,nx,ny));
            }

        }
        return -1;
    }
}

class PD {
    int l;
    int n;
    int m;

    public PD(int l, int n, int m) {
        this.l = l;
        this.n = n;
        this.m = m;
    }
}
