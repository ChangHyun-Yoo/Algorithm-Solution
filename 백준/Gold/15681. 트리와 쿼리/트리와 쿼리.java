import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        List<List<Integer>> roads = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            roads.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            roads.get(U).add(V);
            roads.get(V).add(U);
        }

        boolean[] visited = new boolean[N + 1];
        int[] dp = new int[N + 1];

        dfs(R, visited, dp, roads);

        StringBuilder sb = new StringBuilder();
        for(int q = 0; q < Q; q++) {
            int query = Integer.parseInt(br.readLine());

            sb.append(dp[query]).append('\n');
        }
        System.out.print(sb.toString());
    }

    static int dfs(int current, boolean[] visited, int[] dp, List<List<Integer>> roads) {
        visited[current] = true;

        int num = 0;
        for(int next: roads.get(current)) {
            if(!visited[next]) num++;
        }

        if(num == 0) return dp[current] = 1;

        int value = 0;
        for(int next: roads.get(current)) {
            if(!visited[next]) {
                value += dfs(next, visited, dp, roads);
            }
        }

        return dp[current] = value + 1;
    }
}
