package KnowContest.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author fu-xiao-liu
 * @Date 2021/12/19 17:27
 */
public class Case04_01小卡与质数2 {
    static int t;
    static int N = 10000000 ;
    static  boolean st[] = new boolean[N+10] ;
    static  int prime[] = new int[N+10] ;
    static int num[] = new int[22];
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(in.readLine());
        getPrime(N);

        for (int i = 2; i <= 21; i++) {
            int ans = 0;
            for (int j = (int) Math.pow(2,i-1); j <= Math.pow(2,i)-1; j++) {

                if (j > N) break;
                if (!st[j]) ans++;
            }

            num[i] = ans;
        }

        while (t-->0){
            int res = 0;
            int k = Integer.parseInt(in.readLine());
            for (int i = 1; i <=  20; i++) {
                if ( (1<<i & k) != 0) {

                    res += num[i+1];
                }
            }
            System.out.println(res);
        }
    }

    private static void getPrime(int n) {
        for(int i = 2; i <= n; i++) {
            if(!st[i]) prime[cnt++] = i;//都是质数
            for(int j = 0; prime[j] <= n / i; j++) {//也就是小于sqrt，i从0开始计数
                //对于任意一个合数x，假设pj为x最小质因子，当i<x/pj时，一定会被筛掉
                st[prime[j]*i] = true;//倍数
                if(i % prime[j] == 0) break;//继续扩大，说明i是prime[j]的倍数了，找下个质数进行倍增，i%pj == 0, pj定为i最小质因子，pj也定为pj*i最小质因子
            }
        }


    }
}
