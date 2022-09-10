package algorithmBeauty.elementary._07_dfs;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/26 13:30
 */
public class Dfs_6_困难的串 {
   static int n;
   static int l;
   static char []ans;
   static  int count;
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       n = sc.nextInt();
       l = sc.nextInt();
       ans = new char[n];
       dfs(0);
   }
    /**
     * @param k 在ans第k为寻找一个字母 ,使得ans成为困难串
     */
    private static void dfs(int k) {

        for (char i = 'A'; i < l+'A'; i++) {
            if (check(k,i)){

                ans[k] = i;
                System.out.println(String.valueOf(ans).substring(0,k));
                count++;
                if(count  == n ) {
                    System.exit(0);
                    break;
                };
                dfs(k+1);
                ans[k] = 0;  //回溯



            }
        }
   }
   /**
    * @date   检查困难串 ,在ans下标为k的位置插入字母j
    */
    private static boolean check(int k, char i) {
        String str = new String(ans);
        str  = str.substring(0,k);
        int count = 0 ; //截取的宽度
        for (int j = str.length() - 1; j >= 0; j -= 2) {
            final String s1 = str.substring(j, j + count + 1);
            final String s2 = str.substring(j + count + 1) + i;
            if (s1.equals(s2))
                return false;
            count++;
        }
        return true;
    }
}
