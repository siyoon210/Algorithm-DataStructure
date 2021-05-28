package codingTest.sixshop.p5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Result {
    public static long angryAnimals(int n, List<Integer> a, List<Integer> b) {
        long answer = 0;

        Map<Integer, Integer> animalNumAndEnemyNumMap = new HashMap<>();

        for (int i = 0; i < a.size(); i++) {
            if (animalNumAndEnemyNumMap.containsKey(a.get(i))) {
                animalNumAndEnemyNumMap.put(a.get(i), Math.min(b.get(i), animalNumAndEnemyNumMap.get(a.get(i))));
            } else {
                animalNumAndEnemyNumMap.put(a.get(i), b.get(i));
            }

            Integer animalNum = a.get(i);
            for (Integer num = animalNum - 1; num > 0; num--) {

                if (animalNumAndEnemyNumMap.containsKey(num)) {
                    Integer enemyNum1 = animalNumAndEnemyNumMap.get(num);
                    Integer enemyNum2 = b.get(i);

                    animalNumAndEnemyNumMap.put(num, Math.min(enemyNum1, enemyNum2));
                } else {
                    animalNumAndEnemyNumMap.put(num, b.get(i));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (animalNumAndEnemyNumMap.containsKey(i)) {
                answer += (n + 1 - i) - (n + 1 - animalNumAndEnemyNumMap.get(i));
            } else {
                answer += (n + 1 - i);
            }
        }

        return answer;
    }
}

public class Solution {
    public static void main(String[] args) {
        int n = 8;
        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(3);

        List<Integer> b = new ArrayList<>();
        b.add(8);
        b.add(5);
        b.add(6);
        b.add(4);

        System.out.println(Result.angryAnimals(n, a, b));
    }
}
