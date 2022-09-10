package algorithmBeauty.elementary._08_dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2021/10/30 14:07
 */
public class Case03_区间调度问题 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] s = new int[n];
        int[] t = new int[n];
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            jobs[i] = new Job(s[i], t[i]);
        }
        Arrays.sort(jobs);
        for ( Job j:
           jobs  ) {
            System.out.println(j);
        }
        int ans = 1;
        int k = 0; //现在在参加的活动
        for (int i = 1; i < n; i++) {
            if (jobs[i].s >= jobs[k].t) {
                k = i;
                ans++;
            }
        }
        System.out.println(ans);
    }

    static  class  Job implements Comparable<Job> {
        int s;  //开始时间
        int t;  //结束时间

        public Job(int s, int t) {
            this.s = s;
            this.t = t;
        }

        @Override
        public int compareTo(Job o) {
            if (this.t == o.t) return this.s - o.s;
            else return this.t - o.t;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "s=" + s +
                    ", t=" + t +
                    '}';
        }
    }
}
