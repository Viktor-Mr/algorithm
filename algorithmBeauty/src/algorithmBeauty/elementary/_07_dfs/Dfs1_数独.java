package algorithmBeauty.elementary._07_dfs;

import javax.swing.event.AncestorListener;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/24 10:43
 */
public class Dfs1_数独 {
    static  String []ans = new String[100000] ;
    static  int  an = 0;
    static  int  a = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                ans[an] = sc.nextLine();
                if (ans[an++].equals("end")) {
                break;
                }
            }

            if (!ans[0].equals("end")) {
                start(ans[0]);
            }
    }
    //初始化
    private static void start(String s) {
        char[] c = s.toCharArray();
        int index = 0;
        char [][]chars = new char[10][10];
        for (int i = 1; i <= 9 ; i++) {
            for (int j = 1; j <= 9; j++) {
                chars[i][j] = c[index++];
            }
        }
        dfs(chars,1,1);
    }

    private static void dfs(char[][] chars, int x, int y) {
        if ( x == 10){
            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    System.out.print(chars[i][j]);
                }
            }
            System.out.println();
            while (true) {
                a++;
                if ( !ans[a].equals("end") ){
                    start(ans[a]);

                }else {
                    System.exit(0);
                }
            }

        }

        if (chars[x][y] == '.'){
            for (int i = 1; i <= 9 ; i++) {
               if( check(chars,x,y, (char) ('0'+i))){
                   chars[x][y] = (char) ('0'+ i);
                   dfs(chars, x+(y+1)/10, (y+1)%10);
               }
               chars[x][y] = '.';
            }
        }else {
            dfs(chars, x+(y+1)/10, (y+1)%10);
        }

    }
    /**
     * @date 判断上下,以及九宫内是否出现过相同数字
     */
    private static boolean check(char[][] chars, int x, int y, char n) {
        for (int i = 1; i <= 9; i++) {
            if( chars[x][i] == n ) return false;
            if( chars [i][y] == n) return  false;
        }
        for (int i = ((x-1)/3)*3+1; i <= ((x-1)/3)*3+3; i++) {
            for (int j = ((y-1)/3)*3+1; j <= ((y-1)/3)*3+3;  j++) {
                if( chars[i][j] == n ) return false;
            }
        }
        return true;
    }

}
