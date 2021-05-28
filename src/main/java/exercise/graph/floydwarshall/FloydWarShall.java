package exercise.graph.floydwarshall;

/**
 * https://m.blog.naver.com/PostView.nhn?blogId=ndb796&logNo=221234427842&proxyReferer=https:%2F%2Fwww.google.com%2F
 */
public class FloydWarShall {
    public static void main(String[] args) {
        int INF = 100_000_000;
        int[][] graph = new int[][]{
                {0, 5, INF, 8},
                {7, 0, 9, INF},
                {2, INF, 0, 4},
                {INF, INF, 3, 0},
        };

        for (int throughNode = 0; throughNode < graph.length; throughNode++) {
            //throughNode 거쳐가는 경우
            //a -> b vs a -> node -> b
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[i].length; j++) {
                    if (i == throughNode || j == throughNode) {
                        continue;
                    }

                    if (graph[i][j] == 0) {
                        continue;
                    }

                    graph[i][j] = Math.min(graph[i][j], graph[i][throughNode] + graph[throughNode][j]);
                }
            }
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
