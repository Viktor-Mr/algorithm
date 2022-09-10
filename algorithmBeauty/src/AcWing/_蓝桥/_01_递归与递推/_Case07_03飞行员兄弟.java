package AcWing._蓝桥._01_递归与递推;

import javax.xml.stream.events.StartDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/9 14:57
 */
public class _Case07_03飞行员兄弟 {
    static int N = 5;
    static char[][] g = new char[N][N];
    static int[][] change = new int[5][5];//表示(i,j)该点打横打竖需要异或的值的总和

    public static void main(String[] args) {
        //预处理
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    change[i][j] += 1<<get(i,k);
                    change[i][j] += 1<<get(k,j);
                }
                change[i][j] -= 1<<get(i,j); //减去重复出现的
            }
        }
        Scanner sc = new Scanner(System.in);
        int start = 0; //使用一个数来表示当前的局面
        for (int i = 0; i < 4; i++) {
            g[i] = sc.nextLine().toCharArray();
            for (int j = 0; j < 4; j++) {
                if (g[i][j] == '+') {
                    start += 1 <<  get(i,j);
                }
            }
        }
        List<P> ans = new ArrayList<P>();

        //进行操作
        for (int op = 0; op < 1 << 16; op++) {
            List<P> temp = new ArrayList<P>();
            int now = start;
            //判断 16 位 分别是什么数字
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                    if ((op >> get(i, j) & 1) == 1) {
                        temp.add(new P(i, j));
                        now ^= change[i][j];
                    }

            if( now == 0 &&(ans.size() == 0 || ans.size() > temp.size()) ) ans = temp;
        }
        System.out.println(ans.size());
        for (P p:ans) System.out.println((p.getFirst() + 1)+ " " + (p.getSecond() + 1));

    }
    private static int get(int i, int j) {
        return i * 4 + j;
    }
}

class P {
    private int first;
    private int second;

    public int getFirst() {
        return first;
    }
    public int getSecond() {
        return second;
    }
    public P(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
