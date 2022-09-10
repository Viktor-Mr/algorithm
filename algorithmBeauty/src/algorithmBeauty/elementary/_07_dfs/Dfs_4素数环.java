package algorithmBeauty.elementary._07_dfs;

import org.junit.internal.Checks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/26 12:54
 */
public class Dfs_4素数环 {

    static  int n ;
    static  int ans[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ans = new int[n];
        ans[0] = 1;
        dfs(1);
    }

    private static void dfs(int k) {
        if (n == k && isP(ans[0] + ans[n-1]) ){  // 最后一个和第一个的和为素数

            System.out.println(Arrays.toString(ans));
            return;
        }

        for (int i = 2; i <= n; i++) {
            if (checks(i,k)){
                ans[k] = i;
                dfs(k+1);
                //ans[k] = 0;
            }
        }

    }

    private static boolean checks(int p, int k) {
        //首选如果要选择p,p就不能出现在ans数组中,其次p+ans[k-1]需要为素数
        for (int i = 0; i < k; i++) {
            if (ans[i] == p )return false;
        }
        if (isP(p+ans[k-1]) ){
            return true;
        }
        return false;
    }

    private static boolean isP(int n) {
        for (int i = 2; i*i<= n; i++) {
            if ( n % i == 0)return false;
        }
        return true;
    }
}
