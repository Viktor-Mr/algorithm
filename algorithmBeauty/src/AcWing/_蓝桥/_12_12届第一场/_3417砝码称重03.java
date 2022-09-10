package AcWing._蓝桥._12_12届第一场;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author fu-xiao-liu
 * @Date 2022/4/1 22:20
 * 记忆化搜索避免重复计算
 *
 */
public class _3417砝码称重03 {
    static int N = 110;
    static int max = 200010;
    static int n;
    static int[] w = new int[N];
    static boolean[] res = new boolean[max];
    //这里对爆搜的剪枝是如果前i个数可以凑出来j就跳过不继续搜索了
    static boolean[][] f = new boolean[N][max];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);

        input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            w[i] = Integer.parseInt(input[i - 1]);
        }
        dfs(1, 0);
        int ans = 0;
        for (int i = 1; i < max; i++) if (res[i] == true) ans++;
        System.out.println(ans);
    }

    static void dfs(int u, int sum) {
        if (f[u][sum] == true) return;
        f[u][sum] = true;
        res[sum] = true;

        //如果码数号数大于拥有的砝码数
        if (u > n) {return;}


        dfs(u+1,sum+w[u]);
        dfs(u+1,Math.abs(sum-w[u]));
        dfs(u+1,sum);

    }
}
