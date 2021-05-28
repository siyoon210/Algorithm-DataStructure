package exercise.codility.lesson5.prefixsums.passingcars;

class Solution {
    public int solution(int[] A) {
        int countCarPassingEast = 0;
        int pairsOfPassingCars = 0;

        for (int i : A) {
            if (i == 0) {
                countCarPassingEast++;
            } else {
                pairsOfPassingCars += countCarPassingEast;
            }

            if(pairsOfPassingCars > 1000000000){
                return -1;
            }
        }

        return pairsOfPassingCars;
    }
}

public class PassingCars {
    public static void main(String[] args) {
        int[] A = {0, 1, 0, 1, 1};

        Solution solution = new Solution();
        System.out.println(solution.solution(A));
    }
}
