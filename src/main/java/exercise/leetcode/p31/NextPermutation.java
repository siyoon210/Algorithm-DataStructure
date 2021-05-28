package exercise.leetcode.p31;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public void nextPermutation(int[] nums) {
        //1. 뒤에서부터 탐색하면서 오름차순이 꺠지는 인덱스를 찾는다. (인덱스 a) 예를들어 1 4 5 4 3 이라면, 1 4(a) 5 4 3
        int a = nums.length - 2;
        while (a != -1 && nums[a] >= nums[a + 1]) {
            a--;
        }

        //2. 다시 뒤에서부터 탐색하면서 a 보다 큰 첫번쨰 인덱스를 찾는다. (인덱스 b) 예를들어 1 4 5 4 3 이라면 1 4(a) 5(b) 4 3
        //3. a와 b를 스왑한다.
        if (a != -1) {
            int b = nums.length - 1;
            while (nums[a] >= nums[b]) {
                b--;
            }

            swap(nums, a, b);
        }

        //4. a+1 부터 끝까지 오름차순 정렬한다. 이때 이미 내림찬순 정렬이 되어 있었으므로 첫번쨰와 마지막부터 스왑하면 정렬이 된다. 예를 들어 1 5(a) 4 4 3 이라면 4와 3을 스왑하고 인덱스 하나씩 증가
        int start = a + 1;
        int end = nums.length - 1;

        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }
}

public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 2, 3};

        solution.nextPermutation(nums1);
        assertThat(nums1[0]).isEqualTo(1);
        assertThat(nums1[1]).isEqualTo(3);
        assertThat(nums1[2]).isEqualTo(2);
    }
}
