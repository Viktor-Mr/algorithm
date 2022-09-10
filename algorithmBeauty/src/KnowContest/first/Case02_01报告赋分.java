package KnowContest.first;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/12/19 15:55
 */
public class Case02_01报告赋分 {
    static  int  n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        while (n-- > 0) {
            int a = scanner.nextInt();
            int p = scanner.nextInt();
            int  ans = a;
            if (p < 16) {
                ans -= 10;
            }else if (p > 20){
                ans -= (p-20);
            }
            if (ans<0) System.out.println(0);
            else System.out.println(ans);
        }
    }
}
