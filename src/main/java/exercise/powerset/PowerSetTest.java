package exercise.powerset;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class PowerSetTest {
    public static void main(String[] args) {
        testPowerSet();
        testEmptyData();
        System.out.println("test success!");
    }

    private static void testPowerSet() {
        //given
        final List<Character> data = Arrays.asList('a', 'b', 'c');

        //when
        final Set<Set<Character>> powerSet = PowerSet.extract(data);

        //then
        print(powerSet);
        assertThat(powerSet.size()).isEqualTo(8);
        assertThat(powerSet.contains(Collections.emptySet())).isTrue();
        assertThat(powerSet.contains(new HashSet<>(Arrays.asList('a')))).isTrue();
        assertThat(powerSet.contains(new HashSet<>(Arrays.asList('b')))).isTrue();
        assertThat(powerSet.contains(new HashSet<>(Arrays.asList('c')))).isTrue();
        assertThat(powerSet.contains(new HashSet<>(Arrays.asList('a', 'b')))).isTrue();
        assertThat(powerSet.contains(new HashSet<>(Arrays.asList('a', 'c')))).isTrue();
        assertThat(powerSet.contains(new HashSet<>(Arrays.asList('b', 'c')))).isTrue();
        assertThat(powerSet.contains(new HashSet<>(Arrays.asList('a', 'b', 'c')))).isTrue();
    }

    private static void testEmptyData() {
        //given
        final List<Character> data = Collections.emptyList();

        //when
        final Set<Set<Character>> powerSet = PowerSet.extract(data);

        //then
        print(powerSet);
        assertThat(powerSet.size()).isEqualTo(1);
        assertThat(powerSet.contains(Collections.emptySet())).isTrue();
    }

    private static <T> void print(Set<Set<T>> powerSets) {
        System.out.println("[PRINT START]");
        for (Set<T> powerSet : powerSets) {
            for (T element : powerSet) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println("[PRINT END]\n");
    }
}
