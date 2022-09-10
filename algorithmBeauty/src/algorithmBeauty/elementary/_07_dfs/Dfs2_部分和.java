package algorithmBeauty.elementary._07_dfs;

import java.util.ArrayList;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/25 20:08
 */
public class Dfs2_部分和 {
    static int a[] = {1,2,4,7};
    public static void main(String[] args) {
        //way1(14);
        way2(5);
    }

    /**
     * @date dfs ,在深搜的中往往伴随着回溯
     */
    private static void way2(int k) {
        dfs(new ArrayList<>(),k,0);
    }

    private static  void dfs(ArrayList<Integer> list, int k, int i) {
        if (k == 0) {
            System.out.println(list);
            return;
        }
        if (i >= a.length || k < 0 ) return;

        //不选第i个数
        dfs(list,k,i+1);

        //选第i个数
         list.add(a[i]);
        int size = list.size() - 1;
        dfs(list,k-a[i],i+1);
        list.remove(size); //回溯

    }


    /**
     * @date 递推法
     */
    private static void way1(int k) {
        int n = (int) (Math.pow(2,a.length)-1);
        for (int i = 1; i <= n; i++) {
            int ans = 0;
            ArrayList<Integer> list = new ArrayList<>();
            //通过二进制 各个1的位置 求出应该选数组中那个几个加到ans中
            for (int j = 0; j < a.length; j++ ) {
                if ( ((i>>j)&1) == 1 ) {
                    ans += a[j];
                    list.add(a[j]);
                }

            }
            if (ans ==  k) {
                System.out.println("yes");
                System.out.println(list);
            }
        }
    }
}
