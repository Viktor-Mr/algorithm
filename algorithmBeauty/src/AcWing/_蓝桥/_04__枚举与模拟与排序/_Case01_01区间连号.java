package AcWing._蓝桥._04__枚举与模拟与排序;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/15 23:23
 */
public class _Case01_01区间连号 {
   static  int []d = new int[10010];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []f = new int[10010];

        for (int i = 1;  i <= n ; i++) {
            f[i] = sc.nextInt();
        }
        int ans = n;
        for (int i = 1; i < n ; i++) {
            int max = f[i];
            int min = f[i];
            d[ f[i]] ++;
            for (int j = i+1; j <= n; j++) {
                 max = Math.max(max,f[j]);
                 min = Math.min(min,f[j]);
                 d[ f[j]] ++;
                if(check(min,max)) ans++;
            }
            Arrays.fill(d,0);
        }
        System.out.println(ans);

  }

    private static boolean check(int min, int max) {
        for (int i = min; i <= max ; i++) {
            if (d[i] != 1) return false;
        }
        return  true;
    }
}
