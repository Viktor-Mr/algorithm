package algorithmBeauty.elementary._08_dp;

import java.util.ArrayList;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/3 18:53
 * 求最大公共子序列问题
 * AB34C
 * A1BC2 结果为 ABC
 * 更多案例请看测试用例
 * */
public class Case13_LCS {
    public static void main(String[] args) {
        ArrayList ans = dfs("3069248", "513164318");
        System.out.println(ans);
         ans = dp("3069248", "513164318");
        System.out.println(ans);
    }


    /**
     * @date  利用递归的写法
     */
    private static ArrayList dfs(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        ArrayList<Character> ans = new ArrayList();
        for (int i = 0; i < len1; i++) {
            ArrayList<Character> list = new ArrayList<>();

            for (int j = 0; j < len2; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    list.add(s1.charAt(i));
                    list.addAll(dfs(s1.substring(i+1),s2.substring(j+1)));
                    break;
                }
            }

            if (list.size() > ans.size()) {
                ans = list;
            }
        }
        return ans;
    }

    /**
     * @date 递推
     */
    private static ArrayList dp(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        int dp[][]  = new int[len1+1][len2+1];

        ArrayList  ans = new ArrayList();
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if (s1.charAt(i-1) == s2.charAt(j-1))dp[i][j]  = dp[i-1][j-1]+1;
            }
        }
        int i = len1;
        int j = len2;
        while (i > 0 && j>0 ) {
                // 比左和上大，一定是当前位置的字符相等
                if( dp[i][j] > Math.max(dp[i - 1][j], dp[i][j - 1]) ){
                    ans.add(s1.charAt(i-1));
                    i--;
                    j--;
                }
                else {
                    if (dp[i-1][j] <= dp[i][j-1]) {
                        j--;
                    }else {
                        i--;
                    }
                }

        }
        System.out.println(dp[len1][len2]);
        return ans;
    }

}
