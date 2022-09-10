package AcWing._蓝桥._02_二分与前缀和;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/13 23:43
 * 利用哈希
 */
public class _Case06_02四平方和 {
    private static HashMap<Integer,int[]> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i*i <= n ; i++) {
            for (int j = i; j*j <= n ; j++) {
                if (map.get(i*i+j*j) == null) map.put(i*i+j*j ,new int[]{i,j});
            }
        }
        //枚举 a b
        for (int a = 0; a*a <= n ; a++) {
            for (int b = a; b*b < n; b++) {
                int t = n - a*a - b * b;

                if (map.get(t) != null) {
                    int c = map.get(t)[0];
                    int d = map.get(t)[1];
                    System.out.println(a + " " + b + " " + c + " " + d);
                    return;
                }
            }
        }
    }
}
