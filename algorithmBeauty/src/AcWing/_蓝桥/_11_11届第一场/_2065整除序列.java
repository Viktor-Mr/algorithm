package AcWing._蓝桥._11_11届第一场;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2022/3/31 11:01
 * 有一个序列，序列的第一个数是 n，后面的每个数是前一个数整除 2，请输出这个序列中值为正数的项。
 *
 * 输入格式
 * 输入一行包含一个整数 n。
 *
 * 输出格式
 * 输出一行，包含多个整数，相邻的整数之间用一个空格分隔，表示答案。
 *
 * 数据范围
 * 1≤n≤10^18
 *
 *输入样例：
 * 20
 *
 *输出样例：
 * 20 10 5 2 1
 */
public class _2065整除序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long i = sc.nextLong();
        int j  =  0;
        while (i>>j >= 1){
            System.out.print(i>>j++);
            System.out.print(" ");
        }

    }
}
