package exercise.estsoft.codility201902.p2;

import java.util.ArrayList;
import java.util.List;

// 1. Bead 클래스를 만든다.
class Bead {
    //2. Bead 는 배열 인덱스로 부터 받은 값인 인덱스가 있고, 다음 Bead 가 무엇인지,
    //그리고 나중에 모든 비드를 셀때 이미 센 비드인지 아닌지를 확인하는 필드 3가지가 있다.
    //사실 지금 보면 인덱스는 딱히 하는 일이 없다. 없어도 된다.
    private int index;
    private Bead nextBead;
    private boolean isChecked;

    Bead(int index) {
        this.index = index;
        this.isChecked = false;
    }

    int getIndex() {
        return index;
    }

    Bead getNextBead() {
        return nextBead;
    }

    //3. 다음 Bead에 대한 정보를 받아서 설정하는 메소드다.
    void setNextBead(Bead nextBead) {
        this.nextBead = nextBead;
    }

    boolean isChecked() {
        return isChecked;
    }

    //4. 이 메소드가 실행되면 해당 비드객체는 체크한 것으로 간주되어서 더 이상 셈하지 않는다.
    void setCheck() {
        this.isChecked = true;
    }
}

class Solution {
    public int solution(int[] A) {
        //5. beads 리스트를 만들어서 입력값 배열을 beads 리스트로 바꾼다.
        List<Bead> beads = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            beads.add(new Bead(i));
        }

        //6. 배열의 값은 다음 비드의 값을 나타낸다. 다음 비드를 설정한다.
        for (int i = 0; i < beads.size(); i++) {
            beads.get(i).setNextBead(beads.get(A[i]));
        }

        //7. 비드가 가장 많은 경우를 셈해서 리턴한다.
        return calcMaxNumberOfBeads(beads);
    }

    private int calcMaxNumberOfBeads(List<Bead> beads) {
        int maxBeadCount = 0;
        //8. 가장 많이 셈하는 방법은 beads 리스트를 그래프탐색처럼 실행한다.
        for (Bead bead : beads) {
            maxBeadCount = Math.max(maxBeadCount, countNumberOfBeads(bead, 0));
        }
        return maxBeadCount;
    }

    private int countNumberOfBeads(Bead bead, int count) {
        //9. 이미 체크한 비드에 들어온 경우는 카운트 숫자를 리턴하고 재귀를 끝낸다.
        if (bead.isChecked()) {
            return count;
        }

        //10. 이 메소드에 들어온 경우는 체크한 것으로 한다.
        bead.setCheck();

        //11. 재귀적으로 시행한다. 다음 비드를 인자로 넣어준다.
        return countNumberOfBeads(bead.getNextBead(), count + 1);
    }
}

public class NumberOfBeads {
    public static void main(String[] args) {
//        int[] A = new int[7];
//        A[0] = 5;
//        A[1] = 4;
//        A[2] = 0;
//        A[3] = 3;
//        A[4] = 1;
//        A[5] = 6;
//        A[6] = 2;

        int[] A = {};
        Solution solution = new Solution();
        System.out.println(solution.solution(A));
    }

}
