package leet_code;

/*
 * Ý tưởng:
 * - Ước lượng khoảng giá trị của căn bằng phương pháp chia đôi
 */
public class CalculusSquare {
    // Finding result if the number of any number
    public static double findSquareRoot(int num) {
        double floor = 1;
        double ceil = num;

        double estimate = 0;
        int numLoop = 120;
        while(numLoop > 0) {
            estimate = (floor + ceil) / 2;
            if(estimate * estimate < num) {
                floor = estimate;
            } else {
                ceil = estimate;
            }
            numLoop--;
        }
        return estimate;
    }
    
    public static void main(String[] args) {
        int num = 4;
        System.out.println(findSquareRoot(num));
    }
}
