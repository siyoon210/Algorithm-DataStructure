package exercise.kakaoblind2017.choosuktraffic;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

class Solution {
    static class Log {
        LocalDateTime startTime;
        LocalDateTime endTime;

        Log(final LocalDateTime startTime, final LocalDateTime endTime) {
            this.startTime = startTime.plus(1L, ChronoUnit.MILLIS);
            this.endTime = endTime;

            System.out.println("this = " + this.toString());
        }

        boolean isInclude(LocalDateTime from, LocalDateTime to) { //외부에서 들어오는 시간
            //시작시간이 from~ to 사이이거나
            //끝시간이 fromt ~ to 사이이면 트루
//            System.out.println("startTime.isAfter(from) = " + startTime.isAfter(from));
//            System.out.println("startTime.isBefore(to) = " + startTime.isBefore(to));
//            System.out.println("endTime.isBefore(from) = " + endTime.isBefore(from));
//            System.out.println("endTime.isBefore(to) = " + endTime.isBefore(to));

            return (startTime.isBefore(to) && endTime.isAfter(from))
                    || (startTime.isBefore(to) && endTime.isAfter(to))
                    || (startTime.isAfter(from) && endTime.isBefore(to))
                    || (startTime.isBefore(from) && endTime.isBefore(to))
                    || (startTime.isEqual(from) || endTime.isEqual(to) || startTime.isEqual(to)); // todo 같은시간을 어디까지 포함인지 >= 인지 > 인지 확인해볼것
        }

        @Override
        public String toString() {
            return "Log{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }
    }

    public int solution(String[] lines) {
        List<Log> logs = new ArrayList<>();
        int answer = 0;

        //먼저 입력값을 분석해서 해당 라인의 시작시간과 끝시간을 계산해내는 로직을 구현
        for (final String line : lines) {
            final String[] s = line.split(" ");
            LocalDateTime endTime = LocalDateTime.parse(s[0] + "T" + s[1]);

            final String substring = s[2].substring(0, s[2].length() - 1);

            final LocalDateTime startTime = endTime.minus((long) (Double.parseDouble(substring) * 1000), ChronoUnit.MILLIS);

            logs.add(new Log(startTime, endTime));
        }

        //맨처음만 시작시간으로하고 이후 부터는 끝시간으로 포문
        for (final Log log : logs) {
            if (log.isInclude(logs.get(0).startTime, logs.get(0).startTime.plus(1L, ChronoUnit.SECONDS))) {
                answer++;
                continue;
            }

            break;
        }


        for (int i = 0; i < logs.size(); i++) {
            int tmpAnswer = 0;

            for (int j = i; j < logs.size(); j++) { //todo 이미 남은 갯수가 정답갯수보다 적다면 굳이 안돌아도 되지만 일단 넘어감
                if (logs.get(j).isInclude(logs.get(i).endTime, logs.get(i).endTime.plus(1L, ChronoUnit.SECONDS))) {
                    tmpAnswer++;
                    continue;
                }
                break;
            }

            answer = Math.max(answer, tmpAnswer);
        }

        return answer;
    }
}

public class ChoosukTraffic {
    public static void main(String[] args) {
        String[] lines = {"2016-09-15 23:59:59.999 0.001s"};

        Solution solution = new Solution();
        System.out.println("solution.solution(lines) = " + solution.solution(lines));
    }
}
