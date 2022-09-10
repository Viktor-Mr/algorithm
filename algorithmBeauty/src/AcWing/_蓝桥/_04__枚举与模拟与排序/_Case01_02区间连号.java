package AcWing._蓝桥._04__枚举与模拟与排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/15 23:23
 */
public class _Case01_02区间连号 {

    public static void main(String[] args) throws IOException {
        BufferedReader  in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        int []f = new int[10010];
        String[] s = in.readLine().split(" ");
        for (int i = 1;  i <= n ; i++) {
            f[i] = Integer.parseInt(s[i-1]);
        }
        int ans = n;
        for (int i = 1; i < n ; i++) {
            int max = f[i];
            int min = f[i];

            for (int j = i+1; j <= n; j++) {
                max = Math.max(max,f[j]);
                min = Math.min(min,f[j]);

                if (max - min == j - i) {
                    ans++;
                }
            }

        }
        System.out.println(ans);

    }


}
