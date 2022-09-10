package AcWing._蓝桥._01_递归与递推;

import java.util.Scanner;


/**
 * @author fu-xiao-liu
 * @Date 2021/11/4 12:38
 */
public class _Case03_01费解的开关  {
    static  char[][] f;
    static  char[][] fc;
    static  int []dx={-1,0,1,0,0}; /* (-1,0) (0,0) (1,0) (0,-1) (0,1)*/
    static  int []dy={0,0,0,-1,1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        f = new char[5][5];
        fc = new char[5][5];
        int n = sc.nextInt();
        while ( n-- > 0){
            //读取
            for (int i = 0; i < 5; i++) {
                String s = sc.next();
                for (int j = 0; j < 5; j++) {
                    f[i][j] = s.charAt(j);
                }
            }

            //遍历第一行的选择
            int ans = (int) (1f/0f);
            for (int i = 0; i < 1<<5; i++) {
                //先拷贝一份
                for(int p = 0;p < 5;p++)
                    for(int o = 0;o < 5;o++)
                        fc[p][o] = f[p][o];

                // fc  = f.clone();


                int list = 0;
                //判断当前这个第一个行的方案的 1  的个数
                for (int j = 0; j < 5 ; j++) {
                    if ( ( (i>>j) & 1) == 1 ){
                        list++;
                        //改变第i行的第j个位置   1 ->0  0 -> 1
                        change(0,j);
                    }
                }

                //走 0 1 2 3 行,判断这个点是否为 0 ,如果为零,下一行 0 ->1
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 5 ; k++) {
                        if (f[j][k] == '0') {
                            list++;
                            change(j+1,k);
                        }
                    }
                }
                //判断最后一行是不是都是1
                boolean  flag = true;
                for (int j = 0; j < 5; j++) {
                    if(f[4][j] == '0'){
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    ans = Math.min(ans,list);
                }
                //f = fc.clone();
                for(int p = 0;p < 5;p++)
                    for(int o = 0;o < 5;o++)
                        f[p][o] = fc[p][o];


            }
            if (ans <= 6 ){
                System.out.println(ans);
            }else {
                System.out.println(-1);
            }
        }


    }

    //改变这个位置的 的上下 相邻 五个点
    private static void change(int x, int y) {
        for (int i = 0; i < 5 ; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];
            if ( x1 >= 0 && x1<=4  && y1 >= 0 && y1 <= 4) f[x1][y1]  ^= 1;
        }
    }
}
