package exercise.kakaoblind2018.matchingscroe;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 1. 페이지를 읽어서 점수를 반환해주는 객체 하나 (정규표현식?)
 * 각 페이지의 1) 기본점수 2) 외부 링크 수와 그 외부 링크가 현재 주어진 페이지라면 그 페이지 인덱스까지
 * 2. 받은 점수를 이용해서 계산하고 인덱스를 구하는 객체
 * <p>
 * cf) content meta tag 안에 있는 url이 해당 페이지의 url이다.
 */
class Page {
    String html;
    Url url;
    int index;
    double basicScore;
    double externalLinkCountScore;
    Set<Page> pageThatLinkedThis;
    double linkScore;

    Page(final String html, final Url url, final int index, final int basicScore) {
        this.html = html;
        this.url = url;
        this.index = index;
        this.basicScore = basicScore;
        externalLinkCountScore = 0;
        pageThatLinkedThis = new HashSet<>();
        linkScore = 0;
    }

    void calcLinkScore() {
        if (linkScore != 0) {
            throw new RuntimeException(index + " : 링크 점수 이미 계산한거 같은데 왜 돌려");
        }

        linkScore = pageThatLinkedThis.stream()
                .mapToDouble(p -> p.basicScore / p.externalLinkCountScore)
                .sum();
    }

    double getTotalMatchingScore() {
//        System.out.println(index + " : " + (basicScore + linkScore));
        return basicScore + linkScore;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Page page = (Page) o;

        return Objects.equals(url, page.url);
    }

    @Override
    public int hashCode() {
        return url != null ? url.hashCode() : 0;
    }

    static class Url {
        public String value;

        Url(final String value) {
            this.value = value;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            final Url url = (Url) o;

            return Objects.equals(value, url.value);

        }

        @Override
        public int hashCode() {
            return value != null ? value.hashCode() : 0;
        }
    }

    @Override
    public String toString() {
        return "Page{" +
                "url=" + url.value +
                ", index=" + index +
                ", basicScore=" + basicScore +
                ", externalLinkCountScore=" + externalLinkCountScore +
                ", pageThatLinkedThis.size()=" + pageThatLinkedThis.size() +
                ", linkScore=" + linkScore +
                '}';
    }
}

class PageDataExtractor {
    private static final Pattern URL_PATTERN = Pattern.compile("<meta property=\"og:url\" content=\"https://(.+?)\"/>");
    private static final Pattern EXTERNAL_LINK = Pattern.compile("<a href=\"https://(.+?)\">");

    Map<Page.Url, Page> getPageData(final String word, final String[] pages) {

        final Map<Page.Url, Page> pageMap = new HashMap<>();

        setPageMap(word, pages, pageMap);

        for (final Map.Entry<Page.Url, Page> urlPageEntry : pageMap.entrySet()) {
            setExternalLink(pageMap, urlPageEntry.getValue());
        }

        return pageMap;
    }

    private void setPageMap(final String word, final String[] pages, final Map<Page.Url, Page> pageMap) {
        for (int i = 0; i < pages.length; i++) {
            Page.Url url = getUrl(pages[i]);
//            if (url != null) {
//                System.out.println("url.value = " + url.value);
//            }

            int basicScore = getBasicScore(word, pages[i]);
//            System.out.println("basicScore = " + basicScore);

            pageMap.put(url, new Page(pages[i], url, i, basicScore));
        }
    }


    private Page.Url getUrl(String page) {
        Matcher matcher = URL_PATTERN.matcher(page);
        if (matcher.find()) {
            final String strUrl = matcher.group(1);
            return new Page.Url(strUrl);
        }

        return null;
    }

    private int getBasicScore(String word, String page) {
        int basicScore = 0;
        page = page.toLowerCase();
        int find = page.indexOf(word);
        while (find != -1) {
            Character[] wordBorder = {page.charAt(find - 1), page.charAt(find + word.length())};
            if (Arrays.stream(wordBorder).noneMatch(ch -> ch >= 'a' && ch <= 'z'))
                basicScore++;
            find = page.indexOf(word, find + 1);
        }

        return basicScore;
    }

