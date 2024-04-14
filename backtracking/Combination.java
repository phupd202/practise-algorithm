package backtracking;

public class Combination {
    void printCombination(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n && j != i; j++) {
                for (int k = 1; k <= n && k != j && k != i; k++) {
                    System.out.println(i + "" + j + "" + k);
                }
            }
        }
    }

    public static void main(String[] args) {
        Combination comp = new Combination();
        comp.printCombination(3);
    }
}
