package algorithmBeauty.elementary._06_math;

import java.util.ArrayList;
import java.util.Scanner;

public class Case01_天平称重 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        //转换为三进制
        String s = Integer.toString(N, 3);

        char[] arr = new StringBuffer(s).reverse().toString().toCharArray();
        //存放答案的list
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '2'){
                list.add(0,-1); //在开头的为自己加上
                if (i == arr.length - 1) {
                    list.add(0,1);   //在最后的位置直接追加
                }else{
                    arr[i+1] ++;
                }
            }else if (arr[i] == '3'){
                list.add(0,0);
                if (i == arr.length -1){
                    list.add(0,1);
                }else{
                    arr[i+1]++;
                }
            }else{
                list.add(0,arr[i] - '0');
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1) sb.append("+").append((int) Math.pow(3, list.size() - i - 1));
            if (list.get(i) == -1) sb.append("-").append((int) Math.pow(3, list.size() - i - 1));
        }

        System.out.println(sb.substring(1));
    }
}
