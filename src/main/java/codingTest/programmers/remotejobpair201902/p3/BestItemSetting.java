package codingTest.programmers.remotejobpair201902.p3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Item implements Comparable<Item> {
    private int index;
    private int additionalAttackAbility;
    private int losingStaminaValue;

    public Item(int index, int additionalAttackAbility, int losingStaminaValue) {
        this.index = index;
        this.additionalAttackAbility = additionalAttackAbility;
        this.losingStaminaValue = losingStaminaValue;
    }

    @Override
    public int compareTo(Item o) {
        return o.additionalAttackAbility - this.additionalAttackAbility;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getLosingStaminaValue() {
        return losingStaminaValue;
    }

}

class User implements Comparable<User> {
    private int health;
    private boolean isEquipped;

    public User(int health) {
        this.health = health;
        this.isEquipped = false;
    }

    @Override
    public int compareTo(User o) {
        return this.health - o.health;
    }

    public int getHealth() {
        return health;
    }

    public void setEquipped() {
        isEquipped = true;
    }

    public boolean isEquipped() {
        return isEquipped;
    }
}

class Solution {
    public int[] solution(int[] healths, int[][] items) {
        List<Integer> answerList = new ArrayList<>();
        LinkedList<User> users = new LinkedList<>();
        LinkedList<Item> itemList = new LinkedList<>();

        //healths 배열을 기반으로 유저 생성
        for (int health : healths) {
            users.add(new User(health));
        }

        //items 배열을 사용한 아이템 생성
        for (int i = 0; i < items.length; i++) {
            itemList.add(new Item(i + 1, items[i][0], items[i][1]));
        }

        //체력의 내차순으로 정렬
        Collections.sort(users);

        //올려주는 공격력의 오름차순으로 정렬
        Collections.sort(itemList);

        for (Item item : itemList) {
            for (User user : users) {
                if(user.isEquipped()){
                    continue;
                }
                //아이템을 착용 가능한 경우
                if (user.getHealth() - item.getLosingStaminaValue() >= 100) {
                    answerList.add(item.getIndex());
                    user.setEquipped();
                    break;
                }
            }
        }

        //리턴할때 오름차순으로 하기 위한 정렬
        Collections.sort(answerList);

        return answerList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}

public class BestItemSetting {
    public static void main(String[] args) {
//        int[] healths = {200, 120, 150};
        int[] healths = {300,200,500};
        int[][] items = {{1000, 600}, {400, 500}, {300, 100}};

        Solution solution = new Solution();
        for (int i : solution.solution(healths, items)) {
            System.out.print(i + "\t");
        }
    }
}
