package easy;

import java.util.Arrays;

public class FindArrayState {
    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int idxMin = findIdxMin(nums);
            nums[idxMin] = nums[idxMin] * multiplier;
        }
        return nums;
    }

    // first version
    // private int findIdxMin(int[] nums) {
    //     int min = nums[0];
    //     int minIdx = 0;
    //     for (int i = 1; i < nums.length; i++) {
    //         if(nums[i] < min) {
    //             min = nums[i];
    //             minIdx = i;
    //         }
    //     }
    //     return minIdx;
    // }

    // optimize version
    private static int findIdxMin(int[] nums) {
        int minIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            minIdx = nums[i] < nums[minIdx] ? i : minIdx;
        }
        return minIdx;
    }
    public static void main(String[] args) {
        int[] nums = {1,2};

        int[] result = getFinalState(nums, 3, 4);
        System.out.println("Result: " + Arrays.toString(result));
        // System.out.println("Test min: " + findIdxMin(nums));
    }
}
