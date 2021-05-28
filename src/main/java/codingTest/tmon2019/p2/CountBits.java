package codingTest.tmon2019.p2;

public class CountBits {
    public static void main(String[] args) {
        int input = 7;
        System.out.println(countBits(input));
    }

    public static int countBits(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 2 == 1) {
                count++;
            }
            num /= 2;
        }

        return count;
    }
}
