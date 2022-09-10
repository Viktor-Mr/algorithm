package AcWing._蓝桥._05_树状数组与线段树;

import java.io.*;

public class _Case03_01数列区间最大值 {
    static int N = 100010;
    static int n;
    static int m;
    static int[] w = new int[N];
    static Node[] tr = new Node[N * 4];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = in.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        s = in.readLine().split(" ");
        for (int i = 1; i <= n; i++) w[i] = Integer.parseInt(s[i - 1]);


        built(1, 1, n);
        while (m-- > 0) {
            String[] s3 = in.readLine().split(" ");
            int x = Integer.parseInt(s3[0]);
            int y = Integer.parseInt(s3[1]);

            //k = 0 是询问[x,y]的区间和，k = 1是在x位置添加y元素

            out.write(query(1, x, y) + " \n");

        }
        out.flush();
        out.close();
    }

    private static void pushUp(int u) {
        tr[u].sum = Math.max(tr[u << 1].sum , tr[u << 1 | 1].sum);
    }

    //查询某段区间的和，其中u表示根结点，l表示左边界，r表示右边界
    private static int query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) return tr[u].sum;

        int mid = tr[u].l + tr[u].r >> 1;
        int sum = 0;
        if (l <= mid) sum  = query(u << 1, l, r);
        if (r >= mid+1) sum = Math.max (query(u << 1 | 1, l, r), sum);
        return sum;
    }



    /**
     * @date 在一段区间上初始化线段树，其中u表示根结点，l表示左边界，r表示右边界
     */
    private static void built(int u, int l, int r) {
        if (l == r) tr[u] = new Node(l, r, w[r]);
        else {
            tr[u] = new Node(l, r, 0);
            //递归选择左  右 节点
            int mid = l + r >> 1;
            built(u << 1, l, mid);
            built(u << 1 | 1, mid + 1, r);
            pushUp(u);
        }
    }
}
