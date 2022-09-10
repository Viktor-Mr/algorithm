package algorithmBeauty.elementary._02;

import org.junit.Test;

/**
 * @author
 * @date 2021-06-06 16:28
 */
public class A2_18寻找特定的字符串 {
    /**
     有个排序后的字符串数组，其中散布着一些空字符串，编写一个方法，找出给定字符串（肯定不是空字符串)的索引。

     */
    public static int indexOf(String []arr, String ans) {
        int begin = 0;
        int end = arr.length -1 ;

        while (begin <= end) {
            int indexOf = begin + ((end -begin)>>1 );
            while (arr[indexOf].equals(" ")){
                indexOf++;
                if (indexOf > end){
                    return  -1;
                }
            }
            //目标字符串在右边
            if( arr[indexOf].compareTo(ans)< 0 ){
                begin = indexOf + 1;
            }else if (arr[indexOf].compareTo(ans)> 0){
                end = indexOf - 1;
            }else {
                return  indexOf;
            }
        }

        return -1;
    }
    @Test
    public void run0() throws Throwable {
        String []arr = {"aa"," ","av"," ","az"," ","azq"," ","c"};
        System.out.println(indexOf(arr,"av"));
    }
}
