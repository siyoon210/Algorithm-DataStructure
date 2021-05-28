package exercise.programmers.budget;

import java.util.Arrays;

class Solution {
    public int solution(int[] budgets, int M) {
        //배열의 요소들을 오름차순으로 정렬시킨다.
        Arrays.sort(budgets);

        //배열 요소들의 총합과 총 예산의 차를 구한다.
        int budgetSum = Arrays.stream(budgets).sum();

        //만약 주어진 예산이 넉넉하다면 가장 예산이 큰 도시의 예산을 리턴한다.
        if (M >= budgetSum) {
            return Arrays.stream(budgets).max().orElse(0);
        }
        //그렇지 않다면 상위 도시부터 하나씩 몇개의 도시를 줄여야 하는지 계산한다.
        else {
            int gapOfBudget = budgetSum - M;
            int cityCountToDecreaseBudget = 1;
            int savedBudget = 0;
            int answer = 0;

            for (int i = 1; i < budgets.length; i++) {
                savedBudget += (budgets[budgets.length - i] - budgets[budgets.length - (i + 1)]) * cityCountToDecreaseBudget;
                if (gapOfBudget <= savedBudget) {
                    //예산 확보됨
                    savedBudget -= (budgets[budgets.length - i] - budgets[budgets.length - (i + 1)]) * cityCountToDecreaseBudget;

                    answer = (int) (budgets[budgets.length - i] -  ((gapOfBudget - savedBudget) / (double)cityCountToDecreaseBudget));
                    break;
                }
                cityCountToDecreaseBudget++;
            }

            if (answer == 0) {
                answer = M / budgets.length;
            }
            //도시들의 상한을 구한다.
            return answer;
        }
    }
}

public class Budget {
    public static void main(String[] args) {
        int[] budgets = {9, 8, 5, 6, 7};
        int M = 10;

        Solution solution = new Solution();
        System.out.println(solution.solution(budgets, M));
    }
}