    private void setExternalLink(Map<Page.Url, Page> pageMap, Page page) {
        Matcher matcher = EXTERNAL_LINK.matcher(page.html);

        //해당 페이지에서 링크를 찾았으면 해당 페이지의 링크카운트를 하나 증가시키고,
        //그 링크가 현재 페이지맵에 있는지 확인하고 잇다면, 그 페이지의 외부 링크로 넣어준다.
        while (matcher.find()) {
            String link = matcher.group(1);
            page.externalLinkCountScore++;

            final Page.Url url = new Page.Url(link);
            if (pageMap.containsKey(url)) {
                final Page get = pageMap.get(url);
                get.pageThatLinkedThis.add(page);
            }
        }
    }
}

class Solution {
    private static final int MAX_PAGE_ARRAY_SIZE = 20;

    public int solution(String word, String[] pages) {
        PageDataExtractor pageDataExtractor = new PageDataExtractor();
        final Map<Page.Url, Page> pageData = pageDataExtractor.getPageData(word.toLowerCase(), pages);

        calcTotalLinkScore(pageData);

        for (final Map.Entry<Page.Url, Page> urlPageEntry : pageData.entrySet()) {
            System.out.println("urlPageEntry.getValue().toString() = " + urlPageEntry.getValue().toString());
        }

        Page highestScorePage = getHighestScorePage(pageData);

        return highestScorePage.index;
    }

    private Page getHighestScorePage(final Map<Page.Url, Page> pageData) {
        Page highestScorePage = new Page(null, null, MAX_PAGE_ARRAY_SIZE, -1);

        for (final Map.Entry<Page.Url, Page> urlPageEntry : pageData.entrySet()) {
            final Page page = urlPageEntry.getValue();
            if (page.getTotalMatchingScore() > highestScorePage.getTotalMatchingScore()) {
                highestScorePage = page;
                continue;
            }

            if (page.getTotalMatchingScore() == highestScorePage.getTotalMatchingScore()) {
                highestScorePage = page.index < highestScorePage.index ? page : highestScorePage;
            }
        }
        return highestScorePage;
    }

    private void calcTotalLinkScore(final Map<Page.Url, Page> pageData) {
        pageData.keySet().forEach(p -> pageData.get(p).calcLinkScore());
    }
}

public class 매칭점수 {
    public static void main(String[] args) {
        String word = "Muzi";
        String[] pages = {
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>",
                "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"};

        Solution solution = new Solution();
        System.out.println("solution.solution(null, null) = " + solution.solution(word, pages));
    }
}


//    기본점수 및 외부 링크수는 아래와 같다.
//
//        a.com의 기본점수는 3, 외부 링크 수는 1개
//        b.com의 기본점수는 1, 외부 링크 수는 2개
//        c.com의 기본점수는 1, 외부 링크 수는 1개
//        링크점수는 아래와 같다.
//
//        a.com의 링크점수는 b.com으로부터 0.5점, c.com으로부터 1점
//        b.com의 링크점수는 a.com으로부터 3점
//        c.com의 링크점수는 b.com으로부터 0.5점
//        각 웹 페이지의 매칭 점수는 다음과 같다.
//
//        a.com : 4.5 점
//        b.com : 4 점
//        c.com : 1.5 점

//    결과를 돌려줄때, 동일한 매칭점수를 가진 웹페이지가 여러 개라면 그중 index 번호가 가장 작은 것를 리턴한다
//즉, 웹페이지가 세개이고, 각각 매칭점수가 3,1,3 이라면 제일 적은 index 번호인 0을 리턴하면 된다.


//<html lang="ko" xml:lang="ko" xmlns="http://www.w3.org/1999/xhtml">
//<head>
//<meta charset="utf-8">
//<meta property="og:url" content="https://a.com"/>
//</head>
//<body>
//Blind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit.
//<a href="https://b.com"> Link to b </a>
//</body>
//</html>