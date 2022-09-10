package KnowContest.first;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/12/19 16:04
 */
public class Case03_01竞争得分 {
    static  int  n;
    static  int  a[] = new int[1010];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int max  = Integer.MIN_VALUE ;
        int min  = Integer.MAX_VALUE ;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            if (a[i] > max)  max = a[i];
            if (a[i] < min)  min = a[i];
        }

        for (int i = 0; i < n; i++) {

            System.out.print((int) ((a[i] - min)*1.0/(max- min) *100) + " ");
        }
    }
}
