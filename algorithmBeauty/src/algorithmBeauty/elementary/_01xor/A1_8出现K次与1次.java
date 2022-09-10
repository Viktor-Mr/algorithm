package algorithmBeauty.elementary._01xor;

import java.util.Arrays;

/**
 * @author
 * @date 2021-06-05 15:15
 *  题目： 数组里面有 i个数都是出现 k 次 ，和一个数出现了一次 ，总个数 i * k + 1
 *
 */
public class A1_8出现K次与1次 {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 3, 3, 3, 5, 5, 5, 66666};
        int len = arr.length;
        char[][] k = new char[len][];
        int e = 3;
        int maxLen = 0;
        //读取每个数的十进制 转换为 二进制
        for (int i = 0; i < len; i++) {
            k[i] = new StringBuilder(Integer.toString(arr[i], e)).reverse().toString().toCharArray();
            if (maxLen < k[i].length) {
                maxLen = k[i].length;
            }
        }
        int[] resArr = new int[maxLen];
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < maxLen; j++) {
//                if (j >= k[i].length) {
//                    resArr[j] += 0;
//                } else {
//                    resArr[j] += (k[i][j] - '0');
//                }
//            }
//        }
        //这里实现 len个数的第i位求和
        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < len; j++) {
                if (  k[j].length > i  ){
                    resArr[i] += (k[j][i] - '0');
                }
            }
        }
        int res = 0;
        for (int i = 0; i < maxLen; i++) {
            res += (resArr[i]% e) * (int)(Math.pow(e,i));
        }
        System.out.println(res);

    }
}
