package algorithmBeauty.elementary._08_dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/30 22:04
 */
public class Case05_区间覆盖 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = 1;   //从start 开始,到 end 结束
        int end = sc.nextInt();
        J js[] = new J[n];

        for (int i = 0; i < n; i++) {
            J j = new J(); j.s = sc.nextInt(); j.e = sc.nextInt();  js[i] = j;
        }
        Arrays.sort(js);
        int ans = 1;
        int maxEnd = 0 ;

        for (int i = 0; i < n ; i++)  {

            int s = js[i].s;
            int t = js[i].e;

            //如果是第一头牛, 而且 第一头牛的开始位置大于1 则无法覆盖,程序退出
            if (i == 0 && s > 1) break;

            if (s <=  start ) {
                maxEnd =  Math.max(maxEnd,t);
            }else{ //如果起点不能在start之前 ,那么说明这个点不满足覆盖 start 的情况
                //替换 起点start
                start = maxEnd + 1; //这个点已经被覆盖了,所以需要+1
                ans++; //计数器++


                //如果这个点的起点满足在 start 的左边 可以更新
                if( s <= start){
                    maxEnd = Math.max(t,maxEnd);
                }else { //如果不满足
                    break;
                }
            }
            if (maxEnd >= end){
                break;
            }
        }
        if (maxEnd < end) System.out.println(-1);
        else System.out.println(ans);
    }


    private  static class J implements Comparable<J> {
        int s;
        int e;

        public void setS(int s) {
            this.s = s;
        }


        public void setE(int e) {
            this.e = e;
        }

        @Override
        public int compareTo(J o) {
            if (this.s == o.s) return  this.e - o.e;
            return  this.s - o.s;
        }

        @Override
        public String toString() {
            return "J{" +
                    "s=" + s +
                    ", e=" + e +
                    '}';
        }
    }
}
