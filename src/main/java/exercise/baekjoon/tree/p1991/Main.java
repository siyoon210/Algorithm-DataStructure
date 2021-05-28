package exercise.baekjoon.tree.p1991;


import java.util.Scanner;
class Node{
    private String data;
    private Node left;
    private Node right;

    public Node(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
class BinTree{
    //필드
    private Node root;

    public BinTree() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    //알맞은 부모(루트)노드를 찾아서 노드 추가
    public void addNode(Node parent, String data,String left, String right) {
        if (root == null) { //비어있는 이진트리라면 바로 설정
            root = new Node(data);
            if (left != ".") {
                root.setLeft(new Node(left));
            }
            if (right != ".") {
                root.setRight(new Node(right));
            }
            return;
        } else if (parent.getData()!=null && parent.getData().equals(data)) { //알맞은 부모(루트)노드를 찾음. = 같은 값의 노드
            if (left != ".") {
                parent.setLeft(new Node(left));
            }
            if (right != ".") {
                parent.setRight(new Node(right));
            }
        } else {
            addNode(parent.getLeft(), data, left, right); //왼쪽 자식기준 재귀로 찾아봄
            addNode(parent.getRight(), data, left, right); //오른쪽 자식기준 재귀로 찾아봄
        }
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;

        do {
            N = sc.nextInt();
        } while (N < 1 || N > 26);
        sc.nextLine();

        BinTree binTree = new BinTree();
        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            String[] inputArr = input.split(" ");

            binTree.addNode(binTree.getRoot(),inputArr[0],inputArr[1],inputArr[2]);
        }
    }
}