package algorithmBeauty.elementary._06_math;

public class Case02_Nim {
    public static void main(String[] args) {
        int a[] = {5,10,15};

        int res = 0;
        for (int i = 0; i < a.length; i++) {
            res ^=a[i];
        }
        if (res == 0){
            System.out.println("win");
        }else{
            System.out.println("out");
        }

    }
}
