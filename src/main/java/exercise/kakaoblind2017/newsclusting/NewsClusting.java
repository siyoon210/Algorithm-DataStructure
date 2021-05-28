package exercise.kakaoblind2017.newsclusting;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        //2개씩 쪼개기, 오로지 영문자쌍만 인정한다. 대소문자는 구분하지 않는다.
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> clustList1 = new ArrayList<>();
        List<String> clustList2 = new ArrayList<>();

        setClustList(str1, clustList1);
        setClustList(str2, clustList2);

        if (clustList1.isEmpty() && clustList2.isEmpty()) {
            return 65536;
        }

        int intersectionSize = 0;

        for (final String clust : clustList1) {
            if (clustList2.contains(clust)) {
                clustList2.remove(clust);
                intersectionSize++;
            }
        }


        int unionSize = (clustList1.size() + clustList2.size());

        double jacade = ((double) intersectionSize / unionSize) * 65536;

        return (int) jacade;
    }

    private void setClustList(final String str, final List<String> clustList) {
        for (int i = 0; i < str.length() -1; i++) {
            if (isAlphabet(str.charAt(i)) && isAlphabet(str.charAt(i + 1))) {
                final String clust = str.charAt(i) +""+ str.charAt(i + 1);
                clustList.add(clust);
            }
        }
    }

    private boolean isAlphabet(final char c) {
        return c >= 'a' && c <= 'z';
    }
}

public class NewsClusting {
    public static void main(String[] args) {
        String str1 = "E=M*C^2";
        String str2 = "e=m*c^2";

        Solution solution = new Solution();
        System.out.println("solution.solution(str1, str2) = " + solution.solution(str1, str2));
    }
}
