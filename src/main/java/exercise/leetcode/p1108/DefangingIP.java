package exercise.leetcode.p1108;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}

public class DefangingIP {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.defangIPaddr("1.1.1.1")).isEqualTo("1[.]1[.]1[.]1");
        assertThat(solution.defangIPaddr("255.100.50.0")).isEqualTo("255[.]100[.]50[.]0");
    }
}
