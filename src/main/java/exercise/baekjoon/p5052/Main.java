package exercise.baekjoon.p5052;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine()); //테스트 케이스 수
        Boolean[] result = new Boolean[testCase];

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine()); //전화번호의 갯수
            String[] phoneNum = new String[n];
            for (int j = 0; j < n; j++) {
                phoneNum[j] = br.readLine();
            }

            result[i] = checkConsistency(phoneNum);
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i] ? "YES" : "NO");
        }
    }

    public static Boolean checkConsistency(String[] phoneNum) {
        for (int i = 0; i < phoneNum.length; i++) {
            String regex = phoneNum[i];
            Pattern pattern = Pattern.compile(regex);
            for (int j = 0; j < phoneNum.length; j++) {
                if (i != j) { //같은 인덱스가 아닐때만 비교
                    if (phoneNum[i].length() > phoneNum[j].length()) { //검색하는 문자열이 더 길다면 굳이 확인 안함
                        continue;
                    } else {
                        String str = phoneNum[j].substring(0, phoneNum[i].length());
                        Matcher matcher = pattern.matcher(str);
                        if (matcher.matches()) {
//                        System.out.println("접두사 일치 : "+phoneNum[i]+" "+phoneNum[j]);
                            return false;
                        }
                    }
                }

            }
        }
        return true;
    }
}
