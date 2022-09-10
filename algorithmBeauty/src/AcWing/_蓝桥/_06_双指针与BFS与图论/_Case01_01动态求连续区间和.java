package AcWing._蓝桥._06_双指针与BFS与图论;

import java.io.*;
import java.util.Arrays;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/20 0:53
 */
public class _Case01_01动态求连续区间和 {
    static int N = 10010;
    static boolean []ans = new boolean [N];
    static int []cnt = new int[N];
    static P []ps = new P [N];
    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out  = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = in.readLine().split(" ");
        int n =     Integer.parseInt(s[0]);
        int d =     Integer.parseInt(s[1]);
        int k =     Integer.parseInt(s[2]);
        for (int i = 0; i < n; i++) {
           s = in.readLine().split(" ");
            ps[i] = new P(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }
        Arrays.sort(ps,0,n);

        // 双指针算法， i走在前面，j走在后面
        for (int i = 0, j = 0; i < n; i++) {
            //每个id被在哪这个时间段内被点赞的数量
            int id = ps[i].id;
            cnt[id]++;

            //i在前面走，j跟着后面走，i和j维护长度不大于d的区间，若超过了d，则j前进进行区间回缩

            //只有当他们之间的距离大于d了才需要减去
            while ( ps[i].ts - ps[j].ts >= d) {
                cnt[ps[j].id] --;
                j++;//在logs[j].t时刻的太久远了，往前挪挪。 //这个循环，直到最后一个赞不过期为止。
            }
            if ((cnt[id] >= k) ) ans[id] = true;
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (ans[i]) out.write(i + "\n");
        }
        out.flush();
    }
}

class P implements Comparable<P>{
    int ts;
    int id;

    public P(int ts, int id) {
        this.ts = ts;
        this.id = id;
    }

    @Override
    public int compareTo(P o) {
        if (this.ts == o.ts) return this.id - o.id;
        return this.ts - o.ts;
    }
}
