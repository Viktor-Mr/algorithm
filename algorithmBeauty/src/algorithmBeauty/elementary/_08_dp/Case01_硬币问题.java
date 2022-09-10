package algorithmBeauty.elementary._08_dp;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/30 12:58
 */
public class Case01_硬币问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 6; i++) {
            cnts[i] = sc.nextInt();
        }
        int A = sc.nextInt();
        f(A, 5);
        System.out.println(res);
    }

    /**
     * @date  递归式 ,先尽量拿大的
     */
    static  int res ;
    private static void f(int a, int i) {
        if(a==0) return ;

        //a/coins[i]表示需要拿的 cnts[i]的枚数
        //如果不够
         if ( a / coins[i] > cnts[i]) {
             res += cnts[i];
             f( a - cnts[i]*coins[i], i-1 );
         }else {
             res += a/ coins[i];

             f( a - coins[i]*(a/ coins[i]), i-1 );
         }

    }

    static int[] cnts = new int[6];
    static int[] coins = {1, 5, 10, 50, 100, 500};

}
