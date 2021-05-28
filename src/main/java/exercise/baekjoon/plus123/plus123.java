package exercise.baekjoon.plus123;

import java.util.Scanner;


public class plus123 {
    static int MAX_N = 11;

    public static int factorial(int n){
        if(n>0)
            return n*factorial(n-1);
        else
            return 1;
    }

    static void plus123(int[] input){
        for(int i=0; i<input.length; i++){
            int result=1;
            int numOfOne =input[i];
            int numOfTwo =0;
            int numOfThree =0;

            while (numOfOne - (2) >= 0) { //1,2만 조합으로 만들수 있는 경우
                numOfTwo++;
                numOfOne -=2;
                result += factorial(numOfOne+numOfTwo+numOfThree)/(factorial(numOfOne)*factorial(numOfTwo)*factorial(numOfThree));
            }

            numOfOne =input[i];
            numOfTwo =0;

            while (numOfOne - 3 >= 0) { //1,3만 들어가는 조합의 경우
                numOfThree++;
                numOfOne -=3;
                result += factorial(numOfOne+numOfTwo+numOfThree)/(factorial(numOfOne)*factorial(numOfTwo)*factorial(numOfThree));
            }

            for (int j=1; (j*3)<=MAX_N; j++) { //1,2,3이 모두 들어가는 조합의 경우
                numOfOne = input[i];
                numOfTwo = 0;
                numOfThree = 0;

                while (numOfOne - 3*j >= 0) {
                    numOfThree += j;
                    numOfOne -= (3*j);
                    while (numOfOne - (2) >= 0) {
                        numOfTwo++;
                        numOfOne -= 2;
                        result += factorial(numOfOne + numOfTwo + numOfThree) / (factorial(numOfOne) * factorial(numOfTwo) * factorial(numOfThree));
                    }
                }
            }
            if(input[i]<=3) result--;
            System.out.println(result);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("테스트 케이스 수 : ");
        int caseNum;
        do{
            caseNum = sc.nextInt();
        }while (caseNum<0);

        int[] input = new int[caseNum];

        for(int i=0; i<caseNum; i++){
            do{
                System.out.print("테스트 케이스 "+(i+1)+" : ");input[i]=sc.nextInt();
            }while (input[i]<1||input[i]>11);
        }

        plus123(input);
    }
}
