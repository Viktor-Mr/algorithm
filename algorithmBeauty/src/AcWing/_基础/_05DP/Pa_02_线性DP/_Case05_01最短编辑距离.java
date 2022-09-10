package AcWing._基础._05DP.Pa_02_线性DP;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2022/4/8 12:40
 */
public class _Case05_01最短编辑距离 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String a = " "+ sc.next();
        int m = sc.nextInt();
        String b = " "+  sc.next();

        int [][]f = new int[n+1][m+1];

        //初始化假设 a为空 一直增加
        for (int i = 0; i <= m ; i++) f[0][i] = i;
        //初始化假设 b为空 一直删除
        for (int i = 0; i <= n ; i++) f[i][0] = i;

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                f[i][j]  = Math.min(f[i][j - 1] + 1, f[i - 1][j] + 1);
                if ( a.charAt(i) == b.charAt(j)) f[i][j] = Math.min(f[i-1][j-1] , f[i][j] );
                else f[i][j] = Math.min(f[i][j], f[i-1][j-1]+1);
            }
        }
        System.out.println(f[n][m]);
    }
}
