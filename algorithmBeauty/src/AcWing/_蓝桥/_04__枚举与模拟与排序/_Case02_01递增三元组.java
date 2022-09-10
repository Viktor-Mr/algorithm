package AcWing._蓝桥._04__枚举与模拟与排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/16 0:50
 */
public class _Case02_01递增三元组 {
    public static void main(String[] args) throws IOException {
        final int N = 100010;
        int[] as = new int[N]; // as[i]表示在A[]中有多少个数小于b[i]
        int[] cs = new int[N]; // cs[i]表示在C[]中有多少个数大于b[i]
        int[] s = new int[N];
        int[] a = new int[N];
        int[] b = new int[N];
        int[] c = new int[N];
        int[] cnt = new int[N];
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        String[] s1 = in.readLine().split(" ");
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s1[i])+1;
        s1 = in.readLine().split(" ");
        for (int i = 0; i < n; i++) b[i] = Integer.parseInt(s1[i])+1;
        s1 = in.readLine().split(" ");
        for (int i = 0; i < n; i++) c[i] = Integer.parseInt(s1[i])+1;

        for (int i = 0; i < n; i++) cnt[a[i]]++;
        for (int i = 1; i < N; i++) s[i] = s[i - 1] + cnt[i];
        for (int i = 0; i < n; i++) as[i] = s[b[i] - 1];


        Arrays.fill(cnt, 0);
        Arrays.fill(s, 0);
        for (int i = 0; i < n; i++) cnt[c[i]]++;
        for (int i = 1; i < N; i++) s[i] = s[i - 1] + cnt[i];
        for (int i = 0; i < n; i++) cs[i] = s[N - 1] - s[b[i]];

        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (long)as[i] * cs[i];
        }
        System.out.println(res);
    }
}
