package algorithmBeauty.elementary._02;

import org.junit.Test;

/**
 * @author
 * @date 2021-06-06 17:08
 */
public class A2_19最长连续递增子序列 {
    public static void S(int arr[]){
        int max = 0;  //最大长度
        int index = 0; //最大长度的下标
        int len = 1;  //当前长度
        int lenIndex = 0;  //当前长度的下标
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] <= arr[i]){
                len++;
                if (len > max){
                    index = lenIndex;
                    max = len;
                }
            }else {
                len = 1;
                lenIndex = i;
            }
        }
        System.out.println(max+ " " + index);
    }
    @Test
    public  void one(){
        int []arr = {1,9,2,5,7,4,6,8,0};
        S(arr);
    }
}
