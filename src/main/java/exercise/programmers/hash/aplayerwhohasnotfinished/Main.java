package exercise.programmers.hash.aplayerwhohasnotfinished;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String part : participant) {
            hashMap.merge(part, 1, Integer::sum);
        }

        for (String comp : completion) {
            hashMap.put(comp, hashMap.get(comp)-1);
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : hashMap.entrySet()) {
            if (stringIntegerEntry.getValue() > 0) {
                return stringIntegerEntry.getKey();
            }
        }

        return null;
    }
}

public class Main {
    public static void main(String[] args) {
//        String[] participant = {"leo", "kiki", "eden"};
//        String[] completion = {"eden", "kiki"};
//        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
//        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        Solution solution = new Solution();
        System.out.println(solution.solution(participant, completion));
    }
}