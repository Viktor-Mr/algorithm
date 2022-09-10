package AcWing._蓝桥._01_递归与递推;

import javax.xml.stream.events.StartDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/9 14:57
 */
public class _Case07_02飞行员兄弟 {
    static int N = 5;
    static char[][] g = new char[N][N];
    static char[][] backup = new char[N][N];
    static int[][] change = new int[5][5];//表示(i,j)该点打横打竖需要异或的值的总和

    public static void main(String[] args) {
        //预处理

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            g[i] = sc.nextLine().toCharArray();
        }
        List<P> ans = new ArrayList<P>();

        //进行操作
        for (int op = 0; op < 1 << 16; op++) {
            List<P> temp = new ArrayList<P>();

            for (int i = 0; i < 4; i++) {
               backup[i] =  g[i].clone();
            }

            //判断 16 位 分别是什么数字
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                    if ((op >> get(i, j) & 1) == 1) {
                        temp.add(new P(i, j));
                        turn_all(i, j);
                    }

            //判断灯泡是否全亮
            boolean has_closed = false;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (backup[i][j] == '+') {
                        has_closed = true;
                    }
                }
            }
            if (!has_closed)
                if(ans.size() == 0 || ans.size() > temp.size() ) ans = temp;
        }

        System.out.println(ans.size());
        for (P p:ans) System.out.println((p.getFirst() + 1)+ " " + (p.getSecond() + 1));

    }

    /**
     * 按动 x y 处的开关
     */
    private static void turn_all(int x, int y) {
        for (int i = 0; i < 4; i++) {
            turn_on(x, i);
            turn_on(i, y);
        }
        turn_on(x, y);
    }

    private static void turn_on(int x, int y) {
        if (backup[x][y] == '+') backup[x][y] = '-';
        else backup[x][y] = '+';
    }

    private static int get(int i, int j) {
        return i * 4 + j;
    }

}
