package review;
/*
 * Remove duplicated item in array with in-place method. 
 */
public class RemoveDuplicate {
    public static int removeDuplicate(int[] nums, int val) {
        int head = 0;
        int tail = nums.length - 1;

        while(head < tail) {
            if(nums[head] == val && nums[head] == nums[tail]) {
                tail--;
            }

            if(nums[head] == val && nums[head] != nums[tail]) {
                nums[head] = nums[tail];
                tail--;
                head++;
            }
            head++;
        }

        return tail;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 2, 5, 7, 5, 6, 5};

        int k = removeDuplicate(nums, 2);

        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
