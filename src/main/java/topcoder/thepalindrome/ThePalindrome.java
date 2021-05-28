package topcoder.thepalindrome;

public class ThePalindrome {
    public static void main(String[] args) {
//        String s = "abab";
//        String s = "abacaba";
//        String s = "qwerty";
        String s = "abdfhdyrbdbsdfghjkllkjhgfds";
        System.out.println(find(s));
    }

    //결국 핵심은 회문을 만드는 것이 아니라 회문을 만들 수 있는 숫자다.
    static int find(String s) {
        int add = 0;

        for (int i = 0; i < (s.length() + add) / 2; i++) {
            if (i < add) {
                continue;
            }
            if (s.charAt(i) != s.charAt(s.length() - 1 - i + add)) {
                add++;
                i = 0;
            }
        }
        return s.length() + add;
    }
}
