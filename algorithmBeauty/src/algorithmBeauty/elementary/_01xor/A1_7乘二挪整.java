package algorithmBeauty.elementary._01xor;


import org.junit.Test;

/**
 * @author
 * @date 2021-06-03 21:46
 */
public class A1_7乘二挪整 {
    public static void main(String[] args) {
        double num = 0.625;
        StringBuilder sb = new StringBuilder("0.");
        while (num > 0) {
            //乘二
            double r = num * 2;
            if (r >= 1) {
                sb.append("1");
                num = r - 1;
            } else {
                sb.append("0");
                num = r;
            }
            if (sb.length() > 34) {
                System.out.println("Error");
                return;
            }
        }
        System.out.println(sb.toString());
    }

    public static void two() {
        double num = 0.3;
        int flag = 0;
        StringBuilder sb = new StringBuilder("0.");
        for (double a = 0.5,i = 1; i <= 32; i++) {
            if (num - a  >= 0) {
               sb.append("1");
                num = num - a ;
            } else {
                sb.append("0");
            }
            if (num == 0) {
                 flag = 1;
                 break;
            }
            a = a /2 ;
        }
        if (flag == 0) {
            System.out.println("error");
        }else{
            System.out.println(sb.toString());
        }
    }

    @Test
    public void run0() {
        two();
    }
}
