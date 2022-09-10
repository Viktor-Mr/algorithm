package AcWing._蓝桥._02_二分与前缀和;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


/**
 * @author fu-xiao-liu
 * @Date 2021/11/12 13:21
 * 二分
 */
public class _Case06_01四平方和 {
    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i*i <= n ; i++) {
            for (int j = i; j*j <= n ; j++) {
                list.add(new int[] {i*i+j*j , i,j});
            }
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if ( o1[0] != o2[0]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        //枚举 a b
        for (int a = 0; a*a <= n ; a++) {
            for (int b = a; b*b < n; b++) {
                int t = n - a*a - b * b;

                //在list里面找
                int l = 0;
                int r = list.size()-1;
                while (l < r){
                    int mid = (l +r) >> 1;
                    if (list.get(mid)[0] >= t ) r = mid;
                    else   l = mid + 1;
                }
                if (list.get(l)[0] == t) {
                    int c = list.get(l)[1];
                    int d = list.get(l)[2];
                    System.out.println(a + " " + b + " " + c + " " + d);
                    return;
                }
            }
        }

    }
}
