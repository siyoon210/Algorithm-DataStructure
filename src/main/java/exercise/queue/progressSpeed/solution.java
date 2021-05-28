package exercise.queue.progressSpeed;

import java.util.ArrayList;
import java.util.List;

class Queue {
    private int max;
    private int num;
    private int front;
    private int rear;
    private int[][] que;

    public static class EmptyQueException extends RuntimeException{
        public EmptyQueException() {
        }
    }

    public Queue(int max) {
        this.max = max;
        num = front =rear=0;
        que = new int[max][2];
    }

    public int[] enque(int p, int s){
        que[rear][0]=p;
        que[rear][1]=s;
        int[] tmp = que[rear];
        rear++;
        if(rear==max){
            rear=0;
        }
        num++;
        return tmp;
    }
    public int[] deque() throws EmptyQueException{
        if(num<=0){
            throw new EmptyQueException();
        }
        int[] tmp = que[front];
        front++;
        if (front==max){
            front=0;
        }
        num--;
        return tmp;
    }

    public int peek (){
        if(num<=0){
            throw new EmptyQueException();
        }
        return que[front][0];
    }
    public int size(){
        return num;
    }

    public void progressWork(){
       for (int i=0; i<this.size();i++){
           int index = i+front%max;
           que[index][0] += que[index][1];
       }
    }

    public boolean isEmpty(){
        return num<=0;
    }
}
public class solution {
    public static int[] solution(int[] progresses, int[] speeds) {
        //int[] answer = {}; //결과배열 크기의 동적 할당은 어떻게 하지?
        List<Integer> answerList = new ArrayList();
        Queue pQue = new Queue(progresses.length);

        for (int i=0; i<progresses.length; i++) { //큐에 작업진도, 작업속도 모두 인큐
            pQue.enque(progresses[i], speeds[i]);
        }


        while (!pQue.isEmpty()){
            while (pQue.peek() < 100) { //맨 앞에 작업진도가 100이상이 될때까지 작업
                pQue.progressWork();
            }
            int numOfRelease = 0;
            while (pQue.size()>0&&pQue.peek()>=100){
                pQue.deque();
                numOfRelease++;
            }

            answerList.add(numOfRelease);
        }

        int[] answer = new int[answerList.size()];//list를 배열로 변환
        for(int i = 0; i < answerList.size(); i++) answer[i] = answerList.get(i); //list를 배열로 변환

        return answer;
    }

    public static void main(String[] args) {
        int[] progresses = new int[]{93,30,55};
        int[] speeds = new int[]{1,30,5};

        for(int answer : solution(progresses, speeds)){
            System.out.println(answer);
        }

    }
}
