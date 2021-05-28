package codingTest.c0llbus.p2;

import static org.assertj.core.api.Assertions.assertThat;

class StringCompressor {
    public String compress(String any) {
        StringBuilder sb = new StringBuilder();

        final char[] chars = any.toCharArray();

        char currChar = any.charAt(0);
        int repeatCount = 0;

        for (char aChar : chars) {
            if (aChar == currChar) {
                repeatCount++;
                continue;
            }

            sb.append(repeatCount);
            sb.append(currChar);
            repeatCount = 1;
            currChar = aChar;
        }

        sb.append(repeatCount);
        sb.append(currChar);
        return sb.toString();
    }

    public String decompress(String compressed) {
        StringBuilder sb = new StringBuilder();
        StringBuilder numSb = new StringBuilder();
        for (int i = 0, length = compressed.length(); i < length; i++) {
            final char c = compressed.charAt(i);
            if (c < '0' || c > '9') {
                final int repeatCount = Integer.parseInt(numSb.toString());
                for (int j = 0; j < repeatCount; j++) {
                    sb.append(compressed.charAt(i));
                }
                numSb.delete(0, numSb.length());
                continue;
            }

            numSb.append(c);
        }

        return sb.toString();
    }
}
public class P2 {
    public static void main(String[] args) {
        StringCompressor stringCompressor = new StringCompressor();

        assertThat(stringCompressor.compress("ZZZAA")).isEqualTo("3Z2A");
        assertThat(stringCompressor.compress("ZZZAAAAAAAAAABBCCQAA")).isEqualTo("3Z10A2B2C1Q2A");
        assertThat(stringCompressor.decompress("3Z10A2B2C1Q2A")).isEqualTo("ZZZAAAAAAAAAABBCCQAA");

        System.out.println("p2 success");
    }
}
