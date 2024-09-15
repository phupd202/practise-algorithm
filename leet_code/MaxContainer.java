package leet_code;

/*
Leetcode medium
Problem 11
 */
public class MaxContainer {
    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;

        int maxContainer = 0;
        int currentArea = 0;
        while(i < j) {
            currentArea = Math.min(height[i], height[j]) * (j - i);
            System.out.println("currentArea" + currentArea);
            maxContainer = Math.max(maxContainer, currentArea);

            if(height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxContainer;
    }

    public static void main(String[] args) {
        int height[] = {1,8,6,2,5,4,8,3,7};
        int height2[] = {1,1};
        System.out.println("Max container is: " + maxArea(height));
        System.out.println("Max container is 2: " + maxArea(height2));
    }
}
