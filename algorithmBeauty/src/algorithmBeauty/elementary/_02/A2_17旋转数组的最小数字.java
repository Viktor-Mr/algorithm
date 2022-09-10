package algorithmBeauty.elementary._02;

import org.junit.Test;

/**
 * @author
 * @date 2021-06-06 15:44
 */
public class A2_17旋转数组的最小数字 {
    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转.
     * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素.例如数组{3，4，5，1，2}为{1，2，3，4，5的一个旋转，
     * 该数组的最小值为1.
     * 解法： 利用二分查找，判断左边或者右边是无序。最小的数必然出现在无序的一边
     * 缺陷： 0 1 1 1   ->   1 1 1 0
     */
    public static int min(int[] arr) {
        //递增旋转序列
        int begin = 0;
        int end = arr.length - 1;
        // 没有旋转的这种特性
        if (arr[begin] <= arr[end]) return arr[begin];
        //begin 和 end 指向相邻元素，退出
        while (begin +1  < end) {
            int mid = begin + ((end - begin) >> 1);
            //要么左侧有序 ，要么右侧有序  ↓左侧有序
            if (arr[begin] <= arr[mid]) {
                begin = mid ;
            } else {
                end = mid   ;
            }
        }
        return arr[end];
    }


    @Test
    public void run0() throws Throwable {
        int []arr = {4,5,1,2,3};
        int []arrs = {3,2,1,6,5,4};

        System.out.println(min(arr));
        System.out.println(minn(arrs));
    }

/**
 * @date  递减序列
 */
    public static int minn(int[] arr) {
        int begin = 0;
        int end = arr.length - 1;
        // 没有旋转的这种特性
        if (arr[begin] >= arr[end]) return arr[end];
        //begin 和 end 指向相邻元素，退出
        while (begin + 1 < end ) {
            int mid = begin + ((end - begin) >> 1);
            //要么左侧有序 ，要么右侧有序  ↓左侧有序
            if (arr[begin] >= arr[mid]) {
                begin = mid ;
            } else {
                end = mid   ;
            }
        }
        return arr[begin];
    }
}
