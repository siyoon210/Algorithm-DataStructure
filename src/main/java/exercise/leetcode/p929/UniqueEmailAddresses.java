package exercise.leetcode.p929;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for (String email : emails) {
            String localName = email.substring(0, email.indexOf('@'));
            String domainName = email.substring(email.indexOf('@'));

            if (localName.indexOf('+') >= 0) {
                localName = localName.substring(0, localName.indexOf('+'));
            }

            while (localName.indexOf('.') >= 0) {
                localName = localName.substring(0, localName.indexOf('.')) + localName.substring(localName.indexOf('.') + 1);
            }

            emailSet.add(localName + domainName);
        }

        return emailSet.size();
    }
}

public class UniqueEmailAddresses {
    public static void main(String[] args) {
//        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
//        String[] emails = {"testemail@leetcode.com", "testemail1@leetcode.com", "testemail+david@lee.tcode.com"};
        String[] emails = {"j+ezsorqlmc@rfpycgjuf.com","j+k+ri+rigt.ad@rfpycgjuf.com"};

        Solution solution = new Solution();
        System.out.println(solution.numUniqueEmails(emails));
    }
}
