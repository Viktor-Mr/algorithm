package algorithmBeauty.elementary._02;

import java.util.Arrays;
import java.util.Random;

/**
 * 在连续的 0 --- n-1  连续的数中，找出出现两次的数
 * @date 2021-06-02 22:52
 */
public class FindDifferent {
    public static void main(String[] args) {
        numberC();
    }
    public static void numberC(){
        int N = 111;
        int a[] = new int[N];
        for (int i = 0; i < N-1; i++) {
            a[i] = i;
        }
        a[N-1] = new Random().nextInt(N-1) +1;
        System.out.println(Arrays.toString(a));
        int x = 0;
        for (int i = 1; i < N-1; i++) {
            x = x^i;
        }
        for (int i: a) {
            x = x^i;
        }
        System.out.println(x);
    }
}
