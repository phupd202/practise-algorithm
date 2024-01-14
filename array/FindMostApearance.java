import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindMostApearance {
    public static int findMostApearance(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int item : nums) {
            if(!map.containsKey(item)) {
                map.put(item, 1);
            }
            map.put(item, map.get(item) + 1);
        }

        // find most apearance
        int mostApearance = -1;
        int maxValue = -1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                mostApearance = entry.getKey();
            }
        }
        return mostApearance;
    }

    public static long findFactorial(int num) {
        if(num == 0) {
            return 1;
        }
        return num * findFactorial(num - 1);
    }

    // factorial 2, using dynamic programing
    public static long findFactorial2(int num) {
        int[] table_result = new int[num + 1];

        table_result[0] = 1;

        for (int i = 1; i < table_result.length; i++) {
            table_result[i] = i * table_result[i - 1];
        }
        return table_result[num];
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 4, 5, 2, 2, 4, 2}; // expect 2: 3 lần
        System.out.println(findMostApearance(nums));

        int num = 3;
        System.out.println(findFactorial2(num));

    }
}
