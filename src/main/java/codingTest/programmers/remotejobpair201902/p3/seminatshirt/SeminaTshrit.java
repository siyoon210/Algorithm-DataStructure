package codingTest.programmers.remotejobpair201902.p3.seminatshirt;

import java.util.Arrays;

class Solution {
    public int solution(int[] people, int[] tshirts) {
        int answer = 0;
        int n = 0;

        Arrays.sort(people);
        Arrays.sort(tshirts);

        for (int i = 0; i < people.length; i++) {
            for (int j = n; j < tshirts.length; j++) {
                if (people[i] <= tshirts[j]) {
                    answer++;
                    n = j + 1;
                    break;
                }
            }
        }

        return answer;

//        int answer = 0;
//        Arrays.sort(people);
//        LinkedList<Integer> tShirtsList = new LinkedList<>();
//        for (int tshirt : tshirts) {
//            tShirtsList.add(tshirt);
//        }
//
//        Collections.sort(tShirtsList);
//
//        for (int i = 0; i < people.length; i++) {
//            for (Integer tShirts : tShirtsList) {
//                if (people[i] <= tShirts) {
//                    answer++;
//                    tShirtsList.pop();
//                    break;
//                }
//            }
//        }
//        return answer;
    }
}

public class SeminaTshrit {
    public static void main(String[] args) {
        int[] people = {3, 2};
        int[] tshirts = {1, 3, 2};

        Solution solution = new Solution();
        System.out.println(solution.solution(people, tshirts));
    }
}
