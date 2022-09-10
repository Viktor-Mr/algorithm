package AcWing._蓝桥._13_12届第二场;


import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2022/4/6 15:33
 */
public class _3491完全平方数 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Long n =  sc.nextLong();
        Long ans = 1L;

        for (Long i = 2L; i * i <= n; i++) {
            int s = 0;
            while( n % i == 0){
                s++;
                n /= i;
            }
            if( s % 2 == 1) ans *= i;
        }
        if(n > 1 ) ans *= n;
        System.out.println(ans);
    }
}
