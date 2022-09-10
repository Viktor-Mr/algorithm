package AcWing._蓝桥._06_双指针与BFS与图论;




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
public class _Case03_02红与黑 {
    static int N = 22;
    static int m ,n;
    static char [][] tu = new  char[N][N]; //存储图
    static boolean [][] nums = new  boolean[N][N];  //判断是否走过

    static int [] xp = new int[] {1,-1,0,0};
    static int [] yp = new int[] {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        m = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);
        int a = 0,b = 0;
        while (true){
            for (int i = 0; i < n; i++) {
                char[] chars = in.readLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    tu[i][j] = chars[j];
                    if (tu[i][j] == '@'){
                        a = i;
                        b = j;
                    }
                }
            }
            System.out.println(bfs(a,b));
            for (int i = 0; i < n; i++) Arrays.fill(nums[i],false);

            s = in.readLine().split(" ");
            m = Integer.parseInt(s[0]);
            n = Integer.parseInt(s[1]);
            if (m == 0 && n == 0) break;
        }

    }

    private static int bfs(int a, int b) {
       int cnt = 1;

       nums[a][b] = true;

        for (int i = 0; i < 4; i++) {
            int x = a + xp[i];
            int y = b + yp[i];
            if (x < 0 || x >=  n|| y < 0 || y >= m)continue;
            if (nums[x][y] || tu[x][y] != '.') continue;
            cnt += bfs(x,y);

        }

       return  cnt ;
    }
}
