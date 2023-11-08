package leet_code;

public class CanPlaceFlower {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n <= 0) {
            return true;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if ((i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
            // if (n <= 0) {
            //     return true;
            // }
        }

        return (n <= 0);
    }

    public static void main(String[] args) {
        int[] flowerbed = { 1, 0, 1, 0, 1, 0, 1 };

        System.out.println(canPlaceFlowers(flowerbed, 0));
    }
}
