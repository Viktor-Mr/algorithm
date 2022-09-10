package AcWing._蓝桥._04__枚举与模拟与排序;


import java.util.*;
import java.io.*;


public class _Case08_01外卖店优先级 {

    static int N = 100010;
    static int[] score = new int[N];//表示第i个店铺当前的优先级
    static int[] last = new int[N];//表示第i个店铺上一个有订单的时刻
    static boolean[] st = new boolean[N];//表示第i个店铺当前是否处于优先缓存中
    static P[] ps = new P[N];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int T = Integer.parseInt(s[2]);
        for (int i = 0; i < m; i++) {
            s = in.readLine().split(" ");
            ps[i] = new P(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
        }
        Arrays.sort(ps,0,m);
        //遍历 0 - m 家外卖店
        for (int i = 0; i < m; ) {
            int j = i;
            while ( j < m && ps[j].t == ps[i].t && ps[j].id == ps[i].id) j++;
            //记录下来 ps 的 时刻 t 和 店铺 id
            int t = ps[i].t; int id = ps[i].id;
            int cnt = j - i;
            i = j; //这里已经 i++了 所以可以免掉   (int i = 0; i < m; )  这里的i++;

            //先计算 t 时刻之前有多少积分
            score[id] -=  t -  last[id]  - 1 ;
            if (score[id] < 0)  score[id] = 0;
            if (score[id] <= 3) st[id] =false;

            score[id] += cnt*2;
            if (score[id] > 5) st[id] = true;
            last[id] = t;
        }

        //判断 last[id] ~ T 时刻需要减掉多少score
         for (int i = 1; i <= n; i++ ) {
             if (last[i] < T) {
                score[i] -=  T -  last[i];

                 if (score[i] <= 3) st[i] =false;
             }
        }

         int ans = 0;

         for (int i = 1; i <= n; i++) {
             if (st[i] ) ans++;
         }

        System.out.println(ans);
    }
}

class P implements Comparable<P> {
    public int t;
    public int id;

    public P(int t, int id) {
        this.t = t;
        this.id = id;
    }

    @Override
    public int compareTo(P o) {
        if (this.t == o.t) return this.id - o.id;
        return this.t - o.t;
    }

}