package codingTest.sixshop.p3;

import java.util.ArrayList;
import java.util.List;

class Result{
    public static int minPower(List<Integer> p) {
        int minValue = 0;
        int pathResult = 0;

        for (int i = 1; i < p.size(); i++) {
            pathResult += p.get(i);
            minValue = Math.min(minValue, pathResult);
        }

        int answer = 1 - minValue;
        return answer < 1 ? 1 : answer;
    }
}

public class TheDuel {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();

        integers.add(10);
        integers.add(-5);
        integers.add(4);
        integers.add(-2);
        integers.add(3);
        integers.add(1);
        integers.add(-1);
        integers.add(-6);
        integers.add(-1);
        integers.add(0);
        integers.add(5);

        System.out.println(Result.minPower(integers));
    }
}
