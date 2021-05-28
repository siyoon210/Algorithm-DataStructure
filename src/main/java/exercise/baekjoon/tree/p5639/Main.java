package exercise.baekjoon.tree.p5639;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

//전위순회 -> 트리 -> 후위순회
class BinTree<K,V> {
    static class Node<K,V>{
        private K key; //키 값
        private V data; //데이터
        private Node<K,V> left; //왼쪾 자식 노드
        private Node<K,V> right; //오른쪽 자식 노드

        public Node(K key, V data, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return data;
        }

        //데이터 출력
        void print() {
            System.out.println(data);
        }
    }

    private Node<K, V> root;
    private Comparator<? super K> comparator = null; //비교자

    public BinTree() {
        root = null;
    }

    public BinTree(Comparator<? super K> comparator) {
        this();
        this.comparator = comparator;
    }

    private int comp(K key1, K key2) {
        return (comparator == null) ? ((Comparable < K >) key1).compareTo(key2) : comparator.compare(key1, key2);
    }

    //키에 의한 검색
    public V search(K key) {
        Node<K,V> p = root;

        while (true) {
            if (p == null) {
                return null;
            }
            int cond = comp(key, p.getKey());
            if (cond == 0) {
                return p.getValue();
            } else if (cond < 0) {
                p = p.left;
            } else{
                p = p.right;
            }
        }
    }

    //node를 루트로 하는 서브 트리에 노드<K,V>를 삽입
    private void addNode(Node<K, V> node, K key, V data) {
        int cond = comp(key, node.getKey());
        if (cond == 0) {
            return; //key가 이진검색트리에 이미 있음. 이진검색트리에서 key값은 고유해야한다.
        } else if (cond < 0) {
            if (node.left == null) { //key값이 더 작은데 마침, 노드의 왼쪽이 비어있다(null)이면
                node.left = new Node<K, V>(key, data, null, null); //노드삽입
            } else {
                addNode(node.left,key, data); //key값이 더 작은데, 노드의 값이 null이 아니면 재귀적으로 진행
            }
        } else{
            if (node.right == null) {
                node.right = new Node<K, V>(key, data, null, null);
            }else{
                addNode(node.right, key, data);
            }
        }
    }

    //노드를 삽입
    public void add(K key, V data) {
        if (root == null) {
            root = new Node<K, V>(key, data, null, null);
        }else{
            addNode(root, key, data);
        }
    }

    //키 값이 key인 노드를 삭제
    public boolean remove(K key) {
        Node<K, V> p = root; //스캔중인 노드
        Node<K, V> parent = null; //스캔 중인 노드의 부모 노드
        boolean isLeftChild = true;  //p는 부모의 왼쪽 자식 노드인가?

        while (true) {
            if (p == null) {
                return false; //키 값이 없으므로 삭제 실패
            }
            int cond = comp(key, p.getKey()); //key와 노드 p의 key값을 비교
            if (cond == 0) {
                break; //검색성공
            } else {
                parent = p; //key값이 작거나 커서 이동할 예정인데, 부모 노드를 내려가기 전에 설정해둔다.
                if (cond < 0) { //key 값이 더 작으니까 왼쪽으로
                    isLeftChild = true;
                    p = p.left;
                }else {
                    isLeftChild = false;
                    p = p.right;
                }
            }
        }
        //key값의 검색성공

        if (p.left == null) { //현재 검색된 노드p의 왼쪽자식이 없을경우
            if (p == root) {
                root = p.right;
            } else if (isLeftChild) {
                parent.left = p.right; //부모의 왼쪽 포인터가 오른쪽 자식을 가리킴
            } else {
                parent.right = p.right; //부모의 오른쪾 포인터가 오른쪽 자식을 가리킴
            }
        } else if (p.right == null) {
            if (p == root) {
                root = p.left;
            } else if (isLeftChild) {
                parent.left = p.left;
            } else {
                parent.right = p.left;
            }
        } else { //왼쪽, 오른쪽 모두 null이 아니므로, 자식노드가 2개인경우
            parent =p;
            Node<K, V> left = p.left; //왼쪽 서브 트리 가운데 가장 큰 노드
            isLeftChild = true;
            while (left.right != null) { //가장 큰 노드 left를 검색 - 오른쪽으로 만 가면 가장 큰 값이 나옴
                parent = left;
                left = left.right;
                isLeftChild = false;
            }
            p.key = left.key; //left의 키 값을 p로 옮김
            p.data = left.data; //left의 데이터를 p로 옮김

            //left삭제 과정
            if (isLeftChild) {
                parent.left = left.left;
            } else {
                parent.right = left.left;
            }


        }

        return true;
    } //삭제메소드

    //node를 루트로 하는 서브 트리의 노드를 키 값의 오름차순으로 출력
    private void printSubTree(Node node) {
        if (node != null) {
            printSubTree(node.left); //왼쪾 서브 트리를 키 값의 오름차순으로 출력
            System.out.println(node.key + " " + node.data);
            printSubTree(node.right);//으론쪽 서브 트리르 키 값의 오름차순으로 출력
        }
    }

    //모든 노드를 키값의 오름차순으로 출력
    public void print() {
        printSubTree(root);
    }

    /**연습문제 01 내림차순 출력**/
    private void pushSubTree(Node node,Stack stack) {
        if (node != null) {
            pushSubTree(node.left,stack); //왼쪾 서브 트리를 키 값의 오름차순으로 스택에 푸쉬
            stack.push(node); //
            pushSubTree(node.right,stack);//으론쪽 서브 트리르 키 값의 오름차순으로 스택에 푸쉬
        }
    }

    public void printReverse() {
        Stack stack = new Stack();
        pushSubTree(root,stack);
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    /** 연습문제 02  **/
    //음.. 아마도 가장 작은 키는 왼쪽-왼쪽-왼쪽... 노드 중에 하나 일 것이다.
    K getMinKey() {
        if (root == null) {
            return null; //트리가 비어 있다.->null리턴
        }
        Node<K,V> p = root; //루트부터 시작해서
        K minKey = root.getKey();
        while (p.left != null) {
            int cond = comp(minKey, p.left.getKey());
            if (cond < 0) {
                minKey = p.left.getKey();
            }
            p = p.left;
        }

        return minKey;
    }

    V getDataWithMinKey() {
        return search(getMinKey());
    }

    //아마도 가장 큰 값음 가장 오른쪽 노드의 가장 높은 레벨일것이다.
    K getMaxKey() {
        if (root == null) {
            return null;
        }
        Node<K,V> p =root;//루트부터 시작해서
        while (p.right != null) {
            p = p.right;
        }
        return p.getKey();
    }

    V getDatawithMaxKey() {
        return search(getMaxKey());
    }


    //후위순회
    public void postorder(Node node){
        if (node.left != null) {
            postorder(node.left);
        }
        if (node.right != null) {
            postorder(node.right);
        }
        node.print();
    }

    public void printpostOrder() {
        postorder(root);
    }

}
public class Main {
    public static void main(String[] args) {
        BinTree binTree = new BinTree();
        binTree.add(50,50);
        binTree.add(30,30);
        binTree.add(24,24);
        binTree.add(5,5);
        binTree.add(28,28);
        binTree.add(45,45);
        binTree.add(98,98);
        binTree.add(52,52);
        binTree.add(60,60);

        binTree.printpostOrder();
    }


}
