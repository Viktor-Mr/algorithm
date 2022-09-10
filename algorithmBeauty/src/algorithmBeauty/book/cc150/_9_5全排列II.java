package algorithmBeauty.book.cc150;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/23 0:10
 */
public class _9_5全排列II {
    static String [] a = {"1","2","3","4"};
    ArrayList <String> ans = new ArrayList<>();
    public static void main(String[] args) {

        recursion(0);
    }
    /**
     * @date 回溯  
     */
    private static void recursion(int i) {
        if (i == a.length) {
            System.out.println(Arrays.toString(a));
        }

        for (int j = i; j < a.length; j++) {
            swap(i,j);
            recursion(i+1);
            swap(i,j);
        }

    }

    private static void swap(int i , int j) {
        String tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
