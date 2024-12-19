package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargetBigNumber {
    public static String largestNumber(int[] nums) {
        // convert nums to list string
        List<String> numsList = new ArrayList<String>();
        for (int num : nums) {
            numsList.add(String.valueOf(num));
        }

        Collections.sort(numsList, (a, b) -> (b + a).compareTo(a + b));

        if(numsList.get(0).equals("0")) {
            return "0";
        }
        StringBuilder bigNumber = new StringBuilder();
        for (String num : numsList) {
            bigNumber.append(num);
        }
        return bigNumber.toString();
    }

    public static void main(String[] args) {
        int[] nums = {10,2};
        int[] nums2 = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
        System.out.println(largestNumber(nums2)); // expect: 9534330
    }
}
