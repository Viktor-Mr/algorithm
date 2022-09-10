package AcWing._蓝桥._01_递归与递推;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/9 9:40
 */
public class _Case07_01飞行员兄弟 {
    static char[][] a = new char [10][10];
    static boolean[][] c = new boolean [10][10];  //当前记录的最小的把手数  默认为false 不点开关
    static boolean[][] d = new boolean [10][10]; //历史记录的最小的把手数
    static int ans  = (int) (1f/0f);
    static int now;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i <= 3; i++) a[i] = sc.nextLine().toCharArray();

        dfs(0,0,0);
        System.out.println( ans);
        for (int i = 0; i <= 3; i++)
            for (int j = 0; j <= 3; j++)
                if ( d[i][j] ) {
                    int x = i+1;
                    int y = j+1;
                    System.out.println(x + " " + y);
                };
    }


    // false 是使用了这把锁  现在是第k个
    private static void dfs(int x, int y, int k) {
        if ( k >= 16  )  return;

        if ( check() ) {
            if(now < ans){
                ans = now;  //更新最小步数
                for (int i = 0; i <= 3 ; i++)
                    for (int j = 0; j <= 3;  j++) {
                        d[i][j] = c[i][j];
                    }
            }
        }

        //选   ( 改变 - >  回溯 )
        now++;
        change( k/4, k%4,true);  //改变当前选的坐标
        dfs( k/4, k%4,k+1);        //x, y 这个坐标选了 , 下一个数
        change( k/4, k%4,false);  //恢复当前选的坐标
        now --;

        // 不选 x, y 这个坐标不选 , 下一个数
        dfs( k/4, k%4,k+1);
    }

    private static void change(int x, int y , boolean flag) {
        c[x][y] = flag;  //这个坐标选了, 标记为true
        for (int i = 0; i <= 3; i++)
            for (int j = 0; j <= 3; j++)
                if ( i == x || j == y ) {
                    if (a[i][j] == '+') a[i][j] = '-';
                    else a[i][j] = '+';
                }
    }

    //通过 a 数组检查
    private static boolean check() {
        for (int i = 0; i <= 3; i++)
            for (int j = 0; j <= 3; j++)
                if (a[i][j] == '+')
                    return false;
        return true;
    }
}
