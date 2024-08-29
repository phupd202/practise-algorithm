package three_month_prepare_for_kit.week_1;

public class TimeConversion {
    public static String timeConversion(String s) {
        /*
         * PM: Cộng h với thực tế với 12, ngoại trừ th đặc biệt 12:...PM
         * AM: Giữ nguyên, trừ trường hợp đặc biệt12:...AM
         */
        Integer len = s.length();
        String preString = s.substring(0, len - 2);
        String timeComponent[] = preString.split(":");
        String posString = s.substring(len - 2, len);
        switch (posString) {
            case "PM":
                if(timeComponent[0].equals("12")) {
                    return preString;
                } else {
                    int hourMilitary = Integer.parseInt(timeComponent[0]) + 12;
                    return hourMilitary + ":" + timeComponent[1] + ":" + timeComponent[2];
                }
            case "AM":
                if(timeComponent[0].equals("12")) {
                    return "00" + ":" + timeComponent[1] + ":" +  timeComponent[2];
                } else {
                    return preString;
                }
            default:
                break;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(timeConversion("12:01:00PM"));
        
    }
    
}
