package codingTest.ln20.p4;

import java.util.*;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public String[][] solution(String[][] snapshots, String[][] transactions) {
        Map<String, Integer> accounts = new HashMap<>();
        Set<Integer> adjustedTxId = new HashSet<>();

        for (String[] snapshot : snapshots) {
            accounts.put(snapshot[0], Integer.valueOf(snapshot[1]));
        }

        for (String[] tx : transactions) {
            if (adjustedTxId.contains(Integer.valueOf(tx[0]))) {
                continue;
            }

            adjustedTxId.add(Integer.valueOf(tx[0]));

            if (tx[1].equals("SAVE")) {
                accounts.merge(tx[2], Integer.valueOf(tx[3]), (integer, integer2) -> integer + Integer.parseInt(tx[3]));
            } else if (tx[1].equals("WITHDRAW")) {
                accounts.merge(tx[2], Integer.valueOf(tx[3]), (integer, integer2) -> integer - Integer.parseInt(tx[3]));
            } else {
                throw new IllegalArgumentException();
            }
        }

        String[][] answer = new String[accounts.size()][2];

        final Iterator<Map.Entry<String, Integer>> iterator = accounts.entrySet().iterator();

        for (int i = 0; i < answer.length; i++) {
            final Map.Entry<String, Integer> next = iterator.next();
            answer[i] = new String[]{next.getKey(), String.valueOf(next.getValue())};
        }

        Arrays.sort(answer, Comparator.comparing(o -> o[0]));

        return answer;
    }
}

public class P4 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(
                new String[][]{{"ACCOUNT1", "100"},
                        {"ACCOUNT2", "150"},
                        {"ACCOUNT10", "150"}},
                new String[][]{{"1", "SAVE", "ACCOUNT2", "100"},
                        {"2", "WITHDRAW", "ACCOUNT1", "50"},
                        {"1", "SAVE", "ACCOUNT2", "100"},
                        {"4", "SAVE", "ACCOUNT3", "500"},
                        {"3", "WITHDRAW", "ACCOUNT2", "30"}}
        ))
                .isEqualTo(
                        new String[][]{{"ACCOUNT1", "50"},
                                {"ACCOUNT10", "150"},
                                {"ACCOUNT2", "220"},
                                {"ACCOUNT3", "500"}});

        out.println("ln P4" + " success!");
    }
}
