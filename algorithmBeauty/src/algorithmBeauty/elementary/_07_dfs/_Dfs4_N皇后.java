package algorithmBeauty.elementary._07_dfs;

import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/26 0:04
 */
public class _Dfs4_N皇后 {
    static int ans[];
    static int n;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ans = new int[n];
        dfs(0);
        //System.out.println(cnt);
    }
    private static void dfs(int row) {
        if (row == n) {
            cnt++;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n ; j++) {
                    if (ans[i] == j){
                        System.out.print("Q");
                    }else {
                        System.out.print(".");
                    }

                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        //遍历当前row 行的每一列
        for (int col = 0; col < n; col++) {
            boolean an = true;
            for (int i = 0; i < row; i++) {
                if (ans[i] == col || ans[i] + i == row + col || i - ans[i] == row - col) {
                    an = false;
                    break;
                }
            }
            //第col行满足, 横纵以及对角线没有皇后的要求
            if (an) {
                ans[row] = col;
                dfs(row + 1);
            }
        }
    }
}
