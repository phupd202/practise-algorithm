package sorting;

import java.util.Arrays;

public class QuickSort {

    // quicksort
    public static void quickSort(int[] arrays, int l, int r) {
        if (l >= r) {
            return;
        }

        int m = partition(arrays, l, r);
        quickSort(arrays, l, m - 1);
        quickSort(arrays, m + 1, r);
    }

    // partition
    private static int partition(int[] arrays, int l, int r) {
        int pivot = arrays[l];
        int i = l + 1;
        int j = r;

        while (i <= j) {
            while (i <= j && arrays[i] < pivot) {
                i++;
            }

            while (i <= j && arrays[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(arrays, i, j);
                i++;
                j--;
            }
        }

        swap(arrays, l, j);
        return j;
    }

    // swap
    private static void swap(int[] arrays, int i, int j) {
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }

    public static void main(String[] args) {
        int[] arrays = {7, 3, 4, 2, 1, 6, 5};
    
        quickSort(arrays, 0, arrays.length - 1);
    
        System.out.println(Arrays.toString(arrays));
    }
    
}