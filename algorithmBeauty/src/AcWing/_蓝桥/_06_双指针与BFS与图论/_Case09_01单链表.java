package AcWing._蓝桥._06_双指针与BFS与图论;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/23 0:41
 */
public class _Case09_01单链表 {

    static  int m = 100010;
    static  int head  ,idx;
    static  int []e = new int[m];
    static  int []ne = new int[m];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
         head = -1;
        while (n-- > 0){
            String[] s = in.readLine().split(" ");
            if (  s[0].charAt(0) == 'H'){
                add(Integer.parseInt(s[1]));
            }else if (s[0].charAt(0) == 'D') {
                if (Integer.parseInt(s[1]) == 0 ) head = ne[head];
                else remove(Integer.parseInt(s[1])-1);
            }
            else{
                insert(Integer.parseInt(s[1])-1,Integer.parseInt(s[2]));
            }
        }
        for (int i = head; i != -1 ; i = ne[i])
            System.out.print(e[i] + " ");
        System.out.println();
    }

    private static void insert(int k, int x) {
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx++;
    }

    private static void remove(int k) {
        ne[k] = ne[ne[k]];
    }

    private static void add(int x) {
        e[idx] = x;
        ne[idx] = head;
        head = idx ++;
    }
}
