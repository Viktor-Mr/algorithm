package AcWing._蓝桥._03_数学与简单DP;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/14 14:35
 */
public class _Case02_01蚂蚁感冒 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []fs = new int[n];
        int flag = 0;
        for (int i = 0; i < n; i++){
            fs[i] = sc.nextInt();
            //判断是否有交叉感染的可能
            if ( i >= 1 && fs[i] > 0 && fs[0] < 0 && -fs[0] > fs[i]) flag = 1;
            if ( i >= 1 && fs[i] < 0 && fs[0] > 0 && fs[0] < -fs[i]) flag = 1;
        }
        int ans = 1;  //感染
        for (int i = 1; i < n; i++) {
            // + 同方向大于 0 号 不考虑
            if ( fs[i] > 0 &&  fs[0] > 0 && fs[i] > fs[0]) continue;
            // 反方向小于0号 不考虑
            if ( fs[i] < 0 &&  fs[0] > 0 && -fs[i] < fs[0]) continue;
            // - 同方向大于 0 号 不考虑
            if ( fs[i] < 0 &&  fs[0] < 0 && fs[i] > fs[0]) continue;
            // 反方向小于0号 不考虑
            if ( fs[i] > 0 &&  fs[0] < 0 && fs[i] > -fs[0]) continue;
            if (flag == 1){
                ans++;
            }
        }
        System.out.println(ans);

    }
}
