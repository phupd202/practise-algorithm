package three_month_prepare_for_kit.week_1;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class PlusMinus {
    public static void plusMinus(List<Integer> arr) {
        int numPos = 0;
        int numNev = 0;
        int numZero = 0;

        for (Integer item : arr) {
            if(item.compareTo(0) > 0) {
                numPos++;
            } else if(item.compareTo(0) < 0) {
                numNev++;
            } else {
                numZero++;
            }
        } 
        DecimalFormat df = new DecimalFormat("#.######");

        System.out.println(df.format((double) numPos / arr.size()));
        System.out.println(df.format((double) numNev / arr.size()));
        System.out.println(df.format((double) numZero / arr.size()));
    }

    public static void main(String[] args) {
        Integer arr[] = { 1, 1, 0, -1, -1 };
        plusMinus(Arrays.asList(arr));
    }
}
