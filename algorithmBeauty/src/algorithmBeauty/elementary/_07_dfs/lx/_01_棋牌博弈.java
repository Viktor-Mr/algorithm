package algorithmBeauty.elementary._07_dfs.lx;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/27 19:25
 */
public class _01_棋牌博弈 {
    static  int a[] =   {1,2,100,4};
    public static void main(String[] args) {
        int n = a.length;
        int ans = way1(n);;
        System.out.println(ans);
        System.out.println(way2(n));

    }

    private static int way2(int n) {
        int [][]f = new int[n][n];
        int [][]s = new int[n][n];
        for (int i = 0; i < n; i++) {
            f[i][i] = a[i];
        }
        for (int j = 1; j < n; j++) {
            for (int i = j-1; i >= 0  ; i--) {
                f[i][j] = Math.max(a[i]+s[i+1][j],a[j]+ s[i][j-1]);
                s[i][j] = Math.min(f[i+1][j],f[i][j-1]);
            }
        }
      return   Math.max(f[0][n-1],s[0][n-1]);
    }

    private static int way1(int n) {
        if (n == 0) {
            return 0;
        }
        return Math.max(f(0,n-1),s(0,n-1));
    }
    private static int f(int i, int j) {
        if (i == j) {
            return a[i];
        }
        //i!=j  要么第一张 要么拿最后一张
        int max = Math.max(a[i] + s(i + 1, j), a[j] + s(i, j - 1));

        return max;
    }
    private static int s(int i, int j) {
        if (i == j) {
            return 0;
        }
        int min = Math.min( f(i+1,j) ,f(i,j - 1));
        return min;
    }
}
