package AcWing._蓝桥._06_双指针与BFS与图论;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/21 14:16
 */
public class _Case05_01完全二叉树的权重值 {
    static int []tree = new int[200010];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");
        for (int i = 1; i < n; i++) tree[i] = Integer.parseInt(s[i-1]);


        long maxSize = (long) -1e18;
        long maxDepth= 0;
        for (long  d = 1; d <= Math.log(n+1)/ Math.log(2) + 1; d++)
       {
           System.out.println(d);
            long size = 0;
           for (int j = 1 << (d-1); j < 1 << d  && j <= n; j++){
                size += tree[j];
            }
            if (size > maxSize){
                maxSize = size;
                maxDepth = d;
            }
        }
        System.out.println(maxDepth);
    }
}






