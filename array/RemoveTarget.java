public class RemoveTarget {
    public static int removeElement(int[] nums, int val) {
        int head = 0;
        int tail = nums.length - 1;

        while(head <= tail) {
            if(nums[head] == val) {
                nums[head] = nums[tail];
                tail--;
            } else {
                head++;
            }
        }
         return tail + 1;
    }

    // helper swap two element
    public static void swap(int[] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int k = removeElement(nums, 3);

        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }

    }
}
