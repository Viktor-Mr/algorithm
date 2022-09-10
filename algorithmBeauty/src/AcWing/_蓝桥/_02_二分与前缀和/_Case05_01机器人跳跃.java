package AcWing._蓝桥._02_二分与前缀和;

import java.io.*;
import java.net.SocketTimeoutException;
import java.util.Arrays;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/12 10:28
 */
public class _Case05_01机器人跳跃 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[] f;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(in.readLine());
        f = new int[n + 2];
        String[] init = in.readLine().split(" ");
        for (int i = 1; i <= n; i++) f[i] = Integer.parseInt(init[i-1]);

        int l = 0;
        int r = (int) 1e5;
        while (l < r) {
            int mid = (r + l) >> 1;
            if ((check(mid))) r = mid;
            else l = mid + 1;
        }
        System.out.println(r);

    }

    private static boolean check(int e) {
        for (int i = 1; i <= n; i++) {
            e = e * 2 - f[i];
            if (e > 100010) return true;
            if (e < 0 ) return false;
        }
        return true;
    }
}
