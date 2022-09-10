package AcWing._蓝桥._04__枚举与模拟与排序;

import java.io.*;

/**
 * @author fu-xiao-liu
 * @Date 2021/11/16 13:26
 */
public class _Case06_01_归并排序 {
    static int n;
    static int a[] = new int[100010];
    static int b[] = new int[100010];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        mergeSort(0, n - 1);
        for (int i = 0; i < n; i++) {
            out.write(a[i] + " ");
        }
        in.close();
        out.flush();
        out.close();
    }

    private static void mergeSort(int l, int r) {


        if (l < r) {
            int mid =( l + r )>> 1;
            mergeSort(l, mid);  // l ~ mid
            mergeSort(mid + 1, r); // mid +1 ,r
            merge(l, mid, r);
        }
    }

    private static void merge(int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        // i   ~ mid;
        // j   ~ r
        int k = l;
        //放入B 中
        while (i <= mid  && j <= r) {
            if (a[i] <= a[j]) b[k++] = a[i++];
            else b[k++] = a[j++];
        }


        while ( i <= mid) b[k++] = a[i++];

        while ( j <= r) b[k++] = a[j++];

        for (int q = l; q <= r ; q++)  a[q] = b[q];


    }
}
