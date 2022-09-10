package AcWing._蓝桥._03_数学与简单DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/15 0:34
 */
public class _Case05_01摘花生 {

    private static final int N = 110;

    static int[]dp = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);

            for (int i = 1; i <= n; i++) {
                s = in.readLine().split(" ");
                for (int j = 1; j <= m; j++) {
                    dp[j] = Math.max(dp[j-1],dp[j] ) + Integer.parseInt(s[j-1]);
                }
            }


            System.out.println(dp[m]);
            Arrays.fill(dp,0);
        }
    }
}
