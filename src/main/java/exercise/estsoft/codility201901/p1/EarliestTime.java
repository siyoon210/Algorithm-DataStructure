package exercise.estsoft.codility201901.p1;

import java.util.Collections;
import java.util.LinkedList;

//00:00:00 ~ 24:59:59
//인덱스가 3, 5인 경우는 모든 숫자가 올 수 있다.
//인덱스가 2, 4인 경우는 0~5 숫자만 올 수 있다.
//인덱스가 1인 경우는 0~4 숫자만 올 수 있다.
//인덱스가 0인 경우는 0~2 숫자만 올 수 있다.
//그리고 마지막으로 시간은 24보다 작거나 같아야 하며,
//분과 초는 59보다 작거나 같아야 한다.
class MakingEarliestTime {
    private String hour;
    private String minute;
    private String second;
    private LinkedList<Integer> integers;

    MakingEarliestTime(LinkedList<Integer> integers) {
        this.integers = integers;
    }

    boolean findEarliestValidTime() {
        sortIntegers();

        if (!setMinuteAndSecond("second")) {
            return false;
        }
        if (!setMinuteAndSecond("minute")) {
            return false;
        }
        return setHour();
    }

    private void sortIntegers() {
        Collections.sort(this.integers);
    }

    private boolean setMinuteAndSecond(String type) {
        int[] tmp = new int[2];
        //일의 자리 경우는 모든 숫자가 올 수 있다.
        tmp[1] = integers.getLast();
        integers.removeLast();

        //십의 자리 경우는 0~5 숫자만 올 수 있다.
        for (int i = integers.size() - 1; i >= 0; i--) {
            if (integers.get(i) <= 5) {
                tmp[0] = integers.get(i);
                integers.remove(i);

                if (type.equals("minute")) {
                    this.minute = tmp[0] + "" + tmp[1];
                } else if (type.equals("second")) {
                    this.second = tmp[0] + "" + tmp[1];
                }
                return true;
            }
        }

        return false;
    }

    private boolean setHour() {
        int[] tmp = new int[2];
        tmp[1] = integers.get(1);
        tmp[0] = integers.get(0);
        this.hour = tmp[0] + "" + tmp[1];

        return Integer.parseInt(this.hour) <= 24;
    }

    String getEarliestTime() {
        return this.hour + ":" + this.minute + ":" + this.second;
    }
}

class Solution {
    public String solution(int A, int B, int C, int D, int E, int F) {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(A);
        integers.add(B);
        integers.add(C);
        integers.add(D);
        integers.add(E);
        integers.add(F);

        MakingEarliestTime makingEarliestTime = new MakingEarliestTime(integers);
        if (makingEarliestTime.findEarliestValidTime()) {
            return makingEarliestTime.getEarliestTime();
        } else {
            return "NOT POSSIBLE";
        }
    }
}

public class EarliestTime {
    public static void main(String[] args) {
        int A = 0;
        int B = 9;
        int C = 1;
        int D = 7;
        int E = 4;
        int F = 4;

        Solution solution = new Solution();
        System.out.println(solution.solution(A, B, C, D, E, F));
    }
}
