package algorithmBeauty.elementary._06_math;





public class Case_12Fib {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(fib(i));
        }
    }

    /**
     * 矩阵运算求解斐波那契
     * @param n
     * @return
     */
    public static long fib(long n) {
        if (n == 1 || n == 2) return 1;
        long[][] matrix = {
                {0, 1},
                {1, 1}};
        long[][] res = matrixPower(matrix, n - 1);//乘方
        res = matrixMultiply(new long[][]{{1, 1}}, res);//矩阵相乘
        return res[0][0];
    }   

    private static long[][] matrixPower(long[][] matrix, long l) {
        long[][] result = new long[matrix.length][matrix[0].length];
        //结果先初始化为单位矩阵
        for (int i = 0; i < result.length; i++) {
           result[i][i] = 1;
        }

        //一次方
        long[][] pingFang = matrix;
        while( l != 0){
            if( (l&1) != 0){
                result = matrixMultiply(result,pingFang);
            }
            pingFang = matrixMultiply(pingFang,pingFang);
            l >>= 1;
        }

        return result;
    }
    /*  1，2  2，3
    *   1，3
    *  0,0 0,1
    *  1n ，1     0,0 22，2,3
    *  2  1     1,0 2，1,1
    * */
    private static long[][] matrixMultiply(long[][] longs, long[][] res) {

        long [][] ans= new long[longs.length][res[0].length];
        for (int i = 0; i < longs.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                int size =0 ;
                for (int k = 0; k < longs[0].length; k++) {
                    size += longs[i][k] * res[k][j];
                }
                ans[i][j] =  size;
            }
        }
        return  ans;

    }


}
