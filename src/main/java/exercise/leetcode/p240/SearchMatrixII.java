package exercise.leetcode.p240;

import java.util.Arrays;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = 0;
        if (m > 0) {
            n = matrix[0].length;
        }
        int[] mergedArr = new int[m * n];

        //합치고 정렬, 병합정렬로 하면 속도 더 빠르게 될듯
        mergeArr(mergedArr, matrix);
        Arrays.sort(mergedArr);

        int pointer = mergedArr.length / 2;
        int i = Arrays.binarySearch(mergedArr, target);
        return i < 0 ? false : true;
    }

    void mergeArr(int[] arr, int[][] matrix) {
        int index = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                arr[index] = anInt;
                index++;
            }
        }
    }

}

public class SearchMatrixII {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
//        };

        int[][] matrix = {};

        int target = 5;

        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(matrix, target));
    }
}
