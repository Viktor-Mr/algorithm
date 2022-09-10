package AcWing._蓝桥._04__枚举与模拟与排序;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/16 10:53
 */
public class _Case05_01回文日期 {
    static int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = sc.nextInt();
        int max = sc.nextInt();
        int ans = 0;
        for (int i = min; i <= max; i++)
            if (checkDay(i))  //判断是否是合法年月
                if (checkAns(i))
                    ans++;
        System.out.println(ans);
    }

    // xxxx - yy -tt 01 - 02 -03 -04 -05 -06
    // 判断闰年
    private static boolean checkDay(int i) {
        int year = i / 10000;
        int month =  i % 10000 / 100;
        int day = i %100;


        if(day ==0 || month > 12 || month ==0) return false;

        if( day > days[month] && month != 2) return false;
        //闰年
        if ( month == 2) {
            if (year % 4 ==0 && year % 100 != 0 ||year%400 ==0 ) {
                if (day > 29) return false;
            }else {
                if (day > 28)  return false;
            }
        }

        return true;


    }

    private static boolean checkAns(int date) {
        // 2000 00 00
        int []s = new int[9];
        int i =  1;
        while (date > 0){
             s[i++] =  date % 10;
             date /= 10;
        }
        for (int j = 1; j <= 4; j++) {
            if (s[j] != s[8-j+1]) return false;
        }


        return true;
    }
}

