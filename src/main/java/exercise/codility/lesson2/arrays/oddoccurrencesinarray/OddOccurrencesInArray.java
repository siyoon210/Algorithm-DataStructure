package exercise.codility.lesson2.arrays.oddoccurrencesinarray;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] A) {
        Map<Integer, Boolean> map = new HashMap<>();

        for (int i : A) {
            if (map.containsKey(i)) {
                map.put(i, !map.get(i));
            } else {
                map.put(i, true);
            }
        }

        for (Map.Entry<Integer, Boolean> integerBooleanEntry : map.entrySet()) {
            if (integerBooleanEntry.getValue()) {
                return integerBooleanEntry.getKey();
            }
        }

        return 0;
    }
}

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        int[] A = {9, 3, 9, 3, 9, 7, 9};

        Solution solution = new Solution();
        System.out.println(solution.solution(A));
    }
}
