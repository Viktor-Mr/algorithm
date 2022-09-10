package AcWing;


import java.util.Scanner;

public class Main {
    //给定一个长度为n的数列，将这个数列按从小到大的顺序排列。1<=n<=200
    static boolean [] st = new boolean[21];
    static  int []c = new int[21];
    static  int k;
    static  int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();

        dfs(1);
        System.out.println(ans);

    }

    private static void dfs(int p) {
        if(p > k) return;
        for (int i = 1; i <= k ; i++) {
            if (!st[i] && check(p,i)){
                c[p] = i;
                st[i] = true;
                if (p>=2) ans++;

                dfs(p+1);
                st[i] = false;
            }
        }
    }

    //在 第 x 的位置放入 p
    private static boolean check(int x, int p) {
        if(x == 1 || x == 2) return true;
        if (c[x-1] > c[x-2] && p < c[x-2] ) return true;
        if (c[x-1] < c[x-2] && p > c[x-2] ) return true;
        return  false;
    }
}
