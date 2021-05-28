package codingTest.programmers.remote202010.p4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    private static class Car implements Comparable<Car>{
        private String name;
        private int vote;

        private Car(String name) {
            this.name = name;
            this.vote = 1;
        }

        private void addVote() {
            vote++;
        }

        //꼴찌부터 일등까지 오름차순
        @Override
        public int compareTo(Car o) {
            if (this.vote != o.vote) {
                return Integer.compare(this.vote, o.vote);
            }

            return o.name.compareTo(this.name);
        }
    }
    public String solution(String[] votes, int k) {
        Map<String, Car> carMap = initNameAndCarMap(votes);

        List<Car> cars = getCarsFrom(carMap);

        return getLastDropCarName(k, cars);
    }

    private String getLastDropCarName(int k, List<Car> cars) {
        String lastDropCarNAme = "";

        int topVotes = 0;
        for (int i = 0; i < k; i++) {
            topVotes += cars.get(cars.size() - 1 - i).vote;
        }

        int bottomVotes = 0;
        for (Car car : cars) {
            if (bottomVotes + car.vote < topVotes) {
                bottomVotes += car.vote;
                lastDropCarNAme = car.name;
            } else {
                break;
            }
        }
        return lastDropCarNAme;
    }

    private List<Car> getCarsFrom(Map<String, Car> carMap) {
        List<Car> cars = new ArrayList<>(carMap.values());
        Collections.sort(cars);
        return cars;
    }

    private Map<String, Car> initNameAndCarMap(String[] votes) {
        Map<String, Car> carMap = new HashMap<>();
        for (String carName : votes) {
            if (carMap.containsKey(carName)) {
                carMap.get(carName).addVote();
            } else {
                carMap.put(carName, new Car(carName));
            }
        }
        return carMap;
    }
}

public class P4 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        assertThat(solution.solution(new String[]{"AVANT", "PRIDO", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "AVANT", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "SOULFUL", "AVANT", "SANTA"}, 2)).isEqualTo("RAIN");
        assertThat(solution.solution(new String[]{"AAD", "AAA", "AAC", "AAB"}, 4)).isEqualTo("AAB");

        out.println("p4" + " success!");
    }
}
