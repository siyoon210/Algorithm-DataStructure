package exercise.powerset;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 멱집합(PowerSet) 원소들로 만들 수 있는 모든 부분집합.
 * 조합은(Combination)과 유사하지만, 조합은 정확한 사이즈를 원하는 경우고, 멱집합은 모든 조합의 경우다.
 * - 3C0 + 3C1 + 3C2 + 3C3 을 모두 포함한게 멱집합
 */
public class PowerSet {
    public static <T> Set<Set<T>> extract(List<T> data) {
        final Set<Set<T>> powerSet = new HashSet<>();
        setPowerSet(data, powerSet, new boolean[data.size()], 0);
        return powerSet;
    }

    private static <T> void setPowerSet(List<T> data, Set<Set<T>> powerSet, boolean[] includingFlag, int depth) {
        if (depth == data.size()) {
            Set<T> elements = new HashSet<>();
            for (int i = 0; i < includingFlag.length; i++) {
                if (includingFlag[i]) {
                    elements.add(data.get(i));
                }
            }
            powerSet.add(elements);
            return;
        }

        //포함을 시키는 경우
        includingFlag[depth] = true;
        setPowerSet(data, powerSet, includingFlag, depth + 1);

        //포함을 시키지 않는 경우
        includingFlag[depth] = false;
        setPowerSet(data, powerSet, includingFlag, depth + 1);
    }
}
