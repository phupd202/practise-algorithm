package three_month_prepare_for_kit.week_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BreakingRecord {
    public static List<Integer> breakingRecords(List<Integer> scores) {
        // init
        Integer maxScore= scores.get(0);
        Integer minScore = scores.get(0);

        // calculation record after each season
        int minRecord = 0;
        int maxRecord = 0;
        for (int i = 1; i < scores.size(); i++) {
            Integer currentScore = scores.get(i);
            if(currentScore.compareTo(minScore) < 0) {
                minScore = currentScore;
                minRecord++;
            }

            if(currentScore.compareTo(maxScore) > 0) {
                maxScore = currentScore;
                maxRecord++;
            }
        }
       return new ArrayList<>(Arrays.asList(maxRecord, minRecord));
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(12, 24, 10, 24));
        System.out.println(breakingRecords(input).toString());
    }
}
