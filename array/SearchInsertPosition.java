public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = (left + right) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            } else if(nums[mid] > target) {
                right = mid;
            } else {
                return mid;
            }
        }

        if(target <= nums[right]) {
            return right;
        }

        if(target > nums[right]) {
            return right + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int nums[] = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 9));
    }
}
