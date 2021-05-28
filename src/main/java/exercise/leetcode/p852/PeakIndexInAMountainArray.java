package exercise.leetcode.p852;

class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int leftIndex = 0;
        int rightIndex = A.length - 1;

        while (leftIndex < rightIndex) {
            int mi = ((rightIndex - leftIndex) / 2) + leftIndex;
            if (A[mi] < A[mi + 1]) {
                leftIndex = mi + 1;
            } else {
                rightIndex = mi;
            }
        }

        return leftIndex;
    }
}

public class PeakIndexInAMountainArray {
    public static void main(String[] args) {
//        int[] inputArr = {19, 24, 25, 29, 34, 39, 50, 51, 56, 61, 67, 82, 87, 88, 97, 73, 72, 23};
//        int[] inputArr = {8, 18, 24, 31, 37, 42, 43, 56, 65, 73, 93, 98, 100, 98, 76, 72, 69, 24, 23};
        int[] inputArr = {1, 3, 29, 30, 34, 35, 42, 60, 64, 73, 91, 94, 91, 85, 80, 75, 71, 63, 54, 53, 42, 27, 24, 21, 14, 11, 10, 9};
//        int[] inputArr = {13, 25, 38, 55, 58, 75, 85, 88, 100, 94, 88, 82, 60, 58, 48, 43, 40, 35, 17, 2};
//        int[] inputArr = {24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
//        int[] inputArr = {12, 13, 19, 41, 55, 69, 70, 71, 96, 72};
//        int[] inputArr = {40, 48, 61, 75, 100, 99, 98, 39, 30, 10};


        Solution solution = new Solution();
        System.out.println(solution.peakIndexInMountainArray(inputArr));
    }
}
