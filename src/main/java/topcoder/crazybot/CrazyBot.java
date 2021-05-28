package topcoder.crazybot;

import java.util.Scanner;

public class CrazyBot {
    static int[] vx = {1, 0, -1, 0};
    static int[] vy = {0, -1, 0, 1};

    static int[][] flag = new int[30][30];
    static double[] prob = new double[4];

    static int successCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int east = sc.nextInt();
        int west = sc.nextInt();
        int south = sc.nextInt();
        int north = sc.nextInt();
        System.out.println(CrazyBot.getProbability(n, east, west, south, north));
    }

    private static double getProbability(int n, int east, int west, int south, int north) {
        prob[0] = (double)east/100;
        prob[1] = (double)west/100;
        prob[2] = (double)south/100;
        prob[3] = (double)north/100;

        dfs(15, 15, n);
        return successCount / Math.pow(4, n);
    }

    static double dfs(int x, int y, int n) {
        if (flag[x][y] == 1) {
            return 0;
        }
        if (n <= 0) {
            return 1;
        }
        double ret = 0;

        flag[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            ret+=dfs(x + vx[i], y + vy[i], n - 1)*prob[i];
        }

        return ret;
    }
}
