package exercise.programmers.p12971;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public String solution(String s) {
        List<Character> characterList = new ArrayList<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            characterList.add(s.charAt(i));
        }

        characterList.sort(Collections.reverseOrder());

        return characterList.stream().map(String::valueOf).collect(Collectors.joining());
    }
}

public class CharSort {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution("Zbcdefg")).isEqualTo("gfedcbZ");
    }
}
