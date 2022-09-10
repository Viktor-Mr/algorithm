package AcWing._蓝桥._01_递归与递推;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/4 20:51
 */
public class _Case05_01递归实现组合型枚举 {
    static int n;
    static int m;
    static int []f;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         m = sc.nextInt();
         f = new int[m+1];
         if (m > 0) {

                 dfs(1,0);//第一个数的值

         }else {
             System.out.println();
         }
    }
    /**
     * @date
     * @param k 第几个数
     */
    private static void dfs(int k,int p) {
        if ( n - p <  m - k  ) return; //减枝

        if ( k-1 ==m ){
            for (int i = 1; i <= m; i++) {
                System.out.print(f[i] + " ");
            }
            System.out.println();
            return;
        }

        // 从上一个值 p ~  n 都可以选择
        for (int i = p+1; i <= n; i++) {
            f[k] = i;
            dfs(k+1,i);
        }
    }
}
