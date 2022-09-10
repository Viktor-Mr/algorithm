package AcWing._蓝桥._01_递归与递推;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/9 22:54
 */
public class _Case08_01翻硬币 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();
        char[] ans = sc.nextLine().toCharArray();
        boolean [] b = new boolean[chars.length];
        boolean [] ab = new boolean[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '*') b[i] = true;
            if (ans[i] == '*')   ab[i] = true;
        }
        int n = chars.length;
        int num = 0;

        /*if (b[0] == ab[0])*/{
            for (int i = 0; i < n-1; i++) {
                //判断,当前的 b 是否 等于 ab
                if(b[i] == ab[i]) continue;
                else { //需要改变 i / i + 1
                    num++;
                    b[i] = !b[i];
                    b[i+1] = !b[i+1];
                }
            }
            System.out.println(num);
        }/*else {

        }*/


    }
}
