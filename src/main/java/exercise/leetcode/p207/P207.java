package exercise.leetcode.p207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

// 큐에 진입차수(InDegree)가 0인 노드를 넣는다.
// 큐에서 노드를 꺼낸후 꺼낸 노드와 연결되어 있는 간선을 모두 끊고 다시 진입차수가 0이 되었다면 큐에 넣는다.
// 큐가 비어질떄까지 반복하며, 큐에 들어온 순서가 위상정렬의 수행결과다
class Solution {
    private static class Node {
        private final Queue<Node> zeroInDegreeNodeQueue;
        private int inDegree;
        private final List<Node> adjacentNodes;

        public Node(Queue<Node> zeroInDegreeNodeQueue) {
            this.zeroInDegreeNodeQueue = zeroInDegreeNodeQueue;
            adjacentNodes = new ArrayList<>();
        }

        private boolean isZeroInDegree() {
            return inDegree == 0;
        }

        private void addAdjacentNode(Node node) {
            adjacentNodes.add(node);
        }

        private void disconnectAdjacentNodes() {
            for (Node adjacentNode : adjacentNodes) {
                adjacentNode.inDegree--;
                if (adjacentNode.isZeroInDegree()) {
                    zeroInDegreeNodeQueue.add(adjacentNode);
                }
            }
        }

        private void addInDegree() {
            inDegree++;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Node> zeroInDegreeNodeQueue = new LinkedList<>();
        List<Node> nodes = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            nodes.add(new Node(zeroInDegreeNodeQueue));
        }

        for (int[] prerequisite : prerequisites) {
            Node course = nodes.get(prerequisite[0]);
            Node preCourse = nodes.get(prerequisite[1]);

            preCourse.addAdjacentNode(course);
            course.addInDegree();
        }

        for (Node node : nodes) {
            if (node.isZeroInDegree()) {
                zeroInDegreeNodeQueue.add(node);
            }
        }

        while (!zeroInDegreeNodeQueue.isEmpty()) {
            Node node = zeroInDegreeNodeQueue.poll();
            node.disconnectAdjacentNodes();
            numCourses--;
        }

        return numCourses <= 0;
    }
}

public class P207 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assertThat(solution.canFinish(2, new int[][]{{1, 0}})).isEqualTo(true);
        assertThat(solution.canFinish(2, new int[][]{{1, 0}, {0, 1}})).isEqualTo(false);

        out.println("p207" + " success!");
    }
}
