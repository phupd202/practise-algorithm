public class MaxSumSubArray {
    public static int findMaxSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        // iterate array
        for (int i = 0; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // duy trì đến hết mảng --> tìm được kết quả
            maxSum = Math.max(currentSum, maxSum);

        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(Integer.MIN_VALUE);

        System.out.println("Max sum sub array of the array is: " + findMaxSum(nums));
    }

    // Idea:
    /*
     * maxSum(i) = maxSum(i-1) + currentItem
     * 
     */
}
