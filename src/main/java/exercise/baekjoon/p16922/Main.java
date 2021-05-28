package exercise.baekjoon.p16922;

import java.util.Scanner;

//class MakingRomeNum {
//    private Set<Integer> cases;
//    private int romeCharCount;
//
//    MakingRomeNum(int romeCharCount) {
//        this.romeCharCount = romeCharCount;
//        this.cases = new HashSet<>();
//    }
//
//    void calcCases(int num, int step) {
//        if (step >= romeCharCount) {
//            cases.add(num);
//            return;
//        }
//
//        //I를 추가하는 경우 (1)
//        calcCases(num + 1, step + 1);
//
//        //V를 추가하는 경우 (5)
//        calcCases(num + 5, step + 1);
//
//        //X를 추가하는 경우 (10)
//        calcCases(num + 10, step + 1);
//
//        //L를 추가하는 경우 (50)
//        calcCases(num + 50, step + 1);
//    }
//
//    int getCasesSize() {
//        return cases.size();
//    }
//}

class MakingRomeNum {
    private int[] numberOfEachCharcter;
    private int romeCharCount;
    private int cases;

    MakingRomeNum(int romeCharCount) {
        this.romeCharCount = romeCharCount;
        this.numberOfEachCharcter = new int[4]; //0번 인덱스부터 I V X L의 갯수를 뜻함
        this.cases = 0;
    }

    void calcCases(int step) {
        if (step >= romeCharCount) {
            System.out.println(numberOfEachCharcter[0]+","+numberOfEachCharcter[1]+","+numberOfEachCharcter[2]+","+numberOfEachCharcter[3]);
            cases++;
            return;
        }

        //I를 추가하는 경우 (1)
        calcCases(step + 1);
    }

    int getCases() {
        return cases;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        MakingRomeNum makingRomeNum = new MakingRomeNum(input);
        makingRomeNum.calcCases( 0);
        System.out.println(makingRomeNum.getCases());
    }
}
