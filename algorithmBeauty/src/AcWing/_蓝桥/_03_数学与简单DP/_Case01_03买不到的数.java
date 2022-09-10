package AcWing._蓝桥._03_数学与简单DP;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/14 13:20
 */
public class _Case01_03买不到的数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int  n = sc.nextInt();
       int  m = sc.nextInt();
        System.out.println( (n-1)*(m-1) -1);
    }
}
