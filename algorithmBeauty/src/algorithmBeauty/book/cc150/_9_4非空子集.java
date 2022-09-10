package algorithmBeauty.book.cc150;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/22 11:14
 */
public class _9_4非空子集 {
    static  int[] a ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i+1;
        }

        way1();
        //way2();
        
    }

    /**
     * @date 递推写法
     * 利用二进制
     * 判断  0 0 1 选第一位
     *      0 1 0 选第二位
     *      0 1 1 选第一二位
     *        ...  ... 把所有可能选完
     */
    private static void way2() {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int n = (int) Math.pow(2,a.length);
        for (int j = 1; j <= n-1; j++) {
            ArrayList<Integer> li = new ArrayList<>();
            int k = 1;
            int i = j;
            while ( i != 0){
                if ( i%2 == 1){
                    li.add(a[k-1]);
                }
                k++;
                i /= 2;
            }
            list.add(li);
        }
        System.out.println();
        System.out.println(list);
    }


    /**
     * @date 递归写法  
     */
    private static void way1() {
        String s = new String();
        recursion(0,s);
    }

    private static void recursion(int n, String s) {
        if (n >= a.length) {
                if (s.length() > 0) {
                    System.out.println( s.substring(1));
                }else{
                    System.out.println();
                }



            return;
        }
        recursion(n+1,s+" " +a[n]);
        recursion(n+1,s);
    }
}
