package exercise.programmers.buyland;

class Solution {
    public boolean solution(int[][] lands, int[][] wells, int[] point) {
        //point가 land중에 중복되는 좌표가 있는지 확인한다.
        //중복된다면 false
        for (int[] land : lands) {
            boolean overLap = isOverLap(land, point);
            if (overLap) {
                return false;
            }
        }

        //point가 well중에 중복되는 좌표가 있는지 확인한다.
        //중복이 하나도 안된다면 true
        for (int[] well : wells) {
            boolean overLap = isOverLap(point, well);
            if (overLap) {
                return true;
            }
        }

        return false;
    }

    //compare영역이 target영역과 겹치는지 아닌지 확인
    private boolean isOverLap(int[] target, int[] compare) {
        if (isOverLap(target[0], target[2], compare[0]) || isOverLap(target[0], target[2], compare[2])) {
            return isOverLap(target[1], target[3], compare[1]) || isOverLap(target[1], target[3], compare[3]);
        } else {
            return false;
        }
    }

    private boolean isOverLap(int from, int to, int point) {
        return from < point && to > point;
    }
}

public class BuyLand {
    public static void main(String[] args) {
//        int[][] lands = {{10, 0, 30, 5}, {0, 30, 20, 50}, {30, 30, 40, 40}};
//        int[][] wells = {{15, 15, 25, 25}, {40, 10, 50, 20}};
//        int[] point = {10, 10, 30, 30};

        int[][] lands = {{0, 0, 20, 10}, {10, 20, 20, 40}, {30, 0, 50, 20}};
        int[][] wells = {{20, 40, 30, 50}, {30, 20, 50, 30}};
        int[] point = {20, 30, 30, 40};

        Solution solution = new Solution();
        System.out.println(solution.solution(lands, wells, point));
    }
}
