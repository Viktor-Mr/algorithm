package AcWing._蓝桥._04__枚举与模拟与排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/16 10:25
 */
public class _Case04_01错误票据 {
    static int []f  = new  int[100010];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int  n = Integer.parseInt(in.readLine());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            String[] s = in.readLine().split(" ");
            for (String s1: s) {
                f[Integer.parseInt(s1)]++;
                max = Math.max(Integer.parseInt(s1),max);
                min = Math.min(Integer.parseInt(s1),min);
            }
        }
        int a = 0;
        int b = 0;
        for (int i = min; i <= max; i++) {
            if (f[i] == 0) a = i;
            if (f[i] == 2) b = i;
        }
        System.out.println( a + " " + b);
    }
}
