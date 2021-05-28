package exercise.leetcode.p516;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public int longestPalindromeSubseq(String s) {
        int longestCount = 0;

        for (int i = 0; i < s.length(); i++) {
            longestCount = Math.max(longestCount, getLongestCount(s, i, i));
            longestCount = Math.max(longestCount, getLongestCount(s, i, i + 1));
        }

        return longestCount;
    }

    private int getLongestCount(String s, int i, int j) {
        int longestCount = 0;
        int subCount = 0;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                longestCount = Math.max(longestCount, j - i - subCount + 1);
                i--;
                j++;
            } else {

                subCount++;
                j++;
            }
        }
        return longestCount;
    }
}

public class P516 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        assertThat(solution.longestPalindromeSubseq("bbbab")).isEqualTo(4);
        assertThat(solution.longestPalindromeSubseq("cbbd")).isEqualTo(2);
        assertThat(solution.longestPalindromeSubseq("euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew")).isEqualTo(159);

        out.println("p516" + " success!");
    }
}
