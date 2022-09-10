package algorithmBeauty.elementary._02;

import org.junit.Test;

/**
 * @author
 * @date 2021-06-07 0:06
 */
public class A2_20求a的n次幂 {
    public static int pow(int a,int n){
        if (n == 0 ) return 1;
        int res = a;
        int ex = 1;
        while ( (ex<<1) <= n){
            res = res * res;
            ex = ex<<1;
        }
        return res * pow(a,n-ex);
    }
    @Test
    public void run0() throws Throwable {
        System.out.println(  pow(5,0)) ;
    }
}
