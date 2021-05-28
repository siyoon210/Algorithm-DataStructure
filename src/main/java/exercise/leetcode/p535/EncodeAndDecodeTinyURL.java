package exercise.leetcode.p535;

import java.util.HashMap;
import java.util.Map;

class Codec {
    Map<Integer, String> hashcodeAndLongUrl;
    final String tinyPrefix = "http://tinyurl.com/";

    public Codec() {
        hashcodeAndLongUrl = new HashMap<>();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int hashCode = longUrl.hashCode();
        hashcodeAndLongUrl.put(hashCode, longUrl);
        return tinyPrefix + hashCode;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String hashcode = shortUrl.substring(tinyPrefix.length());
        return hashcodeAndLongUrl.get(Integer.valueOf(hashcode));
    }
}

public class EncodeAndDecodeTinyURL {
    public static void main(String[] args) {
        Codec codec = new Codec();
        String encode1 = codec.encode("https://leetcode.com/problems/design-tinyurl1");
        String encode2 = codec.encode("https://leetcode.com/problems/design-tinyurl2");

        System.out.println("encode1 = " + encode1);
        System.out.println("encode2 = " + encode2);

        System.out.println("codec.decode(encode1) = " + codec.decode(encode1));
        System.out.println("codec.decode(encode2) = " + codec.decode(encode2));
    }
}
