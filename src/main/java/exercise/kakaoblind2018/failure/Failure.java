package exercise.kakaoblind2018.failure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Stage implements Comparable<Stage>{
    private int level;
    private double failure;
    private int users;

    public Stage(int level) {
        this.level = level;
        users=0;
        failure =0;
    }

    public void addUser() {
        this.users++;
    }

    @Override
    public int compareTo(Stage s) {
        int i;
        if(s.failure - this.failure>0) i=1;
        else if ((s.failure - this.failure)==0) i=0;
        else  i=-1;

        return i; //역순정렬
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getFailure() {
        return failure;
    }

    public void setFailure(double failure) {
        this.failure = failure;
    }

    public int getUsers() {
        return users;
    }
}

//n번 스테이지에 실패율 = n번스테이지에 있는 사람의수 / n번 스테이지이상에 있는 사람의수 = stages의 요소중에 n인 요소 / stages의 요소중에 n이상인 요소
public class Failure {

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
//        int N = 4;
//        int[] stages = {4, 4, 4, 4, 4};


        int[] answer = Solution(N,stages);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    private static int[] Solution(int N, int[] stages) {
        List<Stage> stageList = new ArrayList<>();

        for (int i = 0; i < N; i++) { //레벨1~N까지 스테이지 객체생성
            Stage stage = new Stage(i+1);
            stageList.add(stage);
        }

        for (int stage : stages) { //요소를 확인하여 유저수가 몇명인지 추가
            if (stage > N) {
                continue;
            }
            stageList.get(stage-1).addUser();
        }

        for (int i = 0; i < stageList.size(); i++) { //실패율 구하기
            int higherUser = stages.length;
            for (int j = 0; j < i; j++) {
                higherUser -= stageList.get(j).getUsers();
            }

            if (higherUser <= 0) {
                stageList.get(i).setFailure((double)0);
                continue;
            }
            double failure = (double)stageList.get(i).getUsers() / (double) higherUser;

            stageList.get(i).setFailure(failure);
        }

        Collections.sort(stageList); //실패율로 내림차순 정렬

//        for (Stage s : stageList) {
//            System.out.println((s.getLevel())+ " : " + s.getFailure());
//        }

        int[] answer = new int[stageList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = stageList.get(i).getLevel();
        }

        return answer;
    }
}

