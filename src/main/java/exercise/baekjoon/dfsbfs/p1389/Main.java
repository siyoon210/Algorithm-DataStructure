package exercise.baekjoon.dfsbfs.p1389;

import java.util.*;

class User {
    private int index;
    private List<User> friends;
    private int kevinBacon;
    private boolean checked;
    private int step;

    User(int index) {
        this.index = index;
        friends = new ArrayList<>();
        kevinBacon = 0;
        checked = false;
        step = 0;
    }

    void addFriend(User user) {
        friends.add(user);
    }

    void addKevinBacon(int step) {
        this.kevinBacon += step;
    }

    public int getIndex() {
        return index;
    }

    List<User> getFriends() {
        return friends;
    }

    int getKevinBacon() {
        return kevinBacon;
    }

    boolean isChecked() {
        return checked;
    }

    void setChecked(boolean checked) {
        this.checked = checked;
    }

    int getStep() {
        return step;
    }

    void setStep(int step) {
        this.step = step;
    }
}

class Graph {
    private List<User> users;

    Graph(int size) {
        users = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            users.add(new User(i + 1));
        }
    }

    void setFriends(int index1, int index2) {
        User user1 = users.get(index1 - 1);
        User user2 = users.get(index2 - 1);

        if (!user1.getFriends().contains(user2)) {
            user1.addFriend(user2);
        }
        if (!user2.getFriends().contains(user1)) {
            user2.addFriend(user1);
        }
    }

    private void calcKevinBacon(User user){
        resetUsersStep();
        resetUsersChecked();

        Queue<User> queue = new LinkedList<>();
        user.setChecked(true);
        queue.add(user);

        while (!queue.isEmpty()) {
            User peek = queue.peek();
            for (User friend : peek.getFriends()) {
                if (!friend.isChecked()) {
                    friend.setChecked(true);
                    friend.setStep(peek.getStep() + 1);
                    queue.add(friend);
                }
            }
            user.addKevinBacon(queue.poll().getStep());
        }
    }

    //큐에 넣기 전에 step을 매번 초기화 해줘야해
    private void resetUsersStep() {
        for (User user : users) {
            user.setStep(0);
        }
    }

    private void resetUsersChecked() {
        for (User user : users) {
            user.setChecked(false);
        }
    }

    void calcKevinBacon() {
        for (User user : users) {
            calcKevinBacon(user);
        }
    }

    int getWinner() {
        int min = users.get(users.size() - 1).getKevinBacon();
        int winner = users.get(users.size() - 1).getIndex();

        for (int i = users.size()-1; i >= 0; i--) {
            User user = users.get(i);
            if (user.getKevinBacon() <= min) {
                min = user.getKevinBacon();
                winner = user.getIndex();
            }
        }

        return winner;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] relation = new int[M][2];
        for (int i = 0; i < M; i++) {
            relation[i][0] = sc.nextInt();
            relation[i][1] = sc.nextInt();
        }

        Graph graph = new Graph(N);
        for (int[] ints : relation) {
            graph.setFriends(ints[0], ints[1]);
        }

        graph.calcKevinBacon();

        System.out.println(graph.getWinner());
    }
}
