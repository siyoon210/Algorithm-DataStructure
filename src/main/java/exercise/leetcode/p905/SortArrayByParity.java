package exercise.leetcode.p905;

//        1. 맨 왼쪽과 맨 오른쪽에 포인터를 하나씩 둔다
//        2. 포인트가
//        짝 / 짝
//        짝 / 홀
//        홀 / 짝
//        홀 / 홀
//        인 4가지 경우로 나뉜다.
//
//        3-1. 짝/짝인 경우 - 왼쪽 포인터를 오른쪽으로 움직인다.
//        3-2. 짝/홀인 경우 - 오른쪽 포인터를 왼쪽으로 움직인다.
//        3-3. 홀/짝인 경우 - 둘의 자리를 바꾸고, 포인터 2개를 각각 움직인다.
//        3-4  홀/홀인 경우 - 오른쪽 포인터를 왼쪽으로 움직인다.
//
//        4. 두개의 포인터가 겹칠떄 까지 반복한다.
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int pointer1 = 0;
        int pointer2 = A.length - 1;

        while (pointer1 < pointer2) {
            if (A[pointer1] % 2 == 0 && A[pointer2] % 2 == 0) {
                pointer1++;
            } else if (A[pointer1] % 2 == 0 && A[pointer2] % 2 != 0) {
                pointer2--;
            } else if (A[pointer1] % 2 != 0 && A[pointer2] % 2 == 0) {
                int tmp = A[pointer1];
                A[pointer1] = A[pointer2];
                A[pointer2] = tmp;

                pointer1++;
                pointer2--;
            } else {
                pointer2--;
            }
        }

        return A;
    }
}

public class SortArrayByParity {
    public static void main(String[] args) {
        int[] A = {3,1,2,4};

        Solution solution = new Solution();
        for (int i : solution.sortArrayByParity(A)) {
            System.out.print(i + "\t");
        }
    }
}
