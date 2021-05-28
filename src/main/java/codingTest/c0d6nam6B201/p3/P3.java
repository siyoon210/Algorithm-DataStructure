package codingTest.c0d6nam6B201.p3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        Integer nodeSize = null;
        Integer infoSize = null;
        List<String> infos = new ArrayList<>();
        while (!(temp = br.readLine()).equals("")) {
            if (nodeSize == null) {
                final String[] s = temp.split(" ");
                nodeSize = Integer.parseInt(s[0]);
                infoSize = Integer.parseInt(s[1]);
                continue;
            }

            infos.add(temp);
        }

        solution(nodeSize, infoSize, infos);
    }

    private static int lastId;
    private static Integer result;

    static class Node {
        private final int id;
        private final Map<Node, Integer> adjacentNodesAndTimes = new HashMap<>();
        private boolean checked = false;
        private int lastCheckedTimes = 0;

        public Node(int id) {
            this.id = id;
        }

        void addAdjacentNode(Node node, Integer times) {
            adjacentNodesAndTimes.put(node, times);
        }

        void traversal(int currTimes) {
            lastCheckedTimes = currTimes;

            if (id == lastId) {
                if (result != null) {
                    result = Math.min(result, currTimes);
                    return;
                }

                result = currTimes;
                return;
            }

            for (Map.Entry<Node, Integer> nodeIntegerEntry : adjacentNodesAndTimes.entrySet()) {
                final Node adjacentNode = nodeIntegerEntry.getKey();
                final Integer adjacentLeadTimes = nodeIntegerEntry.getValue();

                if (adjacentNode.checked) {
                    if (adjacentNode.lastCheckedTimes > currTimes + adjacentLeadTimes) {
                        throw new IllegalStateException();
                    }

                    continue;
                }

                adjacentNode.checked = true;
                adjacentNode.traversal(currTimes + adjacentLeadTimes);
                adjacentNode.checked = false;
            }
        }
    }

    private static void solution(Integer nodeSize, Integer infoSize, List<String> infos) {
        lastId = nodeSize;
        result = null;
        List<Node> nodes = getNodes(nodeSize);
        setAdjacentNodes(infos, nodes);
        try {
            nodes.get(1).traversal(0);
        } catch (Exception | Error e) {
            System.out.println("bug");
            return;
        }

        if (result == null) {
            System.out.println("bug");
        } else {
            System.out.println(result);
        }
    }

    private static void setAdjacentNodes(List<String> infos, List<Node> nodes) {
        for (String info : infos) {
            final String[] s = info.split(" ");
            int from = Integer.parseInt(s[0]);
            int to = Integer.parseInt(s[1]);
            int times = Integer.parseInt(s[2]);
            nodes.get(from).addAdjacentNode(nodes.get(to), times);
        }
    }

    private static List<Node> getNodes(Integer nodeSize) {
        List<Node> nodes = new ArrayList<>(nodeSize + 1);
        nodes.add(null);

        for (int index = 0; index < nodeSize; index++) {
            int id = index + 1;
            nodes.add(id, new Node(id));
        }
        return nodes;
    }
}
