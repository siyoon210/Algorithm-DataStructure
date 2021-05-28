package exercise.programmers.dfsbfs.network;


import java.util.LinkedList;

class Network {
    class Computer {
        int index;
        LinkedList<Computer> directConnect;
        boolean connected;

        private Computer(int index) {
            this.index = index;
            directConnect = new LinkedList<>();
            connected = false;
        }
    }

    private Computer[] computers;
    private int network;

    public Network(int comNum) {
        computers = new Computer[comNum];
        //인덱스와 컴퓨터 번호가 같다고 정함
        for (int i = 0; i < comNum; i++) {
            Computer computer = new Computer(i);
            computers[i] = computer;
        }
    }

    public void setConnection(int[][] computers) {
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (computers[i][j] == 1) {
                    this.computers[i].directConnect.add(this.computers[j]);
                }
            }
        }
    }

    void findNetwork(Computer computer) {
        if (computer == null) return;

        isNewNetwork(computer);
        for (Computer directConnectComputer : computer.directConnect) {
            if (!directConnectComputer.connected) {
                directConnectComputer.connected = true;
                findNetwork(directConnectComputer);
            }
        }
    }

    void isNewNetwork(Computer computer) {
        if(!computer.connected) network++;
    }

    void countAllNetwork() {
        for (Computer c : computers) {
            if (!c.connected)
                findNetwork(c);
        }
    }

    public int getNetwork() {
        return network;
    }
}

public class Solution {
    private static int[] flag;

    public static void main(String[] args) {
//        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
//        int[][] computers = {{1, 0, 1}, {0, 1, 1}, {1, 1, 1}};
//        int[][] computers = {{1, 1, 1, 0}, {1, 1, 0, 0}, {1, 0, 1, 1},{0, 0, 1, 1}};
//        int[][] computers = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0},{0, 0, 0, 1}};
        int[][] computers = {{1, 1, 1, 0, 0}, {1, 1, 1, 0, 0}, {1, 1, 1, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}};
        int n = computers.length;
        System.out.println(Solution.solution(n, computers));
    }

    public static int solution(int n, int[][] computers) {
        Network network = new Network(computers.length);
        network.setConnection(computers);
        network.countAllNetwork();
        return network.getNetwork();
    }
}
