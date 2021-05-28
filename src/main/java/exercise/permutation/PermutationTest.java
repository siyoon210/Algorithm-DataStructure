package exercise.permutation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class PermutationTest {
    public static void main(String[] args) {
        testPermutation();
        testEmptyData();
        testSizeOver();
        testSizeNegative();
        System.out.println("test success!");
    }

    private static void testPermutation() {
        //given
        List<Character> data = Arrays.asList('a', 'b', 'c');

        //when
        Set<List<Character>> permutation = Permutation.extract(data, 2);

        //then
        print(permutation);
        assertThat(permutation.size()).isEqualTo(6);
        assertThat(permutation.contains(Arrays.asList('a', 'b'))).isTrue();
        assertThat(permutation.contains(Arrays.asList('a', 'c'))).isTrue();
        assertThat(permutation.contains(Arrays.asList('b', 'a'))).isTrue();
        assertThat(permutation.contains(Arrays.asList('b', 'c'))).isTrue();
        assertThat(permutation.contains(Arrays.asList('c', 'b'))).isTrue();
        assertThat(permutation.contains(Arrays.asList('c', 'a'))).isTrue();
    }

    private static void testEmptyData() {
        //given
        List<Character> data = Collections.emptyList();

        //when
        Set<List<Character>> permutation = Permutation.extract(data, 2);

        //then
        print(permutation);
        assertThat(permutation.size()).isEqualTo(0);
    }

    private static void testSizeOver() {
        //given
        List<Character> data = Arrays.asList('a', 'b', 'c');

        //when
        Set<List<Character>> permutation = Permutation.extract(data, 100);

        //then
        print(permutation);
        assertThat(permutation.size()).isEqualTo(0);
    }

    private static void testSizeNegative() {
        //given
        List<Character> data = Arrays.asList('a', 'b', 'c');

        //when
        Set<List<Character>> permutation = Permutation.extract(data, -20);

        //then
        print(permutation);
        assertThat(permutation.size()).isEqualTo(0);
    }

    private static <T> void print(Set<List<T>> permutations) {
        System.out.println("[PRINT START]");
        for (List<T> permutation : permutations) {
            for (T element : permutation) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println("[PRINT END]\n");
    }
}