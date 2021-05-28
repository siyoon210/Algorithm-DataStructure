package exercise.kakaoblind2017.secretmap;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int longestStrLength = 0;

        for (int i = 0; i < n; i++) {
            final String s = Integer.toBinaryString(arr1[i] | arr2[i]);
            answer[i] = s;
            longestStrLength = Math.max(longestStrLength, s.length());
        }

        for (int i = 0; i < answer.length; i++) {
            final String format = String.format("%0" + longestStrLength + "d", Integer.parseInt(answer[i]));
            answer[i] = format.replaceAll("1", "#").replaceAll("0", " ");
        }

        return answer;
    }
}

public class SecretMap {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        Solution solution = new Solution();
        for (final String s : solution.solution(n, arr1, arr2)) {
            System.out.println(s);
        }
    }
}
