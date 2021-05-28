package exercise.programmers.p42883;

import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    TreeSet<Integer> nums = new TreeSet<>();

    public String solution(String number, int k) {
        String[] split = number.split("");
        permutation(split, number.length() - k);

        for (Integer num : nums) {
            System.out.println("num = " + num);
        }
        
        return String.valueOf(nums.last());
    }

    void permutation(String[] chars, int r) {
        permutation(chars, 0, r);
    }

    void permutation(String[] chars, int depth, int r) {
        if (depth == r) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < r; i++) {
                sb.append(chars[i]);
            }
            nums.add(Integer.valueOf(sb.toString()));
            
            return;
        }

        for (int i = depth; i < chars.length; i++) {
            String tmp = chars[depth];
            chars[depth] = chars[i];
            chars[i] = tmp;

            permutation(chars, depth + 1, r);

            //스왑한거 다시 되돌리기
            chars[i] = chars[depth];
            chars[depth] = tmp;
        }
    }
}

public class P42883 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution("1924", 2)).isEqualTo("94");
        assertThat(solution.solution("1231234", 3)).isEqualTo("3234");
        assertThat(solution.solution("4177252841", 4)).isEqualTo("775841");

    }
}
