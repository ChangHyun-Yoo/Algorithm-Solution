import java.io.*;
import java.util.*;

public class Main {

    static int[] weights;
    static List<List<Integer>> roads = new ArrayList<>();
    static boolean[] visited;
    static int[][] dp;
    static List<Integer> selected = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        weights = new int[n + 1];
        visited = new boolean[n + 1];
        dp = new int[n + 1][2];
        for(int i = 0; i < n + 1; i++) {
            roads.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            weights[i + 1] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            roads.get(a).add(b);
            roads.get(b).add(a);
        }

        dfs(1);
        StringBuilder sb = new StringBuilder();
        sb.append(Math.max(dp[1][0], dp[1][1])).append('\n');
        visited = new boolean[n + 1];
        trace(1, Math.max(dp[1][0], dp[1][1]));
        Collections.sort(selected);
        for(int s: selected) {
            sb.append(s + " ");
        }

        System.out.println(sb);
    }

    static void dfs(int cur) {
        visited[cur] = true;

        int max = 0;
        int no = 0;
        for(int next: roads.get(cur)) {
            if(!visited[next]) {
                dfs(next);
                max += Math.max(dp[next][0], dp[next][1]);
                no += dp[next][0];
            }
        }

        dp[cur][0] = max;
        dp[cur][1] = no + weights[cur];
    }

    static void trace(int cur, int value) {
        visited[cur] = true;

        int max = 0;
        int no = 0;
        for(int next: roads.get(cur)) {
            if(!visited[next]) {
                max += Math.max(dp[next][0], dp[next][1]);
                no += dp[next][0];
            }
        }
        no += weights[cur];

        if(max == value) {
            for(int next: roads.get(cur)) {
                if(!visited[next]) {
                    trace(next, Math.max(dp[next][0], dp[next][1]));
                }
            }
        } else if(no == value) {
            selected.add(cur);
            for(int next: roads.get(cur)) {
                if(!visited[next]) {
                    trace(next, dp[next][0]);
                }
            }
        }
    }
}

