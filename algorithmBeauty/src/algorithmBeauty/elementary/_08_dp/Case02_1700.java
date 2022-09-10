package algorithmBeauty.elementary._08_dp;

import sun.applet.Main;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/30 13:40
 */
public class Case02_1700 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] speed = new int[n];
            for (int j = 0; j < n; j++) {
                speed[j] = sc.nextInt();
            }
            //排序
            Arrays.sort(speed);
            f(n, speed);
        }
    }

    private static void f(int n, int[] speed) {
        int ans = 0;
        while (n > 0) {
            if (n == 1) {
                ans += speed[0];
                n--;

            } else if (n == 2) {
                ans += speed[1];
                n -=2;
            }else {
                //1，2出发，1返回，最后两名出发，2返回
                int s1 = speed[1] + speed[0] + speed[n - 1] + speed[1];
                //1，3出发，1返回，1，4出发，1返回，1，2过河
                int s2 = speed[0] + speed[n - 1] + speed[n - 2] + speed[0];
                ans +=Math.min(s1, s2);
                n -= 2;
            }
        }
        System.out.println(ans);
    }
}
