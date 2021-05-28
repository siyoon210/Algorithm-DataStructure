package exercise.programmers.stackqueue.truckpassingbridge;

import java.util.LinkedList;
import java.util.Queue;

class Truck {
    private int weight;
    private int travelDistance;

    public Truck(int weight) {
        this.weight = weight;
        travelDistance = 0;
    }

    void addDistance() {
        this.travelDistance++;
    }

    public int getTravelDistance() {
        return travelDistance;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

class Bridge {
    private Queue<Truck> passingTrucks;
    private Queue<Truck> waitingTrucks;
    private int length;
    private int limitWeight;
    private int presentWeight;
    private int elapsedSeconds; //경과 시간 (초)

    public Bridge(int[] truckWeights, int bridgeLength, int limitWeight) {
        setWaitingTruckQueue(truckWeights);
        passingTrucks = new LinkedList<>();
        this.length = bridgeLength;
        this.limitWeight = limitWeight;
        presentWeight = 0;
        elapsedSeconds = 0;
    }

    private void setWaitingTruckQueue(int[] truckWeights) {
        waitingTrucks = new LinkedList<>();
        for (int i = 0; i < truckWeights.length; i++) {
            waitingTrucks.add(new Truck(truckWeights[i]));
        }
    }

    void calcElapsedSeconds() {
        while (!waitingTrucks.isEmpty() || !passingTrucks.isEmpty()) {
            addDistance();
            removeTruckOnBridge();
            addTruckOnBridge();
            elapsedSeconds++;
        }
    }

    private void removeTruckOnBridge() {
        if (!passingTrucks.isEmpty() && passingTrucks.peek().getTravelDistance() >= length) {
            presentWeight -= passingTrucks.poll().getWeight();
        }
    }

    private void addDistance() {
        for (Truck passingTruck : passingTrucks) {
            passingTruck.addDistance();
        }
    }

    private void addTruckOnBridge() {
        if (!waitingTrucks.isEmpty()) {
            Truck peek = waitingTrucks.peek();
            int peekWeight = peek.getWeight();
            if (limitWeight >= (peekWeight + presentWeight)) {
                presentWeight += peekWeight;
                passingTrucks.add(waitingTrucks.poll());
            }
        }
    }

    public int getElapsedSeconds() {
        return elapsedSeconds;
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Bridge bridge = new Bridge(truck_weights, bridge_length, weight);
        bridge.calcElapsedSeconds();
        return bridge.getElapsedSeconds();
    }
}

public class ATruckPassingABridge {
    public static void main(String[] args) {
//        int bridge_length = 2;
//        int[] truck_weight = {7, 4, 5, 6};
//        int weight = 10;

//        int bridge_length = 100;
//        int[] truck_weight = {10};
//        int weight = 100;

        int bridge_length = 100;
        int[] truck_weight = {10,10,10,10,10,10,10,10,10,10};
        int weight = 100;

        Solution solution = new Solution();
        System.out.println(solution.solution(bridge_length, weight, truck_weight));
    }
}
