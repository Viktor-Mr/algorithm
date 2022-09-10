package AcWing._蓝桥._04__枚举与模拟与排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/16 21:02
 */
public class _Case07_01航班时间 {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());

        while (t-- > 0) {

            String s1 = in.readLine();
            String s2 = in.readLine();
            int times = (get_time(s1) + get_time(s2)) / 2;
            int hours = times / 3600;
            int minutes = times % 3600 / 60;
            int seconds = times % 60;

            System.out.printf("\n%02d:%02d:%02d", hours, minutes, seconds);
        }
    }

    private static int get_time(String s) {
        //选判断是否需要在s后面加上 (+0)

        if (s.charAt(s.length() - 1) != ')') s += " (+0)";


        //取出起飞时间 //降落时间
        String s1 = s.split(" ")[0];
        String s2 = s.split(" ")[1];

        int h1 = Integer.parseInt(s1.split(":")[0]);
        int m1 = Integer.parseInt(s1.split(":")[1]);
        int se1 = Integer.parseInt(s1.split(":")[2]);

        int h2 = Integer.parseInt(s2.split(":")[0]);
        int m2 = Integer.parseInt(s2.split(":")[1]);
        int se2 = Integer.parseInt(s2.split(":")[2]);
        int d = s.split(" ")[2].charAt(2) - '0';
        return getSeconds(h2, m2, se2) - getSeconds(h1 ,m1, se1) + d * 24 * 3600;

    }

    private static int getSeconds(int h2, int m2, int se2) {
        return h2 * 3600 + m2 * 60 + se2;
    }
}
