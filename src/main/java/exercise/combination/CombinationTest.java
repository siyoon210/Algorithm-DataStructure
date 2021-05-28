package exercise.combination;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class CombinationTest {
    public static void main(String[] args) {
        testCombination();
        testEmptyData();
        testSizeOver();
        testSizeNegative();
        System.out.println("test success!");
    }

    private static void testCombination() {
        //given
        List<Character> data = Arrays.asList('a', 'b', 'c');

        //when
        Set<Set<Character>> combination = Combination.extract(data, 2);

        //then
        print(combination);
        assertThat(combination.size()).isEqualTo(3);
        assertThat(combination.contains(new HashSet<>(Arrays.asList('a', 'b')))).isTrue();
        assertThat(combination.contains(new HashSet<>(Arrays.asList('a', 'c')))).isTrue();
        assertThat(combination.contains(new HashSet<>(Arrays.asList('b', 'c')))).isTrue();
    }

    private static void testEmptyData() {
        //given
        List<Character> data = Collections.emptyList();

        //when
        Set<Set<Character>> combination = Combination.extract(data, 2);

        //then
        print(combination);
        assertThat(combination.size()).isEqualTo(0);
    }

    private static void testSizeOver() {
        //given
        List<Character> data = Arrays.asList('a', 'b', 'c');

        //when
        Set<Set<Character>> combination = Combination.extract(data, 100);

        //then
        print(combination);
        assertThat(combination.size()).isEqualTo(0);
    }

    private static void testSizeNegative() {
        //given
        List<Character> data = Arrays.asList('a', 'b', 'c');

        //when
        Set<Set<Character>> combination = Combination.extract(data, -20);

        //then
        print(combination);
        assertThat(combination.size()).isEqualTo(0);
    }

    private static <T> void print(Set<Set<T>> combinations) {
        System.out.println("[PRINT START]");
        for (Set<T> combination : combinations) {
            for (T element : combination) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println("[PRINT END]\n");
    }
}
