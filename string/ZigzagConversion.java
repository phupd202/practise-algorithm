package string;

public class ZigzagConversion {
    public static String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
    
        StringBuilder result = new StringBuilder();
        int len = s.length();
    
        for (int i = 0; i < numRows + 1; i++) {
            int step = 2 * (numRows - i) - 2;
            int j = i;
    
            while (j < len) {
                result.append(s.charAt(j));
    
                if (i != 0 && i != numRows - 1 && step == 0) {
                    result.append(s.charAt(j + step - 2 * i));
                }
    
                j = j + step;
            }
        }
    
        return result.toString();
    }
    

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";

        System.out.println(s.length());

        System.out.println(convert(s, 3));
    }
}
