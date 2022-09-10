package algorithmClass._01_差分数组;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/29 0:54
 *

 * @date 题意描述
 * 有 N 头牛站成一行，被编队为1、2、3…N，每头牛的身高都为整数。
 *  当且仅当两头牛中间的牛身高都比它们矮时，两头牛方可看到对方。
 *  现在，我们只知道其中最高的牛是第 P 头，它的身高是 H ，剩余牛的身高未知。
 *  但是，我们还知道这群牛之中存在着 M 对关系，每对关系都指明了某两头牛 A 和 B 可以相互看见。
 *  求每头牛的身高的最大可能值是多少。
 *
 * 输入格式
 *  第一行输入整数N,P,H,M，数据用空格隔开。
 *  接下来M行，每行输出两个整数 A 和 B ，代表牛 A 和牛 B 可以相互看见，数据用空格隔开。
 *
 * 输出格式
 *  一共输出 N 行数据，每行输出一个整数。
 *  第 i 行输出的整数代表第 i 头牛可能的最大身高。
 *
 * 数据范围
 *  1≤N≤10000,
 *  1≤H≤1000000,
 *  1≤A,B≤10000,
 *  0≤M≤10000
 *  输入样例：
 *  9 3 5 5
 *  1 3
 *  5 3
 *  4 3
 *  3 7
 *  9 8
 *  输出样例：
 *  5
 *  4
 *  5
 *  3
 *  4
 *  4
 *  5
 *  5
 *  5
 */

public class _01_最高的牛 {
    public static void main(String[] args) {
        int n,p,h,m;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        p = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();
        int a[] = new  int [n+1];
        int b[] = new  int [n+1]; //差分数组
        int ans[][] = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = h;
            b[i] = a[i] - a[i-1];
        }
        int x ,y;
        for (int i = 1; i <= m; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            if (x > y){  // 交换两数
                x = x ^ y;  y = x ^ y; x = x ^ y;
            }
            if(ans[x][y]==1) continue; //去重
            ans[x][y] = 1 ;
            b[x+1]--; //闭区间  差分处理
            b[y]++;
        }

        for (int i = 1; i <= n; i++) {
            a[i]= a[i-1] + b[i];
            System.out.println(a[i]);
        }

    }
}

