package AcWing._蓝桥._11_11届第一场;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author fu-xiao-liu
 * @Date 2022/3/31 22:21
 * 思路 ( aj * 10^i  + ai )% k = 0
 *      aj * 10^i = (-ai)%k
 *      aj * 10^i = (k - ai)%k
 *  1.预处理 t = aj* 10^0 % k 保存在 ans[0][余数 t]
 *          t = aj* 10^1 % k 保存在 ans[1][余数 t]
 *          t = aj* 10^2 % k 保存在 ans[2][余数 t]
 *
 *  2. 重新遍历 ai, 得出需要那个 ans[i][aj] :   aj * 10^i = (-ai)%k
 *
 *  3. 去重 判断是否 需要找到的 aj 就是 ai本身
 */
public class _2068整数拼接 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[] a = new int[n + 1];
        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);


        //1.预处理  ans[i][j]  =  (aj * 10^i)%k
        int[][] ans = new int[11][n + 1];
        for (int j = 0; j < n; j++) {
            int t = a[j] % m;
            for (int i = 0; i < 11; i++) {
                ans[i][t]++;
                t = t * 10 % m;
            }
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            int t = a[i] % m;
            int len = String.valueOf(a[i]).length();
            result += ans[len][((m - t) % m)];
            long r = t;
            //判断是否当前的 aj*10^i = ai (mod m)  aj 是否就是ai
            while (len-- > 0) r = r * 10 % m;
            if (r == (m - t) % m) result--;
        }
        System.out.println(result);

    }
}
