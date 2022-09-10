package AcWing._蓝桥._06_双指针与BFS与图论;

import java.io.*;
import java.util.*;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/22 20:28
 */
public class _Case08_01大臣的旅费 {
    static int N = 100010;
    static int n;
    static int[] dist = new int[N];
    static List<int[]>[] h = new ArrayList[N];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine().trim());
        for (int i = 0; i < N; i++) {
            h[i] = new ArrayList<int[]>();
        }
        for (int i = 0; i < n - 1; i++) {
            String[] s = in.readLine().split(" ");
            int a = Integer.parseInt(s[0].trim());
            int b = Integer.parseInt(s[1].trim());
            int c = Integer.parseInt(s[2].trim());
            h[a].add(new int[]{b, c});
            h[b].add(new int[]{a, c});
        }

        dfs(1, -1, 0);
        int u = 1;
        for (int i = 1; i <= n; i++)
            if (dist[i] > dist[u]) u = i;

        dfs(u, -1, 0);
        System.out.println(u);
        long maxLong = 0;
        for (int i = 1; i <= n; i++)
            if (dist[i] > maxLong) maxLong = dist[i];

        System.out.println(maxLong * 10 + (maxLong * (maxLong + 1) >> 1));
    }

    private static void dfs(int u, int father, int distance) {
        //走到这个点的距离
        dist[u] = distance;
        for (int[] can : h[u]) {
            if (can[0] != father) dfs(can[0], u, distance + can[1]);
        }
    }
}
