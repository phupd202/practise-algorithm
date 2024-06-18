package sorting;

import java.util.Arrays;

public class MergeSort {
    /*
     * Review merge sort:
     * Using devide and conquer
     * Split array into 2 sub array
     * using idea merge 2 sorted subarray, partition while have 1 or 2 item
     * Design programming:
     * merge(int[] a, int[] b): to sort 2 sorted subarray
     * mergeSort(): recursive with devide and conquer strategy 
     */
    public static void main(String[] args) {
        int arr[] = {1, 5, 2, 6, 3, 4, 9, 8, 7}; // expect: 1, 2, 3, 4, 5, 6, 7, 8, 9

        int a[] = {1, 3, 5};
        int b[] = {2, 4, 6};

        System.out.println(Arrays.toString(merge(a, b)));
    }

    public static int[] merge(int a[], int b[]) {
        // length of 2 sub array
        int u = a.length;
        int v = b.length;

        // using 2 pointer to merge
        int i = 0;
        int j = 0;
        int afterMergered[] = new int[u + v];

        int currentItem = 0;
        while(i < u && j < v) {
            if(a[i] < b[j]) {
                afterMergered[currentItem++] = a[i++];
            } else {
                afterMergered[currentItem++] = b[j++];
            }
        }

        while(i < u) {
            afterMergered[currentItem++] = a[i++];
        }

        while(j < v) {
            afterMergered[currentItem++] = b[j++];
        }
        return afterMergered;
    }

    public static int[] merge(int[] array) {
        int m = array.length / 2;

    
        return null;
    }
}
