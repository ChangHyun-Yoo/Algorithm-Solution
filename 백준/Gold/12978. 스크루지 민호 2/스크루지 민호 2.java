import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> roads = new ArrayList<>();
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1][2];
        visited = new boolean[N + 1];
        for(int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            roads.get(s).add(e);
            roads.get(e).add(s);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int i) {
        visited[i] = true;

        int c = 0;
        int nc = 0;
        for(int next: roads.get(i)) {
            if(!visited[next]) {
                dfs(next);
                c += Math.min(dp[next][0], dp[next][1]);
                nc += dp[next][1];
            }
        }

        dp[i][1] = c + 1;
        dp[i][0] = nc;
    }
}