package algorithmBeauty.book.cc150;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/23 15:25
 */
public class _9_5全排列III {
    static String [] a = {"1","2","3"};
    public static void main(String[] args) {
        way1();
    }

    /**
     * @date 前缀法
     */
    ArrayList<String> ans = new ArrayList<>();
    private static void way1() {
        recursion("");
    }



    private static void recursion(String prefix ) {
        if (prefix.length() == a.length) {
            System.out.println(prefix);
        }
        //每次都从头扫描,只要该字符可用,我们就附加到前缀后面,前缀变长了
        for (int j = 0; j < a.length; j++) {
            //这个字符可用:在pre中出现次数<在字符集中的出现次数
            if ( count(prefix,a[j]) < count(a,a[j]) ){
                recursion(prefix  + a[j]);
            }
        }
    }

    private static int count(String s, String ch) {
        char[] chars = s.toCharArray();
        char[] chars1 = ch.toCharArray();
        int cnt = 0;
        for (char c: chars){
            if (c == chars1[0]) {
                cnt++;
            }
        }
        return cnt;
    }
    private static int count(String[] a, String prefix) {
        int cnt = 0;
        for (String s: a) {
            if (s.equals(prefix)) {
                cnt++;
            }
        }
        return cnt;
    }

}
