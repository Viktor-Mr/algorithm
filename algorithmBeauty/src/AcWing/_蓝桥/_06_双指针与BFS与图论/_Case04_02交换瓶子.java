package AcWing._蓝桥._06_双指针与BFS与图论;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/21 13:26
 */
public class _Case04_02交换瓶子 {
    static int []s = new  int[10010];
    static boolean []st = new  boolean[10010];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String []string = in.readLine().split(" ");
        for (int i = 1; i <= n; i++) s[i] = Integer.parseInt(string[i-1]);

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (!st[i]){
                ans++;
                for (int j = i;   !st[j] ; j = s[j]) {
                    st[j] = true;
                }
            }
        }


        System.out.println(n - ans);

    }
}
