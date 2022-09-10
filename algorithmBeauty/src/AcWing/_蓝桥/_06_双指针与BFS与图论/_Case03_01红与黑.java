package AcWing._蓝桥._06_双指针与BFS与图论;

import sun.applet.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/20 23:09
 * BFS
 */
public class _Case03_01红与黑 {
    static int N = 22;
    static int m ,n;
    static char [][] tu = new  char[N][N]; //存储图
    static boolean [][] nums = new  boolean[N][N];  //判断是否走过
    static PS start;
    static int [] xp = new int[] {1,-1,0,0};
    static int [] yp = new int[] {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        m = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);

        while (true){
            for (int i = 0; i < n; i++) {
                char[] chars = in.readLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    tu[i][j] = chars[j];
                    if (tu[i][j] == '@'){
                        start = new PS(i,j);
                    }
                }
            }
            System.out.println(bfs());
             s = in.readLine().split(" ");
            m = Integer.parseInt(s[0]);
            n = Integer.parseInt(s[1]);
            if (m == 0 && n == 0) break;
        }

    }

    private static int bfs() {
        int ans = 1;

        //初始化队列
        LinkedList<PS> queue = new LinkedList<PS>();
        queue.add(start);
        for (int i = 0; i < n; i++) Arrays.fill(nums[i],false);
        nums[start.x][start.y] = true;

        while (!queue.isEmpty() ) {
            //取出头
            PS poll = queue.poll();
            //枚举对头节点
            for (int i = 0; i < 4 ; i++) {
                int xn = poll.x + xp[i];
                int yn = poll.y + yp[i];
                //判断这个节点是否可以用
                if (xn < 0 || xn >= n || yn < 0 || yn >= m) continue;
                if (tu[xn][yn] == '#' || nums[xn][yn] ) continue;

                nums[xn][yn] =  true ;
                ans++;
                queue.add(new PS(xn,yn));

            }

        }

        return ans;
    }
}
