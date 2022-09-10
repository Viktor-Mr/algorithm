package AcWing._蓝桥._13_12届第二场;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author fu-xiao-liu
 * @Date 2022/4/6 20:34
 */
public class _3492负载均衡 {

    static Comparator<int[]> cmp = new Comparator<int[]>() {

        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        // 计算机剩余算力的维护
        int f[] = new int[n + 1];
        s = reader.readLine().split(" ");
        for (int i = 1; i <= n; i++) f[i] = Integer.parseInt(s[i - 1]);

        // 使用优先队列维护计算机结束时间的数量  ps 每个堆是一个数组，o[0]是结束时间 o[1]是使用的算力
        PriorityQueue<int[]>[] queues = new PriorityQueue[n + 1];
        // 初始化每个堆（每台计算机）， 确定堆的排序顺序
        for (int i = 1; i <= n; i++) {
            queues[i] = new PriorityQueue<>(cmp);
        }

        int a, b, c, d;
        while (m-- > 0) {
            s = reader.readLine().split(" ");
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);
            c = Integer.parseInt(s[2]);
            d = Integer.parseInt(s[3]);

            //先判断在当前时间点是否存在可以归还算力的计算机
            while (queues[b].size() > 0 && queues[b].peek()[0] <= a) {
                f[b] += queues[b].poll()[1];
            }
            if (f[b] < d) {

                System.out.println("-1");

            }
            else {
                queues[b].add(new int[]{a + c, d});//堆中添加新数据
                f[b] -= d; //削减算力
                System.out.println(f[b]);
            }
        }
    }
}
