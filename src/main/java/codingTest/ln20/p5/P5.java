package codingTest.ln20.p5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    static class Document implements Comparable<Document> {
        private final String name;
        private int score;

        public Document(String name) {
            this.name = name;
        }

        public void addScore() {
            this.score++;
        }

        @Override
        public String toString() {
            return "Document{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Document)) return false;

            Document document = (Document) o;

            return name.equals(document.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }

        @Override
        public int compareTo(Document o) {
            int scoreCompare = Integer.compare(o.score, this.score);
            return scoreCompare != 0 ? scoreCompare : this.name.compareTo(o.name);
        }
    }

    static class Tag {
        private final String name;

        public Tag(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Tag)) return false;

            Tag tag = (Tag) o;

            return name.equals(tag.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }

    public String[] solution(String[][] dataSource, String[] tags) {
        Map<Document, Set<Tag>> dataSrcMap = new HashMap<>();


        for (String[] data : dataSource) {
            dataSrcMap.put(new Document(data[0]),
                    Arrays.stream(Arrays.copyOfRange(data, 1, data.length))
                    .map(Tag::new)
                    .collect(Collectors.toSet()));
        }

        final Set<Map.Entry<Document, Set<Tag>>> datSrcEntries = dataSrcMap.entrySet();

        Arrays.stream(tags)
                .forEach(t -> datSrcEntries.stream()
                        .filter(ds -> ds.getValue().contains(new Tag(t)))
                        .forEach(ds -> ds.getKey().addScore()));

        return dataSrcMap.keySet().stream()
                .sorted()
                .filter(d -> d.score > 0)
                .map(d -> d.name)
                .toArray(String[]::new);
    }
}

public class P5 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(new String[][]{
                {"doc1", "t1", "t2", "t3"},
                {"doc2", "t0", "t2", "t3"},
                {"doc3", "t1", "t6", "t7"},
                {"doc4", "t1", "t2", "t4"},
                {"doc5", "t6", "t100", "t8"}
        }, new String[]{"t1", "t2", "t3"}))
                .isEqualTo(new String[]{"doc1", "doc2", "doc4", "doc3"});

        out.println("ln p5" + " success!");
    }
}
