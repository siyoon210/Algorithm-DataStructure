package exercise.kakaoblind2018.candidatekey;

import java.util.*;

//1. 최소성을 위해서 1개의 열을 기준으로 유일성을 나타낼 수 있는지 확인해본다.
//2. 1개로 유일성을 나타낼 수 있다면 그 열은 제외한다.
//3. 남은 열을 이용해서 2개, 3개, ... 로 유일성을 나타낼 수 있는지 확인해본다.
//
//+ 일단 해쉬코드가 중복이 되지 않는다라고 가정해보자.
//
//작은것부터 하나씩 구현해보자.
//1. 한열을 기준으로 유일키가 될 수 있는지 없는지 확인하는 기능
//2. 2열, 3열 ... 기준으로 유일키가 될 수 있는지 없는지 확인하는 기능 (일단 중복과 최소성은 제외)
//2-1. 2개, 3개 .. 씩 인덱스를 선택하는 기능
//  2-1-1. 사용한 인덱스인지 아닌지 확인하고 선택하는 기능
//2-2. 여러 인덱스 조합을 이용해서 해당 조합이 다른 튜플과 유니크 한지 아닌지 확인하는 기능
class Solution {
    private String[][] relation;
    private boolean[] usedIndex;
    private int candidateCaseCount;

    public int solution(String[][] relation) {
        this.relation = relation;
        this.usedIndex = new boolean[relation[0].length];
        this.candidateCaseCount = 0;

        for (int i = 1; i <= relation[0].length; i++) {
            List<Set<Integer>> indicesList = getIndicesList(i);
            isUniqueRecords(indicesList);
        }

        return candidateCaseCount;
    }

    //주어진 배열을 기준으로 count 갯수 만큼의 인덱스의 경우의 수를 리턴하는 함수
    private List<Set<Integer>> getIndicesList(int wantedSize) {
        List<Set<Integer>> indicesList = new ArrayList<>();
        return findAvailableIndices(indicesList, new LinkedHashSet<>(), wantedSize, 0);
    }

    private List<Set<Integer>> findAvailableIndices(List<Set<Integer>> indicesList, Set<Integer> indices, int wantedSize, int currentIndex) {
        if (indices.size() >= wantedSize) {
            indicesList.add(cloneSet(indices));
            return indicesList;
        }

        if (currentIndex >= relation[0].length) {
            return indicesList;
        }

        currentIndex = checkUsedIndex(currentIndex);

        //포함 되는 경우
        indices.add(currentIndex);
        findAvailableIndices(indicesList, indices, wantedSize, currentIndex + 1);
        indices.remove(currentIndex);

        //포함 안되는 경우
        findAvailableIndices(indicesList, indices, wantedSize, currentIndex + 1);

        return indicesList;
    }

    private int checkUsedIndex(int currentIndex) {
        while (currentIndex < relation[0].length && usedIndex[currentIndex]) {
            currentIndex++;
        }

        return currentIndex;
    }

    private Set<Integer> cloneSet(Set<Integer> set) {
        Set<Integer> clone = new LinkedHashSet<>(set.size());
        clone.addAll(set);
        return clone;
    }

    //여러 열을 기준으로 유일키가 될 수 있는지 없는지 확인하는 기능
    private void isUniqueRecords(final List<Set<Integer>> indicesList) {
        for (final Set<Integer> indices : indicesList) {
            if (canBeCandidateKey(indices)) {
                //유일키가 될 수 있다면
                //1. 해당 인덱스 들은 이제 조합에서 사용하지 않는다. (최소성)
                for (final Integer index : indices) {
                    usedIndex[index] = true;
                }
                //2. 갯수를 한개 더 카운트 한다.
                    //2-1. 현재는 1+2 조합이나 1+3 조합이 둘다 가능 하다면 1을 두번 사용해서 2번 카운트한다.
                candidateCaseCount++;
            }
        }
    }

    private boolean canBeCandidateKey(Set<Integer> indices) {
        Set<String> hashCodeSet = new HashSet<>();
        for (final String[] record : relation) {
            StringBuilder str = new StringBuilder();
            for (final Integer index : indices) {
                str.append(index);
                str.append(record[index]);
            }
            if (!hashCodeSet.add(str.toString())) {
                return false;
            }
        }

        return true;
    }
}

public class CandidateKey {
    public static void main(String[] args) {
        String[][] relation = {
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}};

        Solution solution = new Solution();
        System.out.println("solution.solution(relation) = " + solution.solution(relation));
    }
}
