package leet_code;

public class FiboDp {
    public static int tribonacci(int n) {
        if(n <= 1) {
            return n;
        }

        if(n == 2) {
            return 1;
        }

        int T0 = 0;
        int T1 = 1;
        int T2 = 1;
        int Tn = 0;

        for (int i = 3; i < n + 1; i++) {
            Tn = T2 + T1 + T0;
            
        }
        

       return Tn;
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(4));
         System.out.println(tribonacci(1)); // expect: 1389537
    }
}
