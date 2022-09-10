package AcWing._基础._02数据结构;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author fu-xiao-liu
 * @Date 2022/4/7 9:41
 */
public class _栈3302表达式求值 {
    //创建两个栈用于维护 数字 以及 运算符号
    static Stack<Integer> num = new Stack();
    static Stack<Character> op = new Stack();

    //创建一个 Map 用于维护符号的优先级
    static HashMap<Character, Integer> pr = new HashMap<Character, Integer>() {{
        {
            put('+', 1);
            put('-', 1);
            put('*', 2);
            put('/', 2);
        }
    }};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {

            //判断是否为数字
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int x = 0, j = i;
                //读取多为数字
                while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {

                    x = x * 10 + s.charAt(j++) - '0';
                }
                i = j - 1;
                num.push(x);
            } else if (s.charAt(i) == '(') {
                op.push('('); // 将左括号存入字符栈栈顶
            } else if (s.charAt(i) == ')') {
                //如果栈顶不等于左括号，一直计算下去；
                while (op.peek() != '(') eval();
                op.pop();// 将左括号弹出栈顶
            }
            //判断是否为 + - * /
            else {
                while (op.size() != 0 && op.peek() != '(' && pr.get(op.peek()) >= pr.get(s.charAt(i))) eval();
                op.push(s.charAt(i));
            }
        }
        while (op.size() != 0) eval();
        System.out.println(num.peek());
    }

    static void eval() {
        int b = num.pop();
        int a = num.pop();
        int c = op.pop();
        int x;
        if (c == '+') x = a + b;
        else if (c == '-') x = a - b;
        else if (c == '*') x = a * b;
        else x = a / b;
        num.push(x);
    }
}
