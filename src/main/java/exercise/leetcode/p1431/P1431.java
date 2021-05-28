package exercise.leetcode.p1431;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int greatestNumber = Arrays.stream(candies)
            .max()
            .orElse(-1);
        List<Boolean> result = new ArrayList<>(candies.length);
        
        for(int i=0; i < candies.length; i++) {
            if(candies[i] + extraCandies >= greatestNumber) {
                result.add(true);
                continue;
            }
            
            result.add(false);
        }
        
        return result;
    }
}

public class P1431 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        assertThat(solution.kidsWithCandies(new int[]{2,3,5,1,3}, 3)).isEqualTo(asList(true,true,true,false,true));
        
        out.println("p1431" + " success!");
    }
}
