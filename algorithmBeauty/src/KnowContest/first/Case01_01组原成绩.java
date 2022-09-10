package KnowContest.first;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/12/19 15:51
 */
public class Case01_01组原成绩 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int h = scanner.nextInt();
        int e = scanner.nextInt();
        System.out.println((int)(t*0.2+h*0.3+e*0.5));
    }

}
