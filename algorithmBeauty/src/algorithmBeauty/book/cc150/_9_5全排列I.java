package algorithmBeauty.book.cc150;

import java.util.ArrayList;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/22 20:04
 */
public class _9_5全排列I {

    static String [] a = {"1","2","3"};
    public static void main(String[] args) {
        way1();
    }

    /**
     * @date 递推
     */
    private static void way1() {

        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        for (int i = 1; i < a.length; i++) {
            ArrayList<String> li = new ArrayList<>();
            for (String s : list) { //访问上一趟的集合
                String str;
                for (int j = 0; j <= s.length(); j++) {
                    str = s.substring(0,j) + a[i] + s.substring(j);
                    li.add(str);
                }
            }
            list = li;
        }
        System.out.println(list);
    }
}
