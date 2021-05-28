package exercise.hash;

import java.util.LinkedList;

class Node{
    String key;
    String value;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

class HashTable{
    LinkedList<Node>[] datas;

    public HashTable(int size) {
        datas = new LinkedList[size];
    }

    int getHashCode(String key) {
        int hashCode = 0;
        for (char c : key.toCharArray()) {
            hashCode += c;
        }
        return hashCode;
    }

    int convertHashCodeToIndex(int hashCode) {
        return hashCode % datas.length;
    }

    Node searchNode(LinkedList<Node> list, String key) {
        if (list == null) {
            return null;
        }
        for (Node node : list) {
            if (key.equals(node.getKey())) {
                return node;
            }
        }
        return null;
    }

    void put(String key, String value) {
        int hashCode = getHashCode(key);
        int index = convertHashCodeToIndex(hashCode);
        LinkedList<Node> list = datas[index];
        if (list == null) {
            list = new LinkedList<>();
            datas[index] = list;
        }
        Node node = searchNode(list, key);
        if (node == null) {
            list.add(new Node(key, value));
        } else {
            node.setValue(value);
        }
    }

    String getValueByKey(String key) {
        int hashCode = getHashCode(key);
        int index = convertHashCodeToIndex(hashCode);
        LinkedList<Node> list = datas[index];
        Node node = searchNode(list, key);
        return (node == null) ? "NOT FOUND!" : node.getValue();
    }
}

//class Node {
//    String key;
//    String value;
//
//    public Node(String key, String value) {
//        this.key = key;
//        this.value = value;
//    }
//
//    public String getValue() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }
//
//    public String getKey() {
//        return key;
//    }
//
//    public void setKey(String key) {
//        this.key = key;
//    }
//}
//
//class HashTable {
//    LinkedList<Node>[] data;
//
//    HashTable(int size) {
//        this.data = new LinkedList[size];
//    }
//
//    int getHashCode(String key) {
//        int hashcode = 0;
//        for (char c : key.toCharArray()) {
//            hashcode += c;
//        }
//        return hashcode;
//    }
//
//    int converToIndex(int hashCode) {
//        return hashCode % data.length;
//    }
//
//    Node searchNodeByKey(LinkedList<Node> list, String key) {
//        if (list == null) return null;
//        for (Node node : list) {
//            if (key.equals(node.getKey())) {
//                return node;
//            }
//        }
//        return null;
//    }
//
//    void put(String key, String value) {
//        int hashCode = getHashCode(key);
//        int index = converToIndex(hashCode);
//
//        LinkedList<Node> list = data[index];
//        if (list == null) {
//            list = new LinkedList<>();
//            data[index] = list;
//        }
//        Node node = searchNodeByKey(list, key);
//        if (node == null) {
//            list.addLast(new Node(key, value));
//        } else {
//            node.setValue(value);
//        }
//    }
//
//    String getValueByKey(String key) {
//        int hashCode = getHashCode(key);
//        int index = converToIndex(hashCode);
//        LinkedList<Node> list = data[index];
//        Node node = searchNodeByKey(list, key);
//        return node == null ? "Not found" : node.getValue();
//    }
//}

public class Hash {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(3);
        hashTable.put("siyoon", "똑똑해");
        hashTable.put("doyeon", "예뻐");
        hashTable.put("bangul", "기여어");
        hashTable.put("engdoo", "더 기여어");
        hashTable.put("siyoon", "대단해");
        System.out.println(hashTable.getValueByKey("siyoon"));
        System.out.println(hashTable.getValueByKey("doyeon"));
        System.out.println(hashTable.getValueByKey("bangul"));
        System.out.println(hashTable.getValueByKey("engdoo"));
        System.out.println(hashTable.getValueByKey("furu"));
    }
}
