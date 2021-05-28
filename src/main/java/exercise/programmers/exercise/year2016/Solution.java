package exercise.programmers.exercise.year2016;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Solution {
    public static void main(String[] args) {
        int a = 5;
        int b = 24;
        System.out.println(solution(a, b));
    }

    public static String solution(int a, int b) {
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        String strA = Integer.toString(a);
        String strB = Integer.toString(b);

        if (a < 10) {
            strA = "0" + a;
        }
        try {
            date = sdf.parse("2016" + strA + strB);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.setTime(date);
        String[] str = calendar.getTime().toString().split(" ");
        return str[0].toUpperCase();
    }
}
