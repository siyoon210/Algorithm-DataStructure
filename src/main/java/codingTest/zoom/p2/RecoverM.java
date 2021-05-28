package codingTest.zoom.p2;

class Solution {
    int[] row0;
    int[] row1;
    int U;
    int L;
    String row0Str;
    String row1Str;

    public String solution(int U, int L, int[] C) {
        this.row0 = new int[C.length];
        this.row1 = new int[C.length];
        recoverM(C, 0, new StringBuffer(), new StringBuffer());

        this.U = U;
        this.L = L;

        return this.row0Str.length() < 0 ? "IMPOSSIBLE" : row0Str + "," + row1Str;
    }

    void recoverM(int[] C, int index, StringBuffer stringBuffer0, StringBuffer stringBuffer1) {
        if (index == C.length) {
            int sumOfRow0 = 0;
            int sumOfRow1 = 0;
            char[] chars0 = stringBuffer0.toString().toCharArray();
            char[] chars1 = stringBuffer1.toString().toCharArray();

            for (char c : chars0) {
                sumOfRow0 += (c - '0');
            }
            for (char c : chars1) {
                sumOfRow1 += (c - '0');
            }

            if (sumOfRow0 == this.U && sumOfRow1 == this.L) {
                this.row0Str = stringBuffer0.toString();
                this.row1Str = stringBuffer1.toString();
            }
            return;
        }

        if (C[index] == 2) {
            stringBuffer0.append(1);
            stringBuffer1.append(1);
            recoverM(C, index + 1, stringBuffer0, stringBuffer1);
        } else if (C[index] == 0) {
            stringBuffer0.append(0);
            stringBuffer1.append(0);
            recoverM(C, index + 1, stringBuffer0, stringBuffer1);
        } else {
            recoverM(C, index + 1, stringBuffer0.append(1), stringBuffer1.append(0));
            recoverM(C, index + 1, stringBuffer0.append(0), stringBuffer1.append(1));
        }
    }


}

public class RecoverM {
    public static void main(String[] args) {
        int U = 3;
        int L = 2;
        int[] C = {2, 1, 1, 0, 1};

        Solution solution = new Solution();
        System.out.println(solution.solution(U, L, C));
    }
}
