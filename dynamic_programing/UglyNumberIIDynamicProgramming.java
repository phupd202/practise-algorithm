package dynamic_programing;

public class UglyNumberIIDynamicProgramming {
    public static int nthUglyNumber(int n) {
        int uglyNumbers[] = new int[n];
        uglyNumbers[0] = 1;

        int numberMultiOf2 = 2;
        int numberMultiOf3 = 3;
        int numberMultiOf5 = 5;
        int index2 = 0, index3 = 0, index5 = 0;

        for(int i = 1; i < n; i++) {
            int nextUglyNumber = Math.min(numberMultiOf2, Math.min(numberMultiOf3, numberMultiOf5));
            uglyNumbers[i] = nextUglyNumber;

            if(nextUglyNumber == numberMultiOf2) {
                index2++;
                numberMultiOf2 = uglyNumbers[index2] * 2;
            }

            if(nextUglyNumber == numberMultiOf3) {
                index3++;
                numberMultiOf3 = uglyNumbers[index3] * 3;
            }

            if(nextUglyNumber == numberMultiOf5) {
                index5++;
                numberMultiOf5 = uglyNumbers[index5] * 5;
            }
        }
        return uglyNumbers[n - 1];
    }
}
