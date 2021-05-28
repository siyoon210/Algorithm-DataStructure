package exercise.dfsbfs;


import java.util.LinkedList;

class Node {
    int data;
    LinkedList<Node> adjacent;
    boolean visited;

    public Node(int data) {
        this.data = data;
        adjacent = new LinkedList<>();
        visited = false;
    }
}

class Graph {
    Node[] nodes;

    public Graph(int size) {
        nodes = new Node[size];
    }

    void setNode() {
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];

        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
    }

    void dfs(Node node) {
        visit(node);
        //방문한 노드의 인접한 노드들도 재귀적으로 방문
        for (Node n : node.adjacent) {
            if(!n.visited) dfs(n);
        }
    }

    void dfs(int index) {
        dfs(nodes[index]);
    }

    void visit(Node node) {
        node.visited = true;
        System.out.print(node.data+"\t");
    }
}

public class DFSBFS {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.setNode();
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 0);
        graph.addEdge(1, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(3, 2);
        graph.addEdge(4, 3);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.dfs(4);
    }
}
