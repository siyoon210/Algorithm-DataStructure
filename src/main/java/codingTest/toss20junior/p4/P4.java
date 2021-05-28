package codingTest.toss20junior.p4;

import java.util.Set;
import java.util.TreeSet;

public class P4 {
    public static void main(String[] args) {
        solution("우리 우리 우리 하나 우리 국민 삼성 농협 농협 농협 국민 저축");
    }

    private static void solution(String s) {
        final String[] strs = s.split(" ");
        Set<PaymentMethod> paymentMethod = new TreeSet<>();
        for (int i = 0; i < strs.length; i++) {
            paymentMethod.add(new PaymentMethod(strs[i], i));

            int printedCount = 0;
            for (PaymentMethod method : paymentMethod) {
                if (printedCount >= 5) {
                    break;
                }
                System.out.print(method.name + " ");
                paymentMethod.add(method);
                printedCount++;
            }
            System.out.println();
        }
    }


    private static class PaymentMethod implements Comparable<PaymentMethod>{
        private final String name;
        private final int paymentSequence;

        public PaymentMethod(String name, int paymentSequence) {
            this.name = name;
            this.paymentSequence = paymentSequence;
        }

        @Override
        public int compareTo(PaymentMethod o) {
            if (this.name.equals(o.name)) {
                return 0;
            }
            return o.paymentSequence - this.paymentSequence;
        }
    }
}
