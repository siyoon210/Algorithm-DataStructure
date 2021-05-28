package exercise.baekjoon.stack.p2504;

import java.util.Scanner;
import java.util.Stack;

//https://www.acmicpc.net/problem/2504
public class Main { //괄호의값
    public static void main(String[] args) {
        String input = "(()[[]])([])(()[[]])([])";
//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine();

        int result =0;
        Stack stack = new Stack();
        try {
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '(') {
                    stack.push(2);
                    //System.out.println("2푸쉬");
                } else if (input.charAt(i) == '[') {
                    stack.push(3);
                    //System.out.println("3푸쉬");
                } else if (input.charAt(i) == ')' || input.charAt(i) == ']') {
                    if (input.charAt(i - 1) == '(' || input.charAt(i - 1) == '[') {

                    } else if (input.charAt(i - 1) == ')' || input.charAt(i - 1) == ']') {
                        result = calc(stack);
                        //System.out.println("중간결과 results"+result);
                    }
                    if (i != input.length() - 1 && (input.charAt(i + 1) == '(' || input.charAt(i + 1) == '[')) {
                        stack.push(-1);
                        //System.out.println("더하기 푸쉬");
                    }
                } else {
                     result=0;
                     break;
                }
            }//for
        } catch (Exception e) {
            result=0;
        }

        while (!stack.empty()) {
            //스택의 마지막부분인지 확인
            int tmp = (int)stack.pop();
            if (stack.empty()) {
                break;
            }
            stack.push(tmp);

            //System.out.println("나머지처리");
            result = calc(stack);
        }

        try {
            if (!InputValueTester(input)) {
                result=0;
            }
        } catch (Exception e) {
            result=0;
        }
        System.out.println(result);

    }//main

    public static int calc(Stack stack) {
        int result =0;

        while (true) {
            int a = (int)stack.pop();
            //System.out.println("a는 : " +a);
            if (!stack.empty()&&(int) stack.peek() == -1) {
                stack.pop();
                stack.push(a+(int)stack.pop());
                //System.out.println("더하고 푸쉬한거 결과 : " +stack.peek());
                continue;
            }
            int b=1;
            if(!stack.empty())
             b = (int)stack.pop();
            result = a*b;
            stack.push(result);
            break;
        }
        return result;
    }

    public static boolean InputValueTester(String string) throws Exception{
        if (string.length() < 1 || string.length() > 30) {
            return false;
        }
        Stack stack = new Stack();
        try {
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == '(') {
                    stack.push(2);
                }
                else if (string.charAt(i) == '[') {
                    stack.push(3);
                }
                else if(string.charAt(i) == ')'){
                    if((int)stack.pop() != 2){
                        return false;
                    }

                }
                else if(string.charAt(i) == ']'){
                    if((int)stack.pop() != 3){
                        return false;
                    }

                }
            }
        } catch (Exception e) {
            return false;
        }
        if (!stack.empty()) {
            return false;
        }

        return true;
    }
}
