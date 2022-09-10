package AcWing._蓝桥._11_11届第一场;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2022/4/1 14:56
 * 前缀和
 */
public class _2875超级胶水 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long res = 0;
        long sum = sc.nextLong();
        for (int i = 1; i < n; i++) {
            long j = sc.nextLong();
            res += sum *j;
            sum += j;
        }
        System.out.println(res);
    }
}
