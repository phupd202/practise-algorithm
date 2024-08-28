package three_month_prepare_for_kit.week_1;

import java.util.Arrays;
import java.util.List;

/*
 * Approach 1: 
 * - Caculate all set of number of array, afterward find min and max
 * - This approach is very simple and clean, with five integer, we have 5 set to calculate
 * Approach 2: 
 * - Sorting array, sum of 4 first number is min, sum of 4 last number is max
 * Compare
 * - Approach 1: Should be use for size of array is small
 * - Approach 2: Should be use for size of array is large
 */
public class MiniMaxSum {
    public static void miniMaxSum(List<Integer> arr) {
        // sorting with quicksort
        quickSort(arr, 0, arr.size() - 1);

        long minSum = 0;
        for (int i = 0; i < 4; i++) {
            minSum += arr.get(i);
        }

        // Calculate the maximum sum of the last 4 numbers
        long maxSum = 0;
        for (int i = arr.size() - 4; i < arr.size(); i++) {
            maxSum += arr.get(i);
        }

        // Print the results
        System.out.println(minSum + " " + maxSum);

    }

    public static int partition(List<Integer> list, int l, int r) {
        // Choose the pivot (first element in this case)
        int pivot = list.get(l);
        int i = l + 1;
        int j = r;

        while (i <= j) {
            while (i <= j && list.get(i) < pivot) {
                i++;
            }

            while (i <= j && list.get(j) > pivot) {
                j--;
            }

            if (i <= j) {
                swap(list, i, j);
                i++;
                j--;
            }
        }

        // Place the pivot in its correct position
        swap(list, l, j);
        return j;
    }

    public static void quickSort(List<Integer> arr, int start, int end) {
        if (start >= end) {
            return;
        }
        // sort
        int partition = partition(arr, start, end);
        quickSort(arr, start, partition - 1);
        quickSort(arr, partition + 1, end);
    }

    public static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public static void main(String[] args) {
        Integer num[] = { 7, 3, 4, 2, 1, 6, 5 };

        quickSort(Arrays.asList(num), 0, num.length - 1);
        for (Integer item : num) {
            System.out.print(item + " ");
        }
    }
}
