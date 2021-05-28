package exercise.combination;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 조합 (Combination) 순서를 따지지 않는다.
 * - 3개중에 2개를 뽑는 경우 3C2로 표시하고, 경우의수 갯수는 3x2/2!로 계산한다.
 * - nCr = n x r / r!
 * <p>
 * 멱집합(PowerSet)과 유사하지만, 조합은 정확한 사이즈를 원하는 경우고, 멱집합은 모든 조합의 경우다.
 * - 3C0 + 3C1 + 3C2 + 3C3 을 모두 포함한게 멱집합
 */
public class Combination {
    public static <T> Set<Set<T>> extract(List<T> data, int size) {
        final Set<Set<T>> combination = new HashSet<>();

        if (size > 0 && size <= data.size()) {
            setCombination(data, combination, new boolean[data.size()], size, 0, 0);
        }

        return combination;
    }

    private static <T> void setCombination(List<T> data, Set<Set<T>> combination, boolean[] includingFlag, int size, int currSize, int depth) {
        if (currSize == size) {
            Set<T> element = new HashSet<>(size);
            for (int i = 0; i < includingFlag.length; i++) {
                if (includingFlag[i]) {
                    element.add(data.get(i));
                }

                if (element.size() == size) {
                    break;
                }
            }
            combination.add(element);
            return;
        }

        if ((data.size() - depth) < (size - currSize)) {
            return;
        }

        //포함을 시키는 경우
        includingFlag[depth] = true;
        setCombination(data, combination, includingFlag, size, currSize + 1, depth + 1);

        //포함을 시키지 않는 경우
        includingFlag[depth] = false;
        setCombination(data, combination, includingFlag, size, currSize, depth + 1);
    }
}
