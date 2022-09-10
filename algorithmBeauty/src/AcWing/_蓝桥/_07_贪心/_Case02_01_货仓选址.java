package AcWing._蓝桥._07_贪心;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/31 22:22
 */
public class _Case02_01_货仓选址 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] =sc.nextInt();
        }
        Arrays.sort(a);
        int ans = 0;
        for (int i = 1; i <= n/2; i++) {
            ans += a[n-i+1]-a[i];
        }
        System.out.println(ans);
    }

}
