package AcWing._蓝桥._12_12届第一场;

import com.sun.org.apache.xalan.internal.xsltc.dom.SortingIterator;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * @author fu-xiao-liu
 * @Date 2022/4/1 15:13
 */
public class _3416时间显示 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Instant now = Instant.ofEpochMilli(sc.nextLong() - 8*60*60*1000);
        now.atZone(ZoneId.of( "Asia/Shanghai"));
        LocalDateTime ldt = LocalDateTime.ofInstant(now, ZoneId.of("Asia/Shanghai"));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        String strDate2 = ldt.format(dtf);
        System.out.println(strDate2);
    }
}
