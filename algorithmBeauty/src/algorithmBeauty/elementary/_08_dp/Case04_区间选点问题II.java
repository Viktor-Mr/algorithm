package algorithmBeauty.elementary._08_dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/30 15:15
 */
public class Case04_区间选点问题II {
    static  int a[];
    static  int b[];
    static  int n;
    static  int max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        J []js = new J[n];

        for (int i = 0; i < n; i++) {
            js[i] = new J();
            js[i].s = sc.nextInt();
            js[i].e = sc.nextInt();
            max = Math.max(max,js[i].s);
            max = Math.max(max,js[i].e);
           js[i].num = sc.nextInt();
        }
        Arrays.sort(js);
        a = new int[max+1];  //树状数组  用作 区间查询 , 单点修改
        b = new int [max+1]; //普通数组  用作 单点查询

        for (int i = 0; i < n; i++) {
            //选判断原来的数组 用 l 到 r 上有几个点
             int s = checks(js[i].s, js[i].e);
            //如果够了
            if (s >= js[i].num) {
                continue;
            }else {
                //如果不够, 在 l ~ r 之间 补上 num - s
               addF(js[i].s, js[i].e,js[i].num -s ); 
            }
        }
        System.out.print(ask(max) - ask(1-1));
    }

    //需要在s - e  区间 加上 i 个 1
    private static void addF(int s, int e, int k) {
        //从后面加
        for (int i = e; i >= s; i--) {

            //如果原来等于零 ,就要加上一个点
            if (b[i] == 0 && k >0){
                add(i,1);
                b[i]++;
                k--;
            }
        }
    }

    private static void add(int i, int p) {
        for (; i <= max ; i += i&(-i)){
            a[i]+=p;
        }
    }

    private static int checks(int l, int r) {
        //树状数组的区间查询  r ~ (l-1)
        return  ask(r) - ask(l-1);
    }

    //查询前缀和
    private static int ask(int k) {
        int ans = 0;
        for (  ; k > 0; k -=  k&(-k) ) {
            ans += a[k];
        }
        return ans;
    }

    static  class  J implements  Comparable<J> {
        int s;
        int e;
        int num;
        public void setS(int s) {
            this.s = s;
        }
        public void setE(int e) {
            this.e = e;
        }
        @Override
        public int compareTo(J o) {
            if (this.e ==  o.e ) return this.s - o.s;
            else  return this.e - o.e;
        }
    }
}
