package algorithmBeauty.elementary._07_dfs;

import org.w3c.dom.css.Counter;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/25 21:42
 */
public class Dfs3_水洼数 {
   static char [][]ch ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ch = new char[n][];
        for (int i = 0; i < n; i++) {
            ch[i] = sc.next().toCharArray();
        }
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ch[i][j] == 'W') {
                    cnt++;
                    dfs(i,j);
                }
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(int x, int y) {
        ch[x][y] = '.';
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2 ; j++) {
                if (i == 0  && j == 0)  continue;

                if (x+i >=0 && j+y>=0 && x+i <= ch.length -1 && y+j <= ch[0].length -1 ){
                    if(ch[x+i][y+j] == 'W'){
                        dfs(x+i, y+j);
                    }
                }
            }
        }

    }
}
