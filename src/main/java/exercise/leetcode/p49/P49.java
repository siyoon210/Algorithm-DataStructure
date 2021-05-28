package exercise.leetcode.p49;

import java.util.*;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> charListMap = new HashMap<>();
        for (String str : strs) {
            final char[] toChar = str.toCharArray();

            Arrays.sort(toChar);

            final String key = Arrays.toString(toChar);
            if (charListMap.containsKey(key)) {
                charListMap.get(key).add(str);
            } else {
                final ArrayList<String> strings = new ArrayList<>();
                strings.add(str);
                charListMap.put(key, strings);
            }
        }

        return new ArrayList<>(charListMap.values());
    }
}

public class P49 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).size()).isEqualTo(3);

        out.println("P49" + " success!");
    }
}
