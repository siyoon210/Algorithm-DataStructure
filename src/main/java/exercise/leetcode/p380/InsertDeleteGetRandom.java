package exercise.leetcode.p380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RandomizedSet {
    Map<Integer, Integer> valueAndListIndexMap;
    List<Integer> valueListForGetRandom;
    int listSizeForGetRandom; //굳이 필요 없을거 같은데

    /** Initialize your data structure here. */
    public RandomizedSet() {
        valueAndListIndexMap = new HashMap<>();
        valueListForGetRandom = new ArrayList<>();
        listSizeForGetRandom = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valueAndListIndexMap.containsKey(val)) {
            return false;
        } else {
            valueAndListIndexMap.put(val, listSizeForGetRandom);
            valueListForGetRandom.add(val);
            listSizeForGetRandom++;
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valueAndListIndexMap.containsKey(val)) {
            return false;
        } else {
            Integer listIndex = valueAndListIndexMap.get(val);
            Integer valueOfLastIndex = valueListForGetRandom.get(listSizeForGetRandom - 1);
            valueListForGetRandom.set(listIndex, valueListForGetRandom.get(listSizeForGetRandom - 1));
            valueAndListIndexMap.put(valueOfLastIndex, listIndex);
            valueListForGetRandom.remove(listSizeForGetRandom - 1);
            valueAndListIndexMap.remove(val);
            listSizeForGetRandom--;
            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return valueListForGetRandom.get((int)(Math.random() * listSizeForGetRandom));
    }
}


public class InsertDeleteGetRandom {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
//        System.out.println(randomizedSet.insert(1));
//        System.out.println(!randomizedSet.remove(2));
//        System.out.println(randomizedSet.insert(2));
//        System.out.println(randomizedSet.getRandom());
//        System.out.println(randomizedSet.remove(1));
//        System.out.println(!randomizedSet.insert(2));;
//        System.out.println(randomizedSet.getRandom() == 2);


//        System.out.println(randomizedSet.insert(-1));
//        System.out.println(!randomizedSet.remove(-2));
//        System.out.println(randomizedSet.insert(-2));
//        System.out.println(randomizedSet.getRandom());
//        System.out.println(randomizedSet.remove(-1));
//        System.out.println(!randomizedSet.insert(-2));;
//        System.out.println(randomizedSet.getRandom() == -2);

//        System.out.println(!randomizedSet.remove(0));
//        System.out.println(!randomizedSet.remove(0));
//        System.out.println(randomizedSet.insert(0));
//        System.out.println(randomizedSet.getRandom() == 0);
//        System.out.println(randomizedSet.remove(0));
//        System.out.println(randomizedSet.insert(0));

        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.getRandom() == 2);
    }
}
