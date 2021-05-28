package exercise.leetcode.p763;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    private static class Partition {
        private int startIndex;
        private int endIndex;

        private Partition(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        private Partition(CharPosition charPosition) {
            this.startIndex = charPosition.minIndex;
            this.endIndex = charPosition.maxIndex;
        }

        private boolean hasToMerged(Partition partition) {
            return partition.startIndex >= this.startIndex && partition.startIndex <= this.endIndex;
        }

        private Partition merge(Partition partition) {
            if (this.startIndex > partition.startIndex) {
                this.startIndex = partition.startIndex;
            }

            if (this.endIndex < partition.endIndex) {
                this.endIndex = partition.endIndex;
            }

            return this;
        }

        private int length() {
            return endIndex - startIndex + 1;
        }
    }

    private static class CharPosition {
        private char charValue;
        private int minIndex;
        private int maxIndex;

        private CharPosition(char charValue, int index) {
            this.charValue = charValue;
            this.minIndex = index;
            this.maxIndex = index;
        }

        private void renewMaxIndex(int maxIndex) {
            this.maxIndex = maxIndex;
        }
    }

    public List<Integer> partitionLabels(String S) {
        Map<Character, CharPosition> charPositionMap = new LinkedHashMap<>();

        for (int i = 0; i < S.length(); i++) {
            Character c = S.charAt(i);
            if (charPositionMap.containsKey(c)) {
                charPositionMap.get(c).renewMaxIndex(i);
            } else {
                charPositionMap.put(c, new CharPosition(c, i));
            }
        }

        List<Partition> partitions = charPositionMap.values().stream()
                .map(Partition::new)
                .collect(Collectors.toList());

        List<Partition> mergedPartitions = new ArrayList<>();
        mergedPartitions.add(new Partition(0, 0));

        for (Partition next : partitions) {
            Partition lastPartition = mergedPartitions.get(mergedPartitions.size() - 1);
            if (lastPartition.hasToMerged(next)) {
                lastPartition.merge(next);
            } else {
                mergedPartitions.add(next);
            }
        }

        return mergedPartitions.stream()
                .map(Partition::length)
                .collect(Collectors.toList());
    }
}

public class P763 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.partitionLabels("ababcbacadefegdehijhklij")).isEqualTo(Arrays.asList(9, 7, 8));
        
        out.println("p763" + " success!");
    }
}
