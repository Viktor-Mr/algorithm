package KnowContest.first;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author fu-xiao-liu
 * @Date 2021/12/19 16:14
 */
public class Case05_01萝卜数据库 {
    static int n;
    static int k;
   static  int f[][] = new int[1010][1010];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);

         int kp = 0; //
        for (int i = 0; i < n; i++) {
            s = in.readLine().split(" ");
            if ( Integer.parseInt(s[0]) == 1 ){
                int np =  Integer.parseInt(s[1]);
                for (int j = 2; j < s.length; j +=2) {
                    f[kp][Integer.parseInt(s[j]) ] = Integer.parseInt(s[j+1]);
                }
                kp++;
            }else{
                int  ans = 0;
                int res = Integer.parseInt(s[1]);
                int min = Integer.parseInt(s[2]);
                int max = Integer.parseInt(s[3]);
                for (int j = 0; j < kp; j++) {
                    if ( f[j][res] >= min && f[j][res] <= max) {
                        ans++;
                    }
                }
                System.out.println(ans);
            }
        }

    }
}
