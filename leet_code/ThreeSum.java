package leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * Ý tưởng: 
 * C1: Brute Force --> Không khả thi
 * C2: Giảm độ phức tạp xuống O(n^2) bàng cách:
 *  - duyệt từng phần tử
 *  - kiểm tra 2 phần tử bất kỳ trong list có bằng sum - nums[hiện tại hay không], sử dụng con trỏ để tăng tốc độ duyệt
 * --> Thay vì tính tống của 3 giá trị --> chỉ tính tổng của 2 giá trị thôi
 */

public class ThreeSum {
    static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        int targetSum = 0; // giả thiết: tổng 3 số bằng 0

        for (int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                int left = i + 1;
                int right = nums.length - 1;
                int currentSum = targetSum - nums[i];

                while(left < right) {
                    if(nums[left] + nums[right] == currentSum) {
                        Integer[] triplet = {nums[i], nums[left], nums[right]};
                        List<Integer> item = new ArrayList<Integer>(Arrays.asList(triplet)); 
                        if(nums[left] == nums[left + 1]) left++;
                        if(nums[right] == nums[right - 1]) right--;
                        result.add(item);
                        left++;
                        right--;
                    } else if(nums[left] + nums[right] < currentSum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 1, -2, -1, -4};

        System.out.println(threeSum(nums));
    }
    
}
