public class RemoveElement {
    
    public static int removeElement(int[] nums, int val) {
        int after_size = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                after_size++;
            }
        }
        return 0;
    }
}
