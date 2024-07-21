package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Integer2Roman {
    public static String intToRoman(int num) {
        return null;
    }

    // split to round value
    public static List<Integer> splitRoundValue(int num) {
        String numStr = Integer.toString(num);

        // count digit of the number
        int numDigit = numStr.length();

        // init array to store values
        List<Integer> values = new ArrayList<Integer>();

        int numEx = numDigit - 1;
        while(numEx >= 0) {
            int placeValue = (int) Math.pow(10, numEx);
            int roundValue = num / placeValue * placeValue;

            if(roundValue > 0) {
                values.add(roundValue);
            }
            num -= roundValue;
            numEx--;
        }
        return values;
    }

    // find representation for subtraction number
    // hash: {[1, I], [5, V], [10, X], [50, L], [100, C], [500, D], [1000, M]}
    public static String findRepresentForSubtractNum(int num, Map<Integer, String> symbolRoman)  {
        String numStr = Integer.toString(num);
        int numDigit = numStr.length();

        String firstSymbol = "";
        String secondSymbol = "";
        if(numStr.startsWith("4")) {
            int maxValue = num + (int) Math.pow(10, numDigit - 1); 
            secondSymbol = symbolRoman.get(maxValue);
            firstSymbol = symbolRoman.get(maxValue - num);
        }

        if(numStr.startsWith("9")) {
            int maxValue = (int) Math.pow(10, numDigit);
            secondSymbol = symbolRoman.get(maxValue);
            firstSymbol = symbolRoman.get(maxValue - num);
        }
        return firstSymbol + secondSymbol;
    }

    // find representation for not subtraction number
    // hash: {[1, I], [5, V], [10, X], [50, L], [100, C], [500, D], [1000, M]}
    public static String findRepresentForNoSubtractNum(int num, Map<Integer, String> symbolRoman) {
        String numStr = Integer.toString(num);
        int numDigit = numStr.length();

        // if existed into symbolRoman
        if(symbolRoman.get(num) != null) {
            return symbolRoman.get(num);
        } 

        String representation = "";
        int startDigit = num / (int) Math.pow(10, numDigit - 1);
        if(startDigit < 5 && startDigit != 4) {
            int baseValue = num / startDigit;
            String baseSymbol = symbolRoman.get(baseValue);

            for (int i = 0; i < startDigit; i++) {
                representation += baseSymbol;
            }
        }

        String representationSuffix = "";
        if(startDigit > 5 && startDigit != 9) {
            int landmark = 5 * (int) Math.pow(10, numDigit - 1);
            int prefixNum = num - landmark;
            int startDigitOfPrefixNum = prefixNum / (int) Math.pow(10, numDigit - 1);

            String baseSymbol = symbolRoman.get(prefixNum / startDigitOfPrefixNum);
            int repeat = startDigit - 5;
            for (int i = 0; i < repeat; i++) {
                representationSuffix += baseSymbol;
            }
            representation += symbolRoman.get(landmark) + representationSuffix;
        }
        return representation;
    }

    public static void main(String[] args) {
        splitRoundValue(5453);

        Map<Integer, String> symbolRoman = new HashMap<Integer, String>();
        symbolRoman.put(1, "I");
        symbolRoman.put(5, "V");
        symbolRoman.put(10, "X");
        symbolRoman.put(50, "L");
        symbolRoman.put(100, "C");
        symbolRoman.put(500, "D");
        symbolRoman.put(1000, "M");

        // System.out.println(findRepresentForSubtractNum(900, symbolRoman));
        System.out.println(findRepresentForNoSubtractNum(70, symbolRoman));
    }
}
