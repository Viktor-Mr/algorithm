package AcWing._蓝桥._07_贪心;


import java.io.*;
        import java.util.*;
        import java.util.Arrays;
        import java.util.Comparator;
        import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/2 12:35
 */
public class Case07_01后缀表达式  {




    public static void main(String[] args)throws IOException {


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = in.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);

        int   []f = new int [ n+m+1];

        String[] cur = in.readLine().split(" ");
        for(int i=0; i<=n+m; i++) f[i] = Integer.parseInt(cur[i]);


        int k = n + m + 1;


        double ans = 0f;
        if(m == 0){
            for(int i = 0; i < k ; i++)
                ans += f[i];
            System.out.printf("%.0f",ans);
            System.exit(0);
        }

        Arrays.sort(f); //排序
        ans += f[k-1];
        ans -= f[0];
        m--;
        for (int i = 1; i < k-1; i++) {
            ans +=  f[i] > 0 ? f[i] : -f[i];
        }
        System.out.printf("%.0f",ans);

    }


}