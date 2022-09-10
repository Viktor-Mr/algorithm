package AcWing._基础._05DP.Pa_02_线性DP;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2022/4/8 11:00
 */
public class _Case04_01最长公共子序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        //加多一个空格 避免下面j-1 越界
        String a = " " + sc.next();
        String b =  " " +sc.next();
        int [][]fs  = new  int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                fs[i][j] = Math.max(fs[i][j-1],fs[i-1][j]);
                if (a.charAt(i)==b.charAt(j)) fs[i][j] = Math.max(fs[i][j], fs[i-1][j-1]+1);
            }
        }
        System.out.println(fs[n][m]);
    }
}
