package algorithmBeauty.elementary._08_dp;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/31 12:53
 */

/*
字典序最小问题

给一个定长为N的字符串S,构造一个字符串T,长度也为N。

起初，T是一个空串，随后反复进行下列任意操作

1. 从S的头部删除一个字符，加到T的尾部
2. 从S的尾部删除一个字符，加到T的尾部

目标是最后生成的字符串T的字典序尽可能小

1≤N≤2000
字符串S只包含大写英文字母

输入：字符串S
输出：字符串T

POJ - 3617 要求每80个字符换行输出
 */
public class Case06_字典序最小问题 {
   static char  []c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
                c =  new char[n];
        char  []d = new char[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.next().toCharArray()[0];
        }
        int x = 0;
        int y = n-1; //记录读取到的左右两边的下标
        int now = 0;
        while (now < n) {
            //递归找到左边小,还是右边小  k < 0 是左边小 k==0 是 选那边都没关系 ,  0 < k  是右边小
            int  k = find(x,y);

            if (k > 0) {
                d[now++] = c[y];
                y--;
            }else {
                d[now++] = c[x];
                x++;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(d[i]);
            if (i != 0 && i % 79 == 0)
                System.out.println();
        }
    }

    private static int find(int x, int y) {
        if (x  == y || x > y ) return 0; //选那个也没关系

        // 右边小
        if (c[x] > c[y]) return  1;
        else if (c[x] < c[y]) return -1;
        else return find(x+1,y-1); //双方一样,看里面那个
    }
}
