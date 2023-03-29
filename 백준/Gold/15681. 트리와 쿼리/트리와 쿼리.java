import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> roads = new ArrayList<>();
    static boolean[] visited;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];
        dp = new int[N + 1];
        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            roads.get(a).add(b);
            roads.get(b).add(a);
        }
        dp(R);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q; i++) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
        }
        System.out.println(sb);
    }

    static int dp(int n) {
        visited[n] = true;

        int answer = 0;
        for(int next: roads.get(n)) {
            if(!visited[next]) {
                answer += dp(next);
            }
        }

        if(answer == 0) {
            dp[n] = 1;
        } else {
            dp[n] = answer + 1;
        }

        return dp[n];
    }
}

