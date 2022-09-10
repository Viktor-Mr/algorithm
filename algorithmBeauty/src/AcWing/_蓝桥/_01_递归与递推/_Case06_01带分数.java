package AcWing._蓝桥._01_递归与递推;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/9 0:25
 */
public class _Case06_01带分数 {
    static int n;
    static int N = 25;
    static int had_use[] = new int[N];
    static int ever[] = new  int[N];
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs_a(0,0); //第一个0表示我们已经用了多少个数字,后面那个0表示我们当前的a是多少
        System.out.println(ans);
    }

    private static void dfs_a(int num, int a_size) {
        if (a_size >= n) return ;

        dfs_c(num,a_size,0);//如果说a是满足情况的，那么我们就枚举一下c,后面那个0表示c的大小

        for (int i = 1; i <= 9; i++) {
            if ( had_use[i] == 0){  //这个数没有被使用过
                had_use[i] = 1;
                dfs_a(num+1,  a_size * 10 +i);
                had_use[i] = 0;
            }
        }
    }

    private static void dfs_c(int num, int a_size, int c_size) {
        if (num >= 9)  return;  //如果 a,c累计都大于等于了9个数,b就没得选

        if (check(a_size,c_size)) ans++;

        for (int i = 1; i <= 9 ; i++) {
            if ( had_use[i] == 0){  //这个数没有被使用过
                had_use[i] = 1;
                dfs_c(num+1,a_size,c_size * 10 +i);
                had_use[i] = 0;
            }
        }
    }

    private static boolean check(int a_size, int c_size) {

        int b = n * c_size - a_size * c_size;

        if (a_size == 0 || b == 0 || c_size == 0) return false;

        //拷贝数组 had_use 到 ever数组中
        ever = had_use.clone();

        //取出b的每位数字,保证没有在ever数组出现过才能保证为
        while (b > 0 ) {
            int t  = b%10;
            b/=10;
            if (t == 0 || ever[t] == 1)  return false;  //这个数为0 或者这个数已经出现过了
            ever[t] = 1;
        }
        for (int i = 1; i <= 9; i++)
            if (ever[i] == 0)
                return false;

        return true;
    }
}
