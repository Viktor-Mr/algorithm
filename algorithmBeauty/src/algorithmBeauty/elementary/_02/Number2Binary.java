package algorithmBeauty.elementary._02;

import java.util.Scanner;

/**十进制转换为二进制
 * @author
 * @date 2021-05-31 11:38
 *
 */
public class Number2Binary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.print("input a number:");
            int number = input.nextInt();
            int number2;
            // 如果是负数，需要加上2^31次方
            if (number < 0) {
                number2 = (int)(Math.pow(2,31) + number);
            }else{
                number2 = number;
            }
            String binary = "";
            // 通过辗转相除法，求出二进制数，保存在binary中
            int shang  = number2;
            int yu ;
            int count = 0;
            while(shang != 0) {
                yu = shang % 2;
                shang /= 2;
                count++;
                if (count % 4 == 0) {
                    binary = "_" + yu + binary;
                } else {
                    binary = yu + binary;
                }
            }
            // 不够32位，需要补齐
            while(count < 31){
                count++;
                if(count % 4 == 0 ){
                    binary = "_" + 0 + binary;
                }else {
                    binary = 0 + binary;
                }
            }
            //判断符号位
            if(number < 0 ){
                binary = 1 + binary;
            }else {
                binary = 0 + binary;
            }
            System.out.println(binary);
        }
    }
}
