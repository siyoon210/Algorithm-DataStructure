package exercise.kakaoblind2017.shuttlebus;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
 1. 버스는 09:00이후 부터 도착한다.
 2. 총 n회, t분 간격으로 도착하며 하나의 셔틀에는 m명까지 수용가능하다.
 3. 09:00도차한 셔틀은 09:00 도착한 크루까지 태우고 바로 출발한다.
 Q) 셔틀을 탈수 있는 제일 늦은 시간을 구하라
 */
public class Main {
    public static void main(String[] args) throws Exception {
        int n, t, m;

        /*입력*/
        n = 1;
        t = 1;
        m = 1;
        String[] timetable = new String[1];
        timetable[0] = "23:59";

        System.out.println(solution(n, t, m, timetable));

    } //main

    private static String solution(int n, int t, int m, String[] timetable) {
        LinkedList<String> timetableList = new LinkedList<>();
        for (int i = 0; i < timetable.length; i++) {
            timetableList.add(timetable[i]);
        }
        //일단 제일 먼저 온 사람 부터 늦게 온 사람까지 정렬하자
        Collections.sort(timetableList);

        //셔틀버스가 도착하는 첫시간은 09시
        String arriveTime = "09:00";
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                //만약 줄을 스고 있는 크루가 더이상 없다면
                if (timetableList.isEmpty()) {
                    return arriveTime;
                }

                //만약 버스가 도착한 시간이 크루가 도착한 시간이 크거나 같은 경우만 데려간다.
                if (arriveTime.compareTo(timetableList.getFirst()) >= 0) {
                    if (j == m - 1 && i == n-1) {
                        return calculateTime(timetableList.getFirst(),-1);
                    }
                    timetableList.removeFirst();
                }
            }

            //마지막 차가 아닌 경우에만 다음 도착 시간을 구함
            if (i != n - 1) {
                arriveTime = calculateTime(arriveTime, t);
            }
        }

        return arriveTime;
    } //solution

    private static String calculateTime(String time, int add) {
        Calendar cal = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date = null;
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.setTime(date);
        cal.add(Calendar.MINUTE,add);

        return sdf.format(cal.getTime());
    }
}
