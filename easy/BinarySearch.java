package easy;

public class BinarySearch {
    public static int binarySearch(int[] arr, int num) {
        int length = arr.length;

        // 2 pointer
        int left = 0;
        int right = arr.length - 1;

        int mid = (left + right) / 2;
        while(mid >= 0 || mid < length) {
            if(arr[mid] == num) {
                return mid;
            } else {
                if(num > arr[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                mid = (left + right) / 2;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println("Result: " + binarySearch(arr, 5));
    }
}
