package exercise.leetcode.p1002;

import java.util.*;

class Solution {
    public List<String> commonChars(String[] A) {
        Map<Character, Integer> mainMap = new HashMap<>();
        List<String> answer = new ArrayList<>();

        initMainMap(A[0], mainMap);

        for (int i = 1; i < A.length; i++) {
            Map<Character, Integer> subMap = new HashMap<>();
            setCharIntegerMap(A[i], subMap);

            Set<Character> mainCharacters = mainMap.keySet();

            Set<Character> charsToClear = new HashSet<>();
            for (Character mainCharacter : mainCharacters) {
                if (subMap.containsKey(mainCharacter)) {
                    mainMap.put(mainCharacter, Math.min(mainMap.get(mainCharacter), subMap.get(mainCharacter)));
                    continue;
                }
                charsToClear.add(mainCharacter);
            }

            for (Character character : charsToClear) {
                if (mainMap.containsKey(character)) {
                    mainMap.remove(character);
                }
            }
        }

        Set<Character> characters = mainMap.keySet();

        for (Character character : characters) {
            Integer count = mainMap.get(character);

            for (int i = 0; i < count; i++) {
                answer.add(String.valueOf(character));
            }
        }

        return answer;
    }

    private void initMainMap(String s, Map<Character, Integer> mainMap) {
        setCharIntegerMap(s, mainMap);
    }

    private void setCharIntegerMap(String s, Map<Character, Integer> map) {
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                map.put(aChar, map.get(aChar) + 1);
                continue;
            }
            map.put(aChar, 1);
        }
    }
}

public class FindCommonChars {
    public static void main(String[] args) {
        String[] A = {
                "bella", "label", "roller"
        };

        Solution solution = new Solution();
        for (String commonChar : solution.commonChars(A)) {
            System.out.print(commonChar + "\t");
        }
    }
}
