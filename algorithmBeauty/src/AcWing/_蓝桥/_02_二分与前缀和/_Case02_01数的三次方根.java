package AcWing._蓝桥._02_二分与前缀和;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/11 12:43
 */
public class _Case02_01数的三次方根 {
    public static void main(String[] args) {
        double n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextDouble();
        double l = -10000;
        double r =  10000;
        while ( r - l > 1e-8) {
            double mid = (r+l)/2;
            if ( mid*mid*mid >= n) r = mid  ;
            else  l = mid;
        }
        System.out.printf("%f\n",l);
    }
}
