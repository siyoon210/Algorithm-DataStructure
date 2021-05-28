package exercise.permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 순열 (Permutation) 순서를 따진다.
 * - 3개중에 2개를 뽑는 경우 3P2로 표시하고, 경우의수 갯수는 3x2로 계산한다.
 */
public class Permutation {
    public static <T> Set<List<T>> extract(List<T> data, int size) {
        final Set<List<T>> permutation = new HashSet<>();

        if (size >= 0 && size <= data.size()) {
            setPermutation(data, permutation, size, 0);
        }

        return permutation;
    }

    private static <T> void setPermutation(List<T> data, Set<List<T>> permutation, int size, int depth) {
        if (depth == size) {
            permutation.add(new ArrayList<>(data.subList(0, size)));
            return;
        }

        for (int i = depth; i < data.size(); i++) {
            swap(data, depth, i);

            setPermutation(data, permutation, size, depth + 1);

            swap(data, i, depth); //다시 되돌려 주기
        }
    }

    private static <T> void swap(List<T> data, int i, int j) {
        T temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }
}