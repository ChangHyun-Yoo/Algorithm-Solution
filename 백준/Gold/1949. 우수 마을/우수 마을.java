import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> roads = new ArrayList<>();
    static int[][] dp;
    static int[] population;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        population = new int[N + 1];
        for(int i = 0; i < N; i++) {
            population[i + 1] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N + 1][2];
        for(int i =0 ; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            roads.get(a).add(b);
            roads.get(b).add(a);
        }

        dfs(1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    static void dfs(int num) {
        visited[num] = true;

        int max = 0;
        int normal = 0;
        for(int next: roads.get(num)) {
            if(!visited[next]) {
                dfs(next);
                max += Math.max(dp[next][0], dp[next][1]);
                normal += dp[next][0];
            }
        }

        dp[num][0] = max;
        dp[num][1] = normal + population[num];
    }
}

