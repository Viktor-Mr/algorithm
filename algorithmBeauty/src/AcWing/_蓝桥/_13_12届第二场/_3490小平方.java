package AcWing._蓝桥._13_12届第二场;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2022/4/6 14:31
 */
public class _3490小平方 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (((i * i) % n) < (n / 2.0)) {
                System.out.println(n/2);
                ans++;
            }

        }
        System.out.println(ans);
    }

}
