package three_month_prepare_for_kit.week_1;

import java.util.Scanner;

public class CamelCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read data
        // while (scanner.hasNextLine()) {
        //     String input = scanner.nextLine();
        //     String[] parts = input.split(";");
        //     String operation = parts[0];
        //     String type = parts[1];
        //     String words = parts[2];

        //     if (operation.equals("S")) {
        //         // Case: split
        //         System.out.println(splitCamelCase(words, type));
        //     } else if (operation.equals("C")) {
        //         // Case: combine
        //         System.out.println(combineToCamelCase(words, type));
        //     }
        // }
        // scanner.close();

        // Test 
        System.out.println(splitCamelCase("mobile phone", "V"));
        System.out.println(combineToCamelCase("white sheet of paper", "V"));
    }

    // Case: split
    public static String splitCamelCase(String input, String type) {
        // Delete () if is method
        if (type.equals("M")) {
            input = input.replace("()", "");
        }

        // Regex to add space between terms capitalization
        String result = input.replaceAll("([a-z])([A-Z])", "$1 $2").toLowerCase();
        return result;
    }

    // Case: combine
    public static String combineToCamelCase(String input, String type) {
        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (i == 0 && (type.equals("V") || type.equals("M"))) {
                // If variable, method --> keep begin character
                result.append(words[i].toLowerCase());
            } else {
                // captitalize the remainting letter
                result.append(words[i].substring(0, 1).toUpperCase()).append(words[i].substring(1).toLowerCase());
            }
        }

        // Adding "()" if is method
        if (type.equals("M")) {
            result.append("()");
        }
        return result.toString();
    }
}
