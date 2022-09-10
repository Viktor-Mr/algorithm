package AcWing._蓝桥._02_二分与前缀和;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/10 0:06
 */
public class _Case01_01数的范围 {
    static int N  = 100010;
    static int a[] = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();

            int l = 0; int r = n - 1;
            while (l < r) {  //左端点
                int mid = (l + r) >> 1;
                if (a[mid] >= x) r = mid;
                else l = mid+1;
            }
            if (a[l] == x) { // 右端点
                System.out.print(l + " ");
                r = n - 1;
                while (l < r) {
                    int mid = (l + r + 1) >> 1; // 因为写的是l = mid，所以需要补上1
                    if (a[mid] <= x) l = mid;
                    else r = mid-1;
                }
                System.out.println(r);
            }
            else System.out.println("-1 -1");
        }
    }
}
