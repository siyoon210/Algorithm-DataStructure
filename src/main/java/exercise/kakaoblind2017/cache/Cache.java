package exercise.kakaoblind2017.cache;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Map<String, Integer> cityMap = new HashMap<>();

        for (int i = 0; i < cities.length; i++) {
            if (cityMap.containsKey(cities[i].toLowerCase())) {
                answer += 1;
            } else {
                answer += 5;
            }

            cityMap.put(cities[i].toLowerCase(), i);

            if (cityMap.size() > cacheSize && !cityMap.isEmpty()) {
                String oldestKey = null;
                int lowestIndex = cities.length;

                for (final String s : cityMap.keySet()) {
                    if (cityMap.get(s) < lowestIndex) {
                        oldestKey = s;
                        lowestIndex = cityMap.get(s);
                    }
                }

                cityMap.remove(oldestKey);
            }
        }

        return answer;
    }
}

public class Cache {
    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {
                "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"
        }; //21

        Solution solution = new Solution();
        System.out.println("solution.solution(cacheSize, cities) = " + solution.solution(cacheSize, cities));
    }
}
