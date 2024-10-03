package slide_window;

public class MaxAverage {
    public static double findMaxAverage(int[] nums, int k) {
        if(k > nums.length) {
            return -1;
        }
        // sum of k item first
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        // slice window
        int top = 1;
        int bot = k;
        double maxSum = sum;
        for (int i = top; bot + 1 < nums.length; i++) {
            sum = sum - nums[i - 1] + nums[bot++];
            if(sum > maxSum) maxSum = sum;
        }
        return maxSum / k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println("Result: " + findMaxAverage(nums, k));
    }
    
}
