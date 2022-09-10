package AcWing._蓝桥._03_数学与简单DP;
import java.util.Scanner;
/**
 * @author fu-xiao-liu
 * @Date 2021/11/14 0:08
 */
public class _Case01_04买不到的数 {
    static int n;
    static int m;
    static int N = 10000005;
    static int[] f = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        if (n > m) {
            n = n ^ m;
            m = n ^ m;
            n = n ^ m;
        }
        f[0] = 1;
        //只要连续 n个数有解, 后面的必然有解
        int ans = 0;
        for (int i = n ; i <= n * m ; i++) {
            if (f[i-n] == 1  ){
                f[i] = 1;
            }else if( i >= m &&  f[i-m] == 1){
                f[i] = 1;
            }else{
                ans = i;
            }
        }
        System.out.println(ans);
    }
}
