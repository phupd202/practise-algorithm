package medium;

public class UglyNumberII {
    public static int nthUglyNumber(int n) {
        int count = 0;

        int beginNumber = 1;
        int resultAfterCheck = 0;
        while(count < n) {
            if(checkUglyNumber(beginNumber) == true) {
                resultAfterCheck = beginNumber;
                count++;
            }
            beginNumber++;
        }
        return resultAfterCheck;
    }

    public static boolean checkUglyNumber(int n) {
        if(n <= 0) {
            return false;
        } 

        int temp = n;
        while(temp % 5 == 0 || temp % 3 == 0 || temp % 2 == 0) {
            if(temp % 5 == 0) {
                temp = temp / 5;
            } 

            if(temp % 3 == 0) {
                temp = temp / 3;
            }

            if(temp % 2 == 0) {
                temp = temp / 2;
            }
        }
        // check ugly number
        if(temp == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 390;
        System.out.println(checkUglyNumber(390));
    }
}
