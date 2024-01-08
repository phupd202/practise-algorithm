/*
 * Input: Give a sorted-decreaing array
 * Output: Remove the duplicate item, and keep 1 item. 
 * Example: 
 * Input: 
 * [1, 2, 2, 2, 2, 3, 3 , 3, 4, 4, 4]
 * Output: 
 * [1, 2, 3]
 * Required: Using in-place method. 
 */

public class RemoveDuplicate {
    public static int removeDuplicates(int[] nums) {
        int currentPos = 0;
        int nextPos = currentPos + 1;

        int realLength = nums.length - 1;

        while(nextPos < nums.length) {
            if(nums[currentPos] != nums[nextPos]) {
               nums[currentPos + 1] = nums[nextPos];
               currentPos++;
               nextPos++;
            } else {
                nextPos++;
                realLength--;
            }
        }
        return realLength + 1;
    }

    public static void main(String[] args) {
        int nums[] = {0,0,1,1,1,2,2,3,3,4};

        int k = removeDuplicates(nums);
        System.out.println(k);

        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
            
        }
    }
}
