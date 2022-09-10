package algorithmBeauty.elementary._07_dfs;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/24 23:09
 */
public class Dfs1_数独2 {
    static int N = 9;
    // ones[i] 表示i这个数字的二进制表示中， 有多少个1
    static  int []ones = new int[1<<N];
    //
    static  int []map = new int[1<<N];
    static int []row = new int[N];
    static int []col = new int[N];
    static int [][]cell = new int[3][3];
    static char[] str;

    public static int lowBit(int x){
        return x&(-x);
    }

    public static void main(String[] args) {
        for (int i = 0; i < N; i++)  map[1 << i] = i;
        for (int i = 0; i < 1 << N; i++) { // 0 ~  2^9 -1
            for (int j = 0; j < N ; j++) {
                ones[i] += ((i >> j) &1);   // i的二进制表示中有s个1
            }
        }
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            str = sc.next().toCharArray();
            if (str[0] == 'e') break;
            init();
            int cnt = 0;
            for (int i = 0, k = 0; i < N; i++) {
                for (int j = 0; j < N; j++,k++) {
                    if (str[k] != '.') {
                        int t = str[k] - '1';
                        row[i] -= 1<<t;
                        col[j] -= 1<<t;
                        cell[i/3][j/3] -= 1<<t;
                    }else{
                        cnt++;
                    }
                }
            }
            dfs(cnt);
            System.out.println(str);
        }
    }

    private static boolean dfs(int cnt) {
        if ( cnt == 0  ){
            return true;
        }

        //找出最少位置的可选方案
        int min = 10;
        int x = 0,y=0; //可能方案最少的位置横纵坐标
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ( str[i*9 + j] == '.'){
                    int t = ones[get(i,j)]; //判断几个一
                    if(t < min) {
                        min = t;
                        x = i ;y = j;
                    }
                }
            }
        }
        for (int i = get(x,y); i != 0 ; i-=lowBit(i)){
            int t  = map[lowBit(i)];

            //修改转态
            row[x] -= 1 <<t;
            col[y] -= 1 <<t;
            cell[x/3][y/3] -= 1<<t;
            str[x*9 + y] = (char) ('1'+t);

            if (dfs(cnt-1)){
                return true ;
            };
            row[x] += 1 <<t;
            col[y] += 1 <<t;
            cell[x/3][y/3] += 1<<t;
            str[x*9 + y] = '.';
        }
        return false;
    }

    private static int get(int i, int j) {
        return  row[i]&col[j]&cell[i/3][j/3];
    }

    /**
     * @date 初始化
     */
    private static void init() {
        for (int i = 0; i < N; i++) {
            row[i] = col[i] = (1<<N)-1;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cell[i][j] = (1<<N)-1;
            }
        }
    }
}
