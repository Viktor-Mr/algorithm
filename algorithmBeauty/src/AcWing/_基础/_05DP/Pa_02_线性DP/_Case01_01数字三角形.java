package AcWing._基础._05DP.Pa_02_线性DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2022/4/7 11:53
 */
public class _Case01_01数字三角形 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[502][502];
        for (int i = 0; i < 502; i++) {
            Arrays.fill(nums[i],Integer.MIN_VALUE);
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= i ; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        for (int i = 2; i <=n ; i++) {
            for (int j = 1; j <= i ; j++) {
               nums[i][j] += Math.max(nums[i-1][j],nums[i-1][j-1]);
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <=n ; i++) {
            System.out.println(nums[n][i]);
            max = Math.max(max,nums[n][i]);

        }

        System.out.println(max);
    }


}
