package exercise.baekjoon.dfsbfs.p1260;

import java.util.ArrayList;

class Node{
    private int data;
    private ArrayList<Node> adjacent;
    private Boolean marked;

    public Node(int data) {
        this.data = data;
        marked = false;
        adjacent = new ArrayList<>();
    }

    public Node(int data, int adjacentData) {
        this(data);
        this.adjacent.add(new Node(adjacentData));
    }

    public void addAdjacent(int data) {
        adjacent.add(new Node(data, this.data));
    }
}

public class Main {

}
