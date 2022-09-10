package AcWing._蓝桥._12_12届第一场;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author fu-xiao-liu
 * @Date 2022/4/1 22:12
 * 通过 Set去重
 */
public class _3417砝码称重02 {
    static int N = 110;
    static int n;
    static int[] w = new int[N];
    //set不保存重复元素
    static Set hs = new HashSet();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);

        input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++)
        {
            w[i] = Integer.parseInt(input[i-1]);
        }
        dfs(0, 0);
        System.out.println(hs.size());
    }

    static void dfs(int u, int sum){
        if (u > n) return;
        if (sum > 0) hs.add(sum);

        dfs(u+1,sum + w[u+1]);
        dfs(u+1,sum);
        dfs(u+1, sum - w[u+1]);
    }
}
