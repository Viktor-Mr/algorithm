package AcWing._蓝桥._02_二分与前缀和;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/12 12:46
 */
public class _Case07_01分巧克力 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int k;
    static int[] h;
    static int[] w;

    public static void main(String[] args) throws IOException {
        String[] init = in.readLine().split(" ");
        n = Integer.parseInt(init[0]);
        k = Integer.parseInt(init[1]);
        h = new int[n + 1 + 1];
        w = new int[n + 1 + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
           init = in.readLine().split(" ");
            h[i] = Integer.parseInt(init[0]);
            w[i] = Integer.parseInt(init[1]);
            max = Math.max(max,Math.min(h[i],w[i]));

        }
        int l = 1;
        int r = max;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            //如果可以切除mid
            if (check(mid)) l = mid;
            else r = mid - 1;
        }
        System.out.println(l);

        in.close();

    }

    private static boolean check(int mid) {
        //判断能否切成 mid ;
        int num = 0;
        //找到每一个蛋糕能切成多少个 大小为mid
        for (int i = 1; i <= n; i++) {
            num += (h[i] / mid) *  (w[i] / mid);
            if (num >= k) return true;
        }
        return false;
    }
}
