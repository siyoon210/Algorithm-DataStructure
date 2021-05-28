package exercise.codility.lesson6.maxproductofthree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    class Product implements Comparable<Product>{
        private int originValue;
        private int absValue;

        public Product(int originValue) {
            this.originValue = originValue;
            this.absValue = Math.abs(originValue);
        }

        @Override
        public int compareTo(Solution.Product o) {
            return this.absValue - o.absValue;
        }
    }

    public int solution(int[] A) {
        List<Product> products = new ArrayList<>();
        for (int i : A) {
            products.add(new Product(i));
        }

        Collections.sort(products);



        return 0;
    }
}

public class MaxProductOfThree {
    public static void main(String[] args) {
        int[] A = {-5, 5, -5, 4};

        Solution solution = new Solution();
        System.out.println(solution.solution(A));
    }
}
