package leet_code;

import java.util.Arrays;

public class MoveZeros {
    public static void moveZeroes(int[] nums) {
        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[i] == 0 && nums[j] != 0) {
                swap(nums, i, j);
                i++;
            } else if (nums[i] != 0) {
                i++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int nums[] = {0,1,0,3,12};

        moveZeroes(nums);
        for(int e: nums) {
            System.out.print(e + " ");
        }
    }
}
