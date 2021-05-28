package codingTest.sixshop.p4;

//import com.google.gson.Gson;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;

public class Solution {
//    private class MovieData {
//        private int total;
//
//        private class Data {
//            private String Title;
//        }
//
//        private List<Data> data;
//    }
//
//    private static Gson gson = new Gson();
//
//    static String[] getMovieTitles(String substr) throws IOException {
//        List<String> titles = new ArrayList<>();
//
//        MovieData movieData = getJsonData(substr, 1);
//        int total = movieData.total;
//
//        for (int page = 1; titles.size() < total;) {
//            addTitles(movieData, titles);
//            movieData = getJsonData(substr, ++page);
//        }
//
//        String[] answer = new String[titles.size()];
//        for (int i = 0; i < answer.length; i++) {
//            answer[i] = titles.get(i);
//        }
//
//        Arrays.sort(answer);
//        return answer;
//    }
//
//    private static MovieData getJsonData(String substr, int page) throws IOException {
//        String urlStr = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr + "&page=" + page;
//        URL url = new URL(urlStr);
//
//
//        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
//        StringBuilder stringBuilder = new StringBuilder();
//        String str;
//        while ((str = in.readLine()) != null) {
//            stringBuilder.append(str);
//        }
//
//        in.close();
//
//        return gson.fromJson(stringBuilder.toString(), MovieData.class);
//    }
//
//    private static void addTitles(MovieData movieData, List<String> titles) {
//        for (MovieData.Data datum : movieData.data) {
//            titles.add(datum.Title);
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        String subStr = "spiderman";
//        String[] movieTitles = getMovieTitles(subStr);
//        for (String movieTitle : movieTitles) {
//            System.out.println(movieTitle);
//        }
//    }
}
