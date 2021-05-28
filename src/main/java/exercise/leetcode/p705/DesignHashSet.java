package exercise.leetcode.p705;

class MyHashSet {
    private boolean[] valueContains;
    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        valueContains = new boolean[1000001];
    }

    public void add(int key) {
        valueContains[key] = true;
    }

    public void remove(int key) {
        valueContains[key] = false;
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return valueContains[key];
    }
}

public class DesignHashSet {
    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println("hashSet.contains(1) = " + hashSet.contains(1));
        System.out.println("hashSet.contains(3) = " + hashSet.contains(3));
        hashSet.add(2);
        System.out.println("hashSet.contains(2) = " + hashSet.contains(2));
        hashSet.remove(2);
        System.out.println("hashSet.contains(2) = " + hashSet.contains(2));
    }
}
