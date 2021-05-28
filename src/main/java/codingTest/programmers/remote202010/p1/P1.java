package codingTest.programmers.remote202010.p1;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    private static class Kiosk implements Comparable<Kiosk>{
        private int index;
        private int remainTime; //처리중인 고객의 요청처리 남은시간
        private int waitingTime; //대기시간

        public Kiosk(int index) {
            this.index = index;
        }

        public boolean isWorking() {
            return remainTime > 0;
        }

        @Override
        public int compareTo(Kiosk o) {
            if (this.isWorking() && !o.isWorking()) {
                return 1;
            }

            if (!this.isWorking() && o.isWorking()) {
                return -1;
            }

            if (this.waitingTime != o.waitingTime) {
                return this.waitingTime - o.waitingTime;
            }

            if (this.remainTime != o.remainTime) {
                return this.remainTime - o.remainTime;
            }

            return this.index - o.index;
        }
    }

    public int solution(int n, String[] customers) {
        int answer = 0;
        for (String customer : customers) {
        }
        return answer;
    }
}

public class P1 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(3, new String[]{"10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24", "10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10"})).isEqualTo(4);
        assertThat(solution.solution(2, new String[]{"02/28 23:59:00 03", "03/01 00:00:00 02", "03/01 00:05:00 01"})).isEqualTo(2);

        out.println("p1" + " success!");
    }
}
