import java.util.Arrays;

public class FindPricesWithDiscount {
    public static int[] finalPrices(int[] prices) {
        int itemsSize = prices.length;

        // base case
        if(itemsSize <= 1) {
            return prices;
        }

        // Output
        int pricesAfterDiscount[] = new int[itemsSize];
        for (int i = 0; i < pricesAfterDiscount.length; i++) {
            int idxDiscount = findDiscountIdx(i, prices);

            pricesAfterDiscount[i] = (idxDiscount > i) ? prices[i] - prices[idxDiscount] : prices[i];
        }

        return pricesAfterDiscount;
    }

    private static int findDiscountIdx(int currentIdx, int[] prices) {
        int idxDiscount = currentIdx;

        for (int i = currentIdx + 1; i < prices.length; i++) {
            if(prices[i] <= prices[currentIdx]) {
                idxDiscount = i;
                break;
            }
        }
        return idxDiscount;
    }

    public static void main(String[] args) {
        int prices[] = {8,4,6,2,3};

        int pricesAfterDiscount[] = finalPrices(prices);

        System.out.println("Final prices after apply discount: " + Arrays.toString(pricesAfterDiscount));
    }
}
