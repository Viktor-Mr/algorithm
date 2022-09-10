package AcWing._蓝桥._03_数学与简单DP;



import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/14 0:08
 */
public class _Case01_01买不到的数 {
    static int n;
    static int m;
    static int N = 1000005;
    static boolean[] f = new boolean[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        if (n > m) {
            n = n ^ m;
            m = n ^ m;
            n = n ^ m;
        }

        //只要连续 n个数有解, 后面的必然有解
        int ans = 0;
        int k = 0; //记录连续k个能满足
        for (int i = 0; i < 1000005 ; i++) {
            if (dfs(i, n, m)) {
                f[i] = true;
                k++;
            } else {
                ans = i;
                k = 0;
            }
            if (k >= n) {
                System.out.println(ans);
                break;
            }
        }
    }

    private static boolean dfs(int size, int q, int p) {
        if (f[size] || size%(q+p) ==0 || size % q == 0 || size % p == 0) return true;
        if(size >= p &&   dfs(size-p,p,q)) return true;
        if(size >= q &&   dfs(size-q,p,q)) return true;

        return false;
    }
}
