package exercise.baekjoon.linkedlist.p1406;

import java.util.LinkedList;
import java.util.Scanner;

public class Main { //에디터 문제
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = sc.nextInt();
        System.out.println(solution(str, n));
    }


    private static String solution(String str, int n) {
        LinkedList<Character> editer = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            editer.add(str.charAt(i));
        }
        char cursor = '|';
        editer.add(cursor);

        while (n > 0) {
            Scanner sc = new Scanner(System.in);
            String command = sc.nextLine();
            try {
                if (command.equals("L")) {
                    if (editer.indexOf(cursor) > 0) {
                        char tmp = editer.get(editer.indexOf(cursor)-1);
                        editer.remove(editer.indexOf(cursor)-1);
                        editer.add(editer.indexOf(cursor)+1,tmp);
                    }
                }
                else if (command.equals("D")) {
                    if (editer.indexOf(cursor) < editer.size()-1) {
                        char tmp = editer.get(editer.indexOf(cursor)+1);
                        editer.remove(editer.indexOf(cursor)+1);
                        editer.add(editer.indexOf(cursor),tmp);
                    }
                }
                else if (command.equals("B")) {
                    if (editer.indexOf(cursor) > 0) {
                        editer.remove(editer.indexOf(cursor)-1);
                    }
                }

                else if (command.substring(0, 1).equals("P")) {
                    if (command.indexOf(" ") == 1 && command.length()>2) {
                        for (int i = 0; i < command.substring(2).length(); i++) {
                            editer.add(editer.indexOf(cursor), command.substring(2).charAt(i));
                        }
                    }
                }else{

                }
            } catch (Exception e) {
            }
            n--;
            //print(editer);
        }

        editer.remove(cursor);

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < editer.size(); i++) {
            output.append(editer.get(i));
        }

        return output.toString();
    }

    //test 출력용
    public static void print(LinkedList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }
}
