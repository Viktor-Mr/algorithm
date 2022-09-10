package AcWing._蓝桥._07_贪心;

import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/1 21:37
 */
public class _Case04_01雷达扫描 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();
        J js[] = new J[n];
        double a,b;
        double sqrt;
        for (int i = 0; i < n; i++) {
            a = sc.nextDouble();
            b = sc.nextDouble();  //高
            if (b > r) {
                System.out.println(-1);
                System.exit(0);
            }

            sqrt = Math.sqrt( r * r - b * b);//求出边长
            //这个小岛需要雷达在
            J j = new J( a - sqrt, a + sqrt );
            js[i] = j;
        }
        Arrays.sort(js);
        int ans = 1;
        int li = 0 ; //记录当前雷达安装在个小岛的尾部
        for (int i = 1; i < n; i++) {
            if (js[i].s <= js[li].e){ //第i个小岛的头在第li个小岛的尾部之前
                continue;
            }else {
                li = i;
                ans++;
            }
        }
        System.out.println(ans);
    }
    static class J implements Comparable<J>{

        double s;
        double e;

        public J(double s, double e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(J o) { //返回结束早的那个
             return Double.compare(this.e,o.e) ;
        }
    }
}
