public class ValidPalindrone {
    public static boolean isPalindrome(String s) {
        int len = s.length();

        // check base case
        if(len == 0 || len == 1) {
            return true;
        }

        // preprocessing: lowercase, remove ',', ":", space
        s = preprocessing(s);

        // using 2 pointer
        for(int i = 0; i < len; i++) {
           if(s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
           }
        }
        return true;
    }

    public static String preprocessing(String s) {
        StringBuilder str = new StringBuilder(s.toLowerCase());

        int i = str.length() - 1;
        while (i >= 0) {
            char token = str.charAt(i);
    
            if (token < 'a' || token > 'z') {
                str.deleteCharAt(i);
            } else {
                i--;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String s1 = "amanaplanacanalpanama";
        System.out.println(isPalindrome(s1));
        String s2 = "raceacar";
        System.out.println(isPalindrome(s2));
        String s3 = " ";
        System.out.println(isPalindrome(s3));
        String s4 = "s";
        System.out.println(isPalindrome(s4));

        // test preprecessing
        System.out.println(preprocessing("A man, a plan, a canal: Panama"));

        System.out.println();
    }
}
