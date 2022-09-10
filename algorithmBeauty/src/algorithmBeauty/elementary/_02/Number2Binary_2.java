package algorithmBeauty.elementary._02;

/**
 * @author
 * @date 2021-05-31 12:53
 */
public class Number2Binary_2 {
    public static void main(String[] args) {
        binaryToTwo(-8);
    }

    public static void binaryToTwo(int n) {
        for (int i = 31; i >= 0; i--)
            System.out.print(n >>> i & 1);
    }
    public static void binaryTo(int n) {
        int t = 0;  //用来记录位数
        int bin = 0; //用来记录最后的二进制数
        int r = 0;  //用来存储余数
        while (n != 0) {
            r = n % 2;
            n = n / 2;
            bin += r * Math.pow(10, t);
            t++;
        }
        System.out.println(bin);
    }

    public static void binaryToThree(int number) {
        boolean flag = true;
        if (number < 0) {
            number = -number;
            flag = false;
        }
        String binary = "";
        int yu;
        int count = 0;
        while (number != 0) {
            yu = number % 2;
            number /= 2;
            count++;
            if (count % 4 == 0) {
                binary = "_" + yu + binary;
            } else {
                binary = yu + binary;
            }
        }
        while (count < 31) {
            count++;
            if (count % 4 == 0) {
                binary = "_" + 0 + binary;
            } else {
                binary = 0 + binary;
            }
        }
        if (flag) {
            binary = 0 + binary;
        } else {
            String bin = "";
            int j = binary.lastIndexOf('1');
            System.out.println(j);
            for (int i = 0; i < j; i++) {
                if ((binary.substring(i, i + 1)).equals("1")) {
                    bin = bin + 0;
                } else if (binary.substring(i, i + 1).equals("0")) {
                    bin = bin + 1;
                } else {
                    bin = bin + binary.substring(i, i + 1);
                }
            }
            binary = '1' + bin + binary.substring(j, 38);
        }
        System.out.println(binary);
    }
}