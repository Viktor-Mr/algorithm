package algorithmBeauty.elementary._02;

import java.util.Arrays;

/**
 * @author
 * @date 2021-06-01 19:21
 */
public class SortWay {
    public static void main(String[] args) {

        int a[] = {1,2,3,4,6,7,8,9};
        int b[] = new int[5];

        shellSort(a);
        System.out.println(Arrays.toString(a));
        System.arraycopy(a,0,b,0,5);

        a[1] = 0;
        System.out.println(b[0]);
        //charNumber();
        int aa[] = {1,2,2123,3,4,5,6,5,7,8,9,10};
       // oneSort(aa);
        twoSort(aa);
        System.out.println(        Arrays.toString(aa));

        System.out.println(  Arrays.binarySearch(aa,35351));
        //System.out.println(  binarySearch(aa,567));
    }
    /**
     * @date  选择排序
     */
    private static void twoSort(int[] ans) {
        for (int i = 0; i < ans.length -1 ; i++) {
            for (int j = i+1; j < ans.length  ; j++) {
                if ( ans[j] > ans[i]){
                    ans[i] = (ans[i] + ans[j] ) -( ans[j] = ans[i]);
                }
            }
        }
        for (int a : ans)
        { System.out.println(a); }
    }

    /**
     * @date 冒泡排序
     */
    private static void oneSort(int ans[]) {
        for (int i = 0; i < ans.length -1 ; i++) {
            for (int j = 0; j < ans.length -1 -i; j++) {
                if ( ans[j] > ans[j+1]){
                    ans[j+1] = (ans[j+1] + ans[j] ) -( ans[j] = ans[j+1]);
                }
            }
        }
        for (int a : ans)
        { System.out.println(a); }
    }

    public static void  charNumber(){
        String str = "fdsafdsfasdgasreggqrgergergerg";
        int ans[] = new int[58];
        char []chr = str.toCharArray();
        for(char c : chr){
            ans[c-65]++;
        }
        for (int i = 0; i < 58; i++){
            System.out.println( (char)(65+i)  + " = " + ans[i]);
        }
    }
    /**
     * @date  二分查找
     * @param e
     * @param target
     * @return int
     */
    public static int binarySearch(int []e, int target){
        int begin = 0 ;
        int end = e.length-1;
        while (begin  <= end) {
            int indexOf =  (end + begin) >> 1;
            int mid = e[indexOf];
            if (  target > mid ){
                begin = mid +1;
            }else if (target < mid){
                end = mid - 1;
            }else {
                return indexOf;
            }
        }
        return -1;
    }
    /**
     * @date 希尔排序
     */
    public static void shellSort(int []arr){
        //不断缩小增量
        for (int interval = arr.length/2; interval > 0; interval=interval/2) {
            //增量为1的插入排序
            for (int i = interval; i < arr.length; i++) {
                int target = arr[i];
                int index = i;
                while (  index >= interval && target < arr[index-interval] ){
                    arr[index] = arr[index-interval];
                    index-=interval;
                }
                arr[index] = target;
            }
        }
    }
}
