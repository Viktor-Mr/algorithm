package algorithmBeauty.book.cc150;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/21 12:48
 */
public class _9_8硬币表示 {
    static int []a = {1, 5, 10, 25};
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(way1(n));
        System.out.println(way2(n));
    }

    private static int way2(int n) {
        int [][]dp  = new int[a.length+1][n+1];
        for (int i = 0; i < a.length+1; i++) {
            dp[i][0] = 1;//凑出面值0,只有一种可能,第一列初始化为1
        }
        for (int j = 1; j <= n ; j++) {
            dp[0][j] = 1;//用1来凑任何面值都只有一种凑法,第一行初始化为1
        }
        for (int i = 1; i <= a.length-1; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k*a[i] <= j; k++) {
                    dp[i][j] += dp[i-1][j- k*a[i]];
                }
            }
        }



        return dp[3][n];
    }

    /**
     * 递归方式
     * @return int
     */
    private static int way1(int n) {
        int ans = recursion( n,3);
        return ans;
    }

    private static int recursion(int n, int mon) {
        if (mon == 0) return 1;

        int  ans = 0;
        for (int i = 0; i*a[mon] <= n; i++) {
          ans+=  recursion(n-i*a[mon],mon-1);
        }
        return ans;
    }

}
