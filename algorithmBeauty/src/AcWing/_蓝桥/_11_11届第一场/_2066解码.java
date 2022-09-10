package AcWing._蓝桥._11_11届第一场;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2022/3/31 11:23
 *
 */
public class _2066解码 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i<str.length()){
            char c = str.charAt(i);
            if ( i == str.length() - 1 || str.charAt(i + 1) > 64) {
                 sb.append(c);
                 i++;
                continue;
            }
            // a(97) A(65)  0 (48)
            for (int j = 48; j < str.charAt(i+1); j++) {
                sb.append(c);
            }
            i = i + 2;
        }

        System.out.println(sb);
    }
}
