import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        // Create result list
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        // Add 1 into result list
        List<Integer> firstItem = new ArrayList<Integer>();
        firstItem.add(1);
        result.add(firstItem);

        if (numRows == 1) {
            return result;
        } else {
            for (int i = 1; i < numRows; i++) {
                List<Integer> preRow = result.get(i - 1);

                List<Integer> iItem = getCurrentItemPascal(preRow);
                result.add(iItem);
            }
        }
        return result;
    }

    public static List<Integer> getCurrentItemPascal(List<Integer> preRow) {
        List<Integer> currentRow = new ArrayList<Integer>();
        int sizePreRow = preRow.size() + 1;

        for (int i = 0; i < sizePreRow; i++) {
            if (i == 0 || i == sizePreRow - 1) {
                currentRow.add(1);
            } else {
                int sum = preRow.get(i - 1) + preRow.get(i);
                currentRow.add(sum);

            }

        }
        return currentRow;
    }

    public static void main(String[] args) {
        int numRow = 7;

        List<List<Integer>> pascal = generate(numRow);

        System.out.println(pascal);
    }

}
