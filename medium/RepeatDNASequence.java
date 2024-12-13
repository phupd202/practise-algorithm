package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatDNASequence {
    // ver 0
    public static List<String> findRepeatedDnaSequencesV0(String s) {
        int len = s.length();
        if(s.length() < 10 ) {
            return null;
        }

        Map<String, Integer> subDNAMap = new HashMap<String, Integer>();
        Set<String> result = new HashSet<String>();
        for (int i = 0; i <= len - 10; i++) {
            String subString = s.substring(i, i + 10);
            if(!subDNAMap.containsKey(subString)) {
                subDNAMap.put(subString, i);
                System.out.println("Add to map!!!");
            } else {
                result.add(subString);
                System.out.println("Add to list result!!!");
            }
        }
        System.out.println("Map of substring: " + subDNAMap.toString());
        return new ArrayList<>(result);
    }

    // ver 1: first optimization
    public static List<String> findRepeatedDnaSequencesV1(String s) {
        int len = s.length();
        if(s.length() < 10 ) {
            return null;
        }

        Set<String> filterSet = new HashSet<String>();
        Set<String> result = new HashSet<String>();
        for (int i = 0; i <= len - 10; i++) {
            String subString = s.substring(i, i + 10);
            if(!filterSet.contains(subString)) {
                filterSet.add(subString);
            } else {
                result.add(subString);
            }
            
        }
        return new ArrayList<>(result);
    }

    // ver 2: second optimization
    public static List<String> findRepeatedDnaSequencesV2(String s) {
        int len = s.length();
        if(s.length() < 10 ) {
            return null;
        }

        Set<String> filterSet = new HashSet<String>();
        Set<String> result = new HashSet<String>();
        for (int i = 0; i <= len - 10; i++) {
            String subString = s.substring(i, i + 10);
            if(!filterSet.add(subString)) {
                result.add(subString);
            }   
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        // AAAAAAAAAAA
        String s0 = "AAAAAAAAAAAAA";
        String s1 = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        String s2 = "AAAAAAAAAAAAA";

        System.out.println("Lenth of test case string: " + s0.length());

        String subSequenceDNA = findRepeatedDnaSequencesV0(s1).toString();
        System.out.println("Sub sequence DNA: " + subSequenceDNA);
    }
}
