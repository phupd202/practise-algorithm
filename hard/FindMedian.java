package hard;

import java.util.Arrays;

public class FindMedian {
    // LC4
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = mergerArray(nums1, nums2);

        int idxMedian = mergedArray.length / 2;
        if(mergedArray.length % 2 == 0) {
            System.out.println("Med1: " + mergedArray[idxMedian]);
            System.out.println("Med2: " + mergedArray[idxMedian - 1]);
            return (double) (mergedArray[idxMedian] + mergedArray[idxMedian - 1]) / 2;
        }
        return mergedArray[idxMedian];
    }

    public static int[] mergerArray(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
    
        int[] mergedArray = new int[length1 + length2];
        int i = 0, j = 0, curIdx = 0;
    
        while (i < length1 && j < length2) {
            if (nums1[i] < nums2[j]) {
                mergedArray[curIdx++] = nums1[i++];
            } else {
                mergedArray[curIdx++] = nums2[j++];
            }
        }

        while (i < length1) {
            mergedArray[curIdx++] = nums1[i++];
        }
    
        while (j < length2) {
            mergedArray[curIdx++] = nums2[j++];
        }
    
        return mergedArray;
    }

    public static void main(String[] args) {
       int[] nums1 = {1, 2};
       int[] nums2 = {3, 4}; 

       int[] mergerArray = mergerArray(nums1, nums2);
       System.out.println("After merger 2 array: " + Arrays.toString(mergerArray));
       System.out.println("Median of 2 arrays: " + findMedianSortedArrays(nums1, nums2));
    }
}

