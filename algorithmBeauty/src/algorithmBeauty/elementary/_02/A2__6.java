package algorithmBeauty.elementary._02;

import org.junit.Test;

/**
 * @date 2021-06-14 22:02
 * 汉诺塔问题
 */
public class A2__6 {
    @Test
    public static void main(String[] args) {
        // 开始 辅助 目标
        hannota(1,'A','B','C');
    }

    private static void hannota(int i, char a, char b, char c) {
        if (i==0)
            return;

        hannota(i-1,a,c,b);
        System.out.println( a + " - > " + c + " " + i );
        hannota(i-1,b,a,c);
    }

}
