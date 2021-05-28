package codingTest.kaka0.kakao20blind.p2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    static class MenuCombination {
        private final TreeSet<Character> menus = new TreeSet<>();

        public void addMenu(Character menu) {
            menus.add(menu);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MenuCombination)) return false;

            MenuCombination that = (MenuCombination) o;

            return menus.equals(that.menus);
        }

        @Override
        public int hashCode() {
            return menus.hashCode();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Character menu : menus) {
                sb.append(menu);
            }
            return sb.toString();
        }
    }

    static class Course implements Comparable<Course>{
        private final MenuCombination menuCombination;
        private int orderedCount;

        public Course(MenuCombination menuCombination) {
            this.menuCombination = menuCombination;
            this.orderedCount = 1;
        }

        private void increaseOrderedCount() {
            orderedCount++;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Course)) return false;

            Course course = (Course) o;

            return menuCombination.equals(course.menuCombination);
        }

        @Override
        public int hashCode() {
            return menuCombination.hashCode();
        }

        @Override
        public int compareTo(Course o) {
            return Integer.compare(o.orderedCount, this.orderedCount);
        }

        @Override
        public String toString() {
            return "Course{" +
                    "menuCombination=" + menuCombination +
                    ", orderedCount=" + orderedCount +
                    '}';
        }
    }

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for (int courseSize : course) {
            Map<MenuCombination, Course> combinations = new HashMap<>();
            for (String order : orders) {
                combination(order.toCharArray(), new boolean[order.toCharArray().length], 0, order.toCharArray().length, courseSize, combinations);
            }

            final List<Course> collect = new ArrayList<>(combinations.values());
            Collections.sort(collect);

            addCourses(answer, collect);
        }

        Collections.sort(answer); //메뉴의 사전순 정리

        return convertStringArray(answer);
    }

    private String[] convertStringArray(List<String> answer) {
        String[] answerStrArr = new String[answer.size()];

        for (int i = 0; i < answerStrArr.length; i++) {
            answerStrArr[i] = answer.get(i);
        }
        return answerStrArr;
    }

    private void addCourses(List<String> answer, List<Course> collect) {
        if (collect.isEmpty() || collect.get(0).orderedCount < 2) {
            return;
        }

        final int maxOrderedCount = collect.get(0).orderedCount;

        for (Course course : collect) {
            if (course.orderedCount == maxOrderedCount) {
                answer.add(course.menuCombination.toString());
                continue;
            }
            break;
        }
    }

    private void combination(char[] arr, boolean[] visited, int start, int n, int r, Map<MenuCombination, Course> combinations) {
        if (r == 0) {
            MenuCombination menuCombination = new MenuCombination();
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    menuCombination.addMenu(arr[i]);
                }
            }

            if (combinations.containsKey(menuCombination)) {
                combinations.get(menuCombination).increaseOrderedCount();
            } else {
                combinations.put(menuCombination, new Course(menuCombination));
            }
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1, combinations);
            visited[i] = false;
        }
    }
}

public class P2 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4}))
                .isEqualTo(new String[]{"AC", "ACDE", "BCFG", "CDE"});

        assertThat(solution.solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5}))
                .isEqualTo(new String[]{"ACD", "AD", "ADE", "CD", "XYZ"});

        assertThat(solution.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4}))
                .isEqualTo(new String[]{"WX", "XY"});

        out.println("p2" + " success!");
    }
}
