package AcWing._蓝桥._03_数学与简单DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/26 22:21
 */
public class _Case08_01波动数列 {
    static int N = 1010;
    static int MOD = 100000007;
    // 第i个数 是a/b 且求余n的余数是j
    static int[][] dp = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] string = in.readLine().split(" ");
        int n = Integer.parseInt(string[0]);
        int s = Integer.parseInt(string[1]);
        int a = Integer.parseInt(string[2]);
        int b = Integer.parseInt(string[3]);

        dp[0][0] = 1;
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][get_Mod(j - i * a ,n)];
                dp[i][j] = (dp[i][j] + dp[i - 1][get_Mod(j + i * b , n)]) % MOD;
            }
        }

        System.out.println(dp[n - 1][get_Mod(s ,n )]);
    }

    private static int get_Mod(int a, int n) {
        return  ( a%n + n )%n;
    }
}
