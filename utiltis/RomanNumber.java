package utiltis;

import java.util.HashMap;
import java.util.Map;

public class RomanNumber {
    public static int romanToInt(String s) {
        Map<Character, Integer> mapNumber = new HashMap<Character, Integer>();

        mapNumber.put('I', 1);
        mapNumber.put('V', 5);
        mapNumber.put('X', 10);
        mapNumber.put('L', 50);
        mapNumber.put('C', 100);
        mapNumber.put('D', 500);
        mapNumber.put('M', 1000);

        int result = 0;
        int valueOfPrevios = 0;
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            int valueOfCurrent = mapNumber.get(item);

            if (i > 0 && valueOfCurrent > valueOfPrevios) {
                result += valueOfCurrent - 2 * valueOfPrevios;
            } else {
                result += valueOfCurrent;
            }

            valueOfPrevios = valueOfCurrent;
        }
        return result;



        //     if(i == 0) {
        //         result += mapNumber.get(item);
        //         valueOfPrevios = valueOfCurrent;
        //     } else {
        //         valueOfCurrent = mapNumber.get(item);

        //         if(valueOfCurrent > valueOfPrevios) {
        //             result = result - valueOfPrevios + valueOfCurrent - valueOfPrevios;
        //         } else {
        //             result += valueOfCurrent;
        //         }

        //         valueOfPrevios = valueOfCurrent;
        //     }
   
        // }
        // return result;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";

        System.out.println("Converted Value: " + romanToInt(s));
    }
}
