package exercise.heap;

import java.util.ArrayList;
import java.util.List;

class Node {
    private int value;
    private Node leftChild;
    private Node rightChild;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    //최대 힙 기준으로 만들어짐
    void makeHeap() {
        Node bigChild;
        if (rightChild != null) {
            bigChild = (leftChild.getValue() > rightChild.getValue()) ? leftChild : rightChild;
        }else {
            bigChild = leftChild;
        }

        if (bigChild.getValue() > this.value) {
            int tmp = this.value;
            this.value = bigChild.getValue();
            bigChild.setValue(tmp);
        }
    }
}

class HeapTree {
    List<Node> nodes;

    public HeapTree() {
        nodes = new ArrayList<>();
    }

    void addNode(Node node) {
        nodes.add(node);
    }

    void printNodes() {
        for (Node node : nodes) {
            System.out.print(node.getValue() + "\t");
        }
    }

    void makeHeap() {
        //절반을 잘라서 아래서부터 힙으로 만들면 된다.
        for (int i = (nodes.size() / 2) - 1; i >= 0; i--) {
            nodes.get(i).makeHeap();
        }
    }

    void setChildren() {
        for (int i = 0; i < nodes.size(); i++) {
            try {
                nodes.get(i).setLeftChild(nodes.get((i * 2) + 1));
                nodes.get(i).setRightChild(nodes.get((i * 2) + 2));
            } catch (Exception e) {
                return;
            }
        }
    }
}

class HeapSort {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8};
        HeapTree heapTree = new HeapTree();

        for (int i : input) {
            heapTree.addNode(new Node(i));
        }

        heapTree.setChildren();
        heapTree.makeHeap();
        heapTree.printNodes();
    }
}
