package exercise.leetcode.p973;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//973.
class Coordinate implements Comparable<Coordinate> {
    int[] point;
    int distanceToOrigin;

    public Coordinate(int[] point) {
        this.point = point;
        calcDistance();
    }

    private void calcDistance() {
        distanceToOrigin = (int) (Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }

    public int[] getPoint() {
        return point;
    }

    @Override
    public int compareTo(Coordinate o) {
        return this.distanceToOrigin - o.distanceToOrigin;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        List<Coordinate> coordinateList = new ArrayList<>();

        for (int[] point : points) {
            coordinateList.add(new Coordinate(point));
        }

        Collections.sort(coordinateList);

        int[][] answer = new int[k][2];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = coordinateList.get(i).getPoint();
        }

        return answer;
    }
}

public class KClosestPoints {
    public static void main(String[] args) {
//        int[][] points = {{1, 3}, {-2, 2}};
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;


        Solution solution = new Solution();
        for (int[] ints : solution.kClosest(points, k)) {
            System.out.println(ints[0] + ", " + ints[1]);
        }
    }
}
