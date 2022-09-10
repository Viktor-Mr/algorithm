package algorithmClass;

import org.junit.Test;

/**
 * 矩阵乘法问题
 * 递推式 ： D[i,j] = min (D[i][k] + D[K+1,j] + pi-1*pk*pj
 *
 * @date 2021-06-10 21:12
 */
public class DP_MatrixMultiplication {
    static int p[] = {2, 3, 7, 9, 5, 2, 4};
    static int d[][];
    static int rac[][];
    static int n;

    @Test
    public void run0() throws Throwable {
        n = p.length;
        d = new int[n + 1][n + 1];
        rac = new int[n + 1][n + 1];
        MatrixChainMultiply();
        System.out.println(d[1][n - 1]);
        PrintMatrixChain(1, n - 1);
        System.out.println();

    }

    private void MatrixChainMultiply() {
        for (int l = 2; l < n; l++) {
            int j = l;
            for (int i = 1; i <= n - l; i++) {
                d[i][j] = 0x7fffffff;
                for (int k = i; k <= j - 1; k++) {
                    int q = d[i][k] + d[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < d[i][j]) {
                        d[i][j] = q;
                        rac[i][j] = k;
                    }
                }
                j++;
            }
        }
    }

    private void PrintMatrixChain(int i, int j) {
        if (i == j) {
            System.out.print("U" + i);
            return;
        }
        System.out.print("(");
        PrintMatrixChain(i, rac[i][j]);
        System.out.print(")(");
        PrintMatrixChain(rac[i][j] + 1, j);
        System.out.print(")");
        return;
    }
}
