package AcWing._蓝桥._03_数学与简单DP;

import sun.security.krb5.internal.ccache.CCacheOutputStream;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/14 16:19
 */
public class _Case02_02蚂蚁感冒 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fs = new int[n];
        int flag = 0;
        for (int i = 0; i < n; i++)
            fs[i] = sc.nextInt();
        int l = 0;
        int r = 0;
        for (int i = 1; i < n; i++) {
            //左边向右走  右边向左走
            if (Math.abs(fs[i]) < Math.abs(fs[0]) && fs[i] > 0) l++;
            else if (Math.abs(fs[i]) > Math.abs(fs[0]) && fs[i] < 0) r++;
        }
        if (fs[0] > 0 && r==0 || fs[0] < 0 && l==0) System.out.println("-1");
        else System.out.println(r+l+1);
    }

}
