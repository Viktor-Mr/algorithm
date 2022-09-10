package AcWing._基础._05DP.Pa_02_线性DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author fu-xiao-liu
 * @Date 2022/4/7 22:44
 * DP数组存放的是不同长度的上升子序列的最小值
 */
public class _Case03_01最长上升子序列II {
    static int len = 0;
    // 定义数组a 用于 存放输入,数组f 用于存放最长上升子序列
    static int []a = new int[ 100000  +1];
    static int []f = new int[ 100000  +1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().split(" ")[0]);
        String[] s = br.readLine().split(" ");


        for (int i = 1; i <= n; i++) a[i] = Integer.parseInt(s[i-1]);

        f[++len] = a[1];
        for (int i = 2; i <= n ; i++) {
            if( a[i] > f[len] ) f[++len] = a[i];
            else {  //替换掉第一个大于或者等于这个数字的那个数
                int tmp = find(a[i]);
                f[tmp] = a[i];
            }
        }
        System.out.println(len);
    }
    //利用二分查找 第一个大于或者等于这个数字的那个数
    public static int find(int x){
        int l = 1 ;
        int r = len;
        while (l < r) {
            int mid = l + r >> 1;
            if(f[mid] >= x ) r = mid;
            else l = mid +1;
        }
        return l;

    }
}
