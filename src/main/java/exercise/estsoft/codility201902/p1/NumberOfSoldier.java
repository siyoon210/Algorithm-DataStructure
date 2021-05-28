package exercise.estsoft.codility201902.p1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] ranks) {
        // 1. 보고를 받는 군인이 아닌, 보고를 해야하는 군인의 숫자를 세야한다.
        // 보고는 자신보다 1계급 높은 직속상관에게만 한다.
        int numberOfSoldiers = 0;
        // 2. Map을 이용해서 키값에는 군인의 숫자 계급이 들어가고, 밸류에는 각 계급의 군인이 몇명인지 들어간다.
        Map<Integer, Integer> map = new HashMap<>();
        // 3. 입력된 배열을 이용해서, Map을 설정한다.
        for (int rank : ranks) {
            if (map.containsKey(rank)) {
                map.put(rank, map.get(rank) + 1);
            } else {
                map.put(rank, 1);
            }
        }

        // 4. 설정된 map 을 반복문으로 돌면서, 만약 1계급 높은 직속상관이 있다면, 해당 밸류를 더한다.
        for (Integer integer : map.keySet()) {
            if (map.containsKey(integer + 1)) {
                numberOfSoldiers += map.get(integer);
            }
        }
        return numberOfSoldiers;
    }
}

public class NumberOfSoldier {
    public static void main(String[] args) {
        int[] ranks = {3, 4, 3, 0, 2, 2, 3, 0, 0};

        Solution solution = new Solution();
        System.out.println(solution.solution(ranks));
    }
}
