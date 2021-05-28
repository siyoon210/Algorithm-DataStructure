package exercise.codility.lesson7.stonewall;

import java.util.Stack;

class Solution {
    public int solution(int[] H) {
        Stack<Integer> stack = new Stack();
        int blockCnt = 0;
        for(int i =0 ; i < H.length; i++){

            while(stack.size() > 0 && stack.peek() > H[i]){
                stack.pop();
            }


            if(stack.size() == 0 || stack.peek() < H[i]){
                stack.push(H[i]);
                blockCnt++;
            }

        }
        return blockCnt;
    }
}

public class StoneWall {
    public static void main(String[] args) {
        int[] H = {
                8, 8, 5, 7, 9, 8, 7, 4, 8
        };

        Solution solution = new Solution();
        System.out.println(solution.solution(H));
    }
}
