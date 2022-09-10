package AcWing._蓝桥._05_树状数组与线段树;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/18 20:01
 */
public class _Case04_01小朋友排队 {


    static int N = 1000010;
    static int n ;
    static int []pre = new int[N];
    static int []h = new int[N];
    static int []sum = new int[N];



    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");
        for (int i = 1; i <= n ; i++) h[i] = Integer.parseInt(s[i-1])+1;

        //统计前面有多少个数比 i 大
        for (int i = 1; i <= n; i++) {
            sum[i] = query(N-1) -  query(h[i]);
            add(h[i],1);
        }

        Arrays.fill(pre,0);
        //统计后面有多少个数比 i 小
        for (int i = n; i >= 1; i--) {
            sum[i] += query(h[i]-1);
            add(h[i],1);
        }
        long ans = 0;

        for (int i = 1; i <= n; i++) {
            ans += (long) (sum[i] + 1) * sum[i]>>1;
        }
        System.out.println(ans);
    }

    private static void add(int i, int d) {
        for ( ; i < N ; i += i&(-i))
            pre[i] += d;
    }

    private static int query(int i) {
        int ans = 0;
        for (  ; i > 0 ;  i -= i&(-i)) ans += pre[i];
        return ans;
    }

}
