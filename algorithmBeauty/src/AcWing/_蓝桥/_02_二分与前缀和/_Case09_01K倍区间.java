package AcWing._蓝桥._02_二分与前缀和;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author fu-xiao-liu
 * @Date 2021/11/12 13:20
 * (S[R]  - S[L])   % k == 0
 */
public class _Case09_01K倍区间 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static int[] f = new int[100010];    //记录前缀和
    static long[] cnt = new long[100010]; //cnt[i] 记录的是 余数为i的前缀和个数

    public static void main(String[] args) throws IOException {
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        for (int i = 1; i <= n; i++)
            f[i] = f[i - 1] + Integer.parseInt(in.readLine());

        long ans = 0;
        cnt[0] = 1;
        // r 的范围是 1 ~ n
        // l 的范围是 1 ~ r-l
        for (int i = 1; i <= n; i++) {
            /**
             * 下面这里就相当于,原来的第二层循环.
             *  (f[r] - f [l-1])%k == 0, ans ++
             *   上面等价于
             *   f[r]%k == f[l-1]%k  , ans +=  cnt[f[r]%k] 翻译:ans = cnt[i]前缀和求余为i   + ans
             *
             *
             *    1 ~ i-1   2 ~ i-1  3 ~ i-1  ...  i-2 ~ i-1  i-1 ~ i-1 的i-1 组数中找出余数为  i%k 的共有几组
             *    做一个数组cnt 记录 cnt[i] 余数为i的前缀和个数
             *   既 在前面 i-1
             */
            ans += cnt[ (f[i] % k)];
            cnt[(f[i] % k)]++;

        }
        System.out.println(ans );
        in.close();
    }

}
