package AcWing._基础._05DP.Pa_02_线性DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author fu-xiao-liu
 * @Date 2022/4/7 23:57
 * 利用栈，完成替换最后一个元素
 */
public class _Case03_02最长上升子序列II {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().split(" ")[0]);
        String[] s = br.readLine().split(" ");
        // 定义数组a 用于 存放输入
         int []a = new int[ n  +1];
        Stack <Integer> stack= new Stack();

        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(s[i - 1]);
            //如果该元素大于栈顶元素,将该元素入栈
            if ( stack.size() == 0 || a[i] > stack.peek())stack.push(a[i]);
            else { //替换掉第一个大于或者等于这个数字的那个数

            }
        }

    }
}
