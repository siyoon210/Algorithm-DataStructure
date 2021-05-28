package exercise.programmers.hash.camouflage;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashMap = setCountOfClotheType(clothes);
        for (Map.Entry<String, Integer> stringIntegerEntry : hashMap.entrySet()) {
            answer *= stringIntegerEntry.getValue();
        }
        return answer - 1;
    }

    private HashMap<String, Integer> setCountOfClotheType(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap();
        for (String[] clothe : clothes) {
            String type = clothe[1];

            if (map.containsKey(type)) {
                map.put(type, map.get(type) + 1);
            } else {
                //안입는 것도 포함하기 때문에 2부터 시작
                map.put(type, 2);
            }
        }

        return map;
    }
}

public class Camoflage {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        Solution solution = new Solution();
        int solution1 = solution.solution(clothes);
        System.out.println(solution1);
    }
}
