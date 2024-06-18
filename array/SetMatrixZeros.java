import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeros {
    /*
     * Input: m x n integer matrix matrix, 
     * if an element is 0, set its entire row and column to 0's. (Using In-place)
     */
    public static int[][] setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // processing
        List<int[]> zeroPositions = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j] != 0) {
                    continue;
                } 
                int postZero[] = {i, j};
                zeroPositions.add(postZero);
            }
        }

        // set zero
        for (int i = 0; i < zeroPositions.size(); i++) {
            int[] posZero = zeroPositions.get(i);

            int idxRow = posZero[0];
            int idxCol = posZero[1];

            for (int j = 0; j < col; j++) {
                matrix[idxRow][j] = 0;
            }

            for (int k = 0; k < row; k++) {
                matrix[k][idxCol] = 0;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] originalArray = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        int[][] result = setZeroes(originalArray);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");                
            }
            System.out.println();
        }
    }
}
