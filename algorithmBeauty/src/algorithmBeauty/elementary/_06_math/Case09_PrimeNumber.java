package algorithmBeauty.elementary._06_math;

import java.util.HashMap;
import java.util.Map;

public class Case09_PrimeNumber {
    public static void main(String[] args) {
        Map<Integer, Integer> map = primeFactor(10034340);
        StringBuffer sb = new StringBuffer();
        for ( Map.Entry<Integer,Integer> e :  map.entrySet()) {
            Integer key = e.getKey();
            Integer value = e.getValue();
            for (int i = 0; i < value; i++) {
                sb.append("*").append(key);
            }
        }
        System.out.println(sb.substring(1));
    }
    
    public static Map<Integer,Integer> primeFactor(int m){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 2; i <= m; i++) {
            while(m % i == 0){
                if (map.get(i) == null){
                    map.put(i,1);
                }else{
                    Integer v = map.get(i);
                    map.put(i,v+1);
                }
                m /= i;
            }
        }        
        return map;
    }
}
