package AcWing._蓝桥._04__枚举与模拟与排序;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/16 9:55
 */
public class _Case03_01特别数的和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            int t = i;
            while (t > 0) {
                if (t%10 == 2 || t % 10 == 0 || t % 10 == 1 || t % 10 == 9) {
                    ans+=i;
                    break;
                }
                t/=10;
            }
        }
        System.out.println(ans);
    }
}