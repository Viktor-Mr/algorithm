package algorithmBeauty.book.cc150;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/21 23:56
 */
public class _9_6合法括号 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        way1(n);
        Set<String> set = way2(n);
        System.out.println();
        System.out.println(set.size());
        for (String s:set) {
            System.out.print(s + " ");
        }
        System.out.println();
       way3(n);
    }

    private static void way3(int n) {
        char[] chars = new char[n * 2];
        recursion2(n,n,chars,0);
    }

    private static void recursion2(int l, int r, char[] chars, int count) {
        if (l == 0 && r == 0 ) System.out.print (String.valueOf(chars) + " ");
        if ( l > r || l < 0  ) return ;

        if(l>0){
            chars[count] = '(';
            recursion2(l-1,r,chars,count+1);
        };
        if(l < r){
            chars[count] = ')';
            recursion2(l, r-1, chars, count + 1);
        }
    }


    /*
     * @date 递归形式 
     */
    private static void way1(int n) {
        Set<String> rec = recursion(n);
        System.out.println(rec.size());
        for ( String s: rec) {
            System.out.print(s + " ");
        }
    }

    private static Set<String> recursion(int n) {
        Set<String> set = new HashSet<>();
        if(n == 1) {
            set.add("()");
            return set;
        }

        Set<String> rec = recursion(n - 1);
        for (String string : rec) {
            set.add("()" + string);
            set.add(string + "()");
            set.add("(" + string +")");
            for (int i = 0; i < string.length() ; i++) {
                char c = string.charAt(i);
                if (c == '('){
                    set.add(string.substring(0,i+1) + "()" + string.substring(i+1));
                }
            }
        }
        return set;
    }

    /*
     * @date 递推形式
     */
    private static Set<String> way2(int n) {
        Set<String> res = new HashSet<>();//保存上次迭代的状态
        res.add("()");
        if (n == 1) {
            return res;
        }
        for (int i = 2; i <= n; i++) {
            Set<String> res_new = new HashSet<>();

            for (String e : res) {
                res_new.add(e + "()");
                res_new.add("()" + e);
                res_new.add("(" + e + ")");
                //  更正：在内部也可以添加
                 for (int j = 0; j < e.length(); j++) {
                   char c = e.charAt(j);//每一个字符
                   if (c=='(')//只要这个字符是左括号，我们就可以在其后插入一对括号
                     res_new.add(e.substring(0,j+1)+"()"+e.substring(j+1));
                 }
            }
            res = res_new;
        }
        return res;
    }


}
