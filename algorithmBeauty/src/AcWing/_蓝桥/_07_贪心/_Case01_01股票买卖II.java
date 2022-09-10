package AcWing._蓝桥._07_贪心;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/31 17:11
 * 贪心
 */
public class _Case01_01股票买卖II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {  //i代表明天的情况  i-1 代表今天的情况
            //预计明天会涨 , i-1 要买入
            if (a[i-1] < a[i]) {
                ans += (a[i] - a[i-1]);
            }
        }
        System.out.println(ans);
    }
}
