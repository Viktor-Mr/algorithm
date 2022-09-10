package AcWing._蓝桥._11_11届第一场;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2022/3/31 13:06
 */
public class _2067走方格 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int [][]ans = new int[n+1][m+1];
        ans[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(i==1 && j==1)  continue;
                if (i%2 == 1 || j %2 ==1) {
                    ans[i][j] =  ans[i][j-1] + ans[i-1][j];
                }
            }
        }
        System.out.println(ans[n][m]);
    }
}
