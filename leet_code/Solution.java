package leet_code;

class Solution {
    public int pivotIndex(int[] nums) {
        int sumLeft = 0;
        int sumRight = sum(nums) - nums[0];

        if(sumLeft == sumRight) {
            return 0;
        }

        for(int i = 1; i < nums.length;i++) {
            sumLeft += nums[i-1];
            sumRight -= nums[i] - sumLeft;

            if(sumLeft == sumRight) {
                return i;
            }
        }
        return -1;
    }

    public static int sum(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}