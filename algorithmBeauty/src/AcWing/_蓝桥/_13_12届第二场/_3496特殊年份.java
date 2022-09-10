package AcWing._蓝桥._13_12届第二场;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2022/4/6 14:10
 */
public class _3496特殊年份 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            int n = input.nextInt();
            if (n / 1000 == (n/10)%10 &&  n%10 == (n/100)%10 +1) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
