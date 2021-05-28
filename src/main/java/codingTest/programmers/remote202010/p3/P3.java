package codingTest.programmers.remote202010.p3;

import java.util.HashSet;
import java.util.Set;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int solution(int n, int[][] groups) {
        boolean[] switchOn = new boolean[n + 1];
        return dfs(groups, switchOn, Integer.MAX_VALUE, 0, 0);
    }

    private int dfs(int[][] groups, boolean[] switchOn, int minCount, int currCount, int depth) {
        if (isAllSwitchOn(switchOn)) {
            minCount = Math.min(minCount, currCount);
            return minCount;
        }

        if (depth == groups.length) {
            int offCount = 0;
            for (int i = 1; i < switchOn.length; i++) {
                if (!switchOn[i]) {
                    offCount++;
                }
            }

            minCount = Math.min(minCount, currCount + offCount);
            return minCount;
        }

        //그냥 안하고 지나치기
        int dfs1 = dfs(groups, switchOn, minCount, currCount, depth + 1);

        //갱신해보기
        boolean renew = false;
        Set<Integer>  renewedIndices = new HashSet<>();
        for (int i = groups[depth][0]; i <= groups[depth][1]; i++) {
            if (!switchOn[i]) {
                renewedIndices.add(i);
                renew = true;
            }
            switchOn[i] = true;
        }

        //갱신 된경우
        int dfs2 = Integer.MAX_VALUE;
        //갱신 안된경우 (이미 다 true라서 카운트에 넣을수 없는경우)
        int dfs3 = Integer.MAX_VALUE;
        if (renew) {
            dfs2 = dfs(groups, switchOn, minCount, currCount + 1, depth + 1);

            for (int i = groups[depth][0]; i <= groups[depth][1]; i++) {
                //여기서 뺼때, 예전에 이미 들어와있던거 끄면 안되지!
                if (renewedIndices.contains(i)) {
                    switchOn[i] = false;
                }
            }
        } else {
            dfs3 = dfs(groups, switchOn, minCount, currCount, depth + 1);
        }

        return Math.min(Math.min(dfs1, dfs2), dfs3);
    }

    private boolean isAllSwitchOn(boolean[] switchOn) {
        for (int i = 1; i < switchOn.length; i++) {
            if (!switchOn[i]) {
                return false;
            }
        }

        return true;
    }
}

public class P3 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(10, new int[][]{{1, 5}, {2, 7}, {4, 8}, {3, 6}})).isEqualTo(4);
        assertThat(solution.solution(7, new int[][]{{6, 7}, {1, 4}, {2, 4}})).isEqualTo(3);
        assertThat(solution.solution(100, new int[][]{{1, 50}, {1, 100}, {51, 100}})).isEqualTo(1);

        out.println("p3" + " success!");
    }
}
