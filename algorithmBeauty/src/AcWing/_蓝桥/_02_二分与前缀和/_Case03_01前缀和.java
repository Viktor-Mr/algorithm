package AcWing._蓝桥._02_二分与前缀和;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/11 13:03
 */
public class _Case03_01前缀和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int []f = new int[n+1];
        int a = 0; //前缀和
        for (int i = 1; i <= n; i++) {
            a = sc.nextInt();
            f[i] = a +f[i-1];
        }
        //System.out.println(Arrays.toString(f));
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(f[y] -f[x-1]);
        }
    }
}
