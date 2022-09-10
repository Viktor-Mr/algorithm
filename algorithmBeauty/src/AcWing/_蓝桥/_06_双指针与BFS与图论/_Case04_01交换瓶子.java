package AcWing._蓝桥._06_双指针与BFS与图论;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/21 10:50
 */
public class _Case04_01交换瓶子 {
    static int []s = new  int[10010];
    static int []d = new  int[10010];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String []string = in.readLine().split(" ");
        for (int i = 0; i < n; i++) s[i]=d[i] = Integer.parseInt(string[i]);
        Arrays.sort(s,0,n);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if ( s[i] != d[i] ) {
                int j =i;
                for (; j < n; j++) {
                    if(s[i] == d[j]) break;
                }
                 d[i]= d[j] ^ d[i];
                 d[j]= d[j] ^ d[i];
                 d[i]= d[j] ^ d[i];
                ans++;
            }
        }
        System.out.println(ans);

    }
}
