package codingTest.programmers.remote202010.p2;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public String solution(String p, int n) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("a hh:mm:ss");
            Timestamp timestamp = new Timestamp(dateFormat.parse(p).getTime() + (long) n * 1000);
            return timestamp.toString().split(" ")[1].substring(0, 8);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}

public class P2 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution("PM 01:00:00", 10)).isEqualTo("13:00:10");
        assertThat(solution.solution("PM 11:59:59", 1)).isEqualTo("00:00:00");

        out.println("p2" + " success!");
    }
}
