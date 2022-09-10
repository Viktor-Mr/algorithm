package AcWing._蓝桥._05_树状数组与线段树;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/19 14:57
 */
public class _Case07_02螺旋折线 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        long ans = 0;

        //左上角
        if (Math.abs(x) <= y) {
            int n = y;
            ans = (2L * n - 1) * (2L * n ) + x + n;
        } else if (Math.abs(y) <= x) {
            int n = x;
            ans = 2L * n * 2L * n  +  n - y;
        } else if (Math.abs(x) <= Math.abs(y) + 1 && y < 0) {
            int n = Math.abs(y);
            ans =  2L * n * (2L * n + 1) + n - x;
        } else {
            int n = Math.abs(x);
            ans = (2L * n - 1) * (2L * n-1) + (n -1) + y;
        }
        System.out.println(ans);
    }
}
