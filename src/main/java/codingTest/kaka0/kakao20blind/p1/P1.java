package codingTest.kaka0.kakao20blind.p1;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public String solution(String newId) {
        newId = step1(newId);
        newId = step2(newId);
        newId = step3(newId);
        newId = step4(newId);
        newId = step5(newId);
        newId = step6(newId);
        newId = step7(newId);
        return newId;
    }

    private String step1(String newId) {
        return newId.toLowerCase();
    }

    private String step2(String newId) {
        return newId.replaceAll("[^a-z0-9_.-]", "");
    }

    private String step3(String newId) {
        return newId.replaceAll("\\.{2,}", ".");
    }

    private String step4(String newId) {
        if (newId.isEmpty()) {
            return newId;
        }

        if (newId.charAt(0) == '.') {
            newId = newId.substring(1);
        }

        if (newId.isEmpty()) {
            return newId;
        }

        if (newId.charAt(newId.length() - 1) == '.') {
            newId = newId.substring(0, newId.length() - 1);
        }

        return newId;
    }

    private String step5(String newId) {
        if (newId.isEmpty()) {
            return "a";
        }

        return newId;
    }

    private String step6(String newId) {
        if (newId.length() >= 16) {
            newId = newId.substring(0, 15);

            if (newId.charAt(newId.length() - 1) == '.') {
                newId = newId.substring(0, newId.length() - 1);
            }
        }

        return newId;
    }

    private String step7(String newId) {
        if (newId.length() <= 2) {
            String lastChar = String.valueOf(newId.charAt(newId.length() - 1));

            if (newId.length() == 1) {
                newId += lastChar + lastChar;
            } else {
                newId += lastChar;
            }
        }

        return newId;
    }
}


/**
 1단계 new_id의 모든대문자를 대응되는 소문자로 치환합니다.
 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
 */

public class P1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        assertThat(solution.solution("")).isEqualTo("aaa");
        assertThat(solution.solution("...!@BaT#*..y.abcdefghijklm.")).isEqualTo("bat.y.abcdefghi");
        assertThat(solution.solution("...!@BaT#*..y.abcdefghijklm")).isEqualTo("bat.y.abcdefghi");
        assertThat(solution.solution("z-+.^.")).isEqualTo("z--");
        assertThat(solution.solution("=.=")).isEqualTo("aaa");
        assertThat(solution.solution("123_.def")).isEqualTo("123_.def");
        assertThat(solution.solution("abcdefghijklmn.p")).isEqualTo("abcdefghijklmn");

        out.println("p1" + " success!");
    }
}
