package leet_code;

import java.util.ArrayList;
import java.util.List;

public class GreatestNumberCandy {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<Boolean>();

        for (int i = 0; i < candies.length; i++) {
            candies[i] += extraCandies;

            if(checkMax(candies[i], candies)) {
                result.add(true);
            } else {
                result.add(false);
            }
            candies[i] -= extraCandies;
        }
        return result;
    }

    public static boolean checkMax(int a, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] > a) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] candies = {12,1,12};
        int extraCandies = 10;

        List<Boolean> result = kidsWithCandies(candies, extraCandies);

        System.out.println(result);
    }
}
