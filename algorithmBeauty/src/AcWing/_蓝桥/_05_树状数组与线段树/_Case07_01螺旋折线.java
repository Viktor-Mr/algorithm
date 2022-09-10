package AcWing._蓝桥._05_树状数组与线段树;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/19 9:50
 */
public class _Case07_01螺旋折线 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        long k = Math.max(Math.abs(x), Math.abs(y));

        long  ans = 0;

        if ( y == -k &&   -k-1 < x && x<0) {
            k++;
        }

        //计算内层的数量
        for (int i = 1; i < k; i++) {
            ans += 8L * i;
        }
        //左上角的情况
        if (x < 0 && y > 0) {
            ans += k + (k+x) + y;
        } else if (x >= 0 && y >= 0) {
            ans +=  3L * k + x + (k - y);
        } else if (x >= 0 ) {
            ans += 5L * k + (k - x) +  ( - y);
        } else {  // x < 0  y < 0
            //这个是起点开始的情况
           ans +=    (k + y);
            //在起点前的;
            if (x != -k){
                ans  -= ( k + x);
            }
        }
        System.out.println(ans);
    }
}
/**
 * -561780031 999802475
 *  3998419954502919994
 *  3998419950207952698
 *
 * */