package AcWing._蓝桥._06_双指针与BFS与图论;

import sun.misc.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/20 16:11
 */
public class _Case02_01献给阿尔吉侬的花束 {
    static int N = 210;
    static int m ,n,T;
    static char [][] tu = new  char[N][N]; //存储图
    static int [][] nums = new  int[N][N];  //存储到起点的最短距离
    static PS start;
    static PS end;
    static int [] xp = new int[] {1,-1,0,0};
    static int [] yp = new int[] {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        T =  Integer.parseInt  (in.readLine());
        while (T -- >  0){
            String[] s = in.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            m = Integer.parseInt(s[1]);
            for (int i = 0; i < n; i++) {
                char [] ch = in.readLine().toCharArray();
                for (int j = 0; j < m ; j++) {
                    tu[i][j] = ch[j];
                    if ( tu[i][j] == 'S') start = new PS(i,j);
                    if ( tu[i][j] == 'E') end =  new PS(i,j);
                }
            }
            int t = bfs();
            if (t == -1) System.out.println("oop!");
            else System.out.println(t);
        }
    }

    private static int bfs() {
        LinkedList <PS> queue = new LinkedList<PS>();

        //初始化队列 , 初始化结果集合
        queue.add(start);
        for (int i = 0; i < n; i++) Arrays.fill(nums[i],-1);
        nums[start.x][start.y] = 0;

        //队列不为空
        while (! queue.isEmpty()){
            //取出对头元素
            PS poll = queue.poll();
            //枚举对头节点
            for (int i = 0; i < 4 ; i++) {
                int xn = poll.x + xp[i];
                int yn = poll.y + yp[i];
                //判断这个节点是否可以用
                if (xn < 0 || xn >= n || yn < 0 || yn >= m) continue;
                if (tu[xn][yn] == '#' || nums[xn][yn] != -1) continue;

                nums[xn][yn] = nums[poll.x][poll.y] + 1 ;

                if (tu[xn][yn] == 'E') return   nums[xn][yn];

                queue.add(new PS(xn,yn));

            }

        }

        return  -1;
    }

}

class  PS {
    int x, y;

    public PS(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
