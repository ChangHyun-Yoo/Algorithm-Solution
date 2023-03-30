import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> child = new ArrayList<>();
    static int[] dp;
    static int[] backup;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n + 1; i++) {
            child.add(new ArrayList<>());
        }
        dp = new int[n + 1];
        backup = new int[n + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i < n + 1; i++) {
            int value = Integer.parseInt(st.nextToken());
            if(value != -1) {
                child.get(value).add(i);
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int ii = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dp[ii] += w;
        }

        for(int i = 1; i < n + 1; i++) {
            if(dp[i] != 0) {
                dfs(i, dp[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < n + 1; i++) {
            if(i == n) {
                sb.append(dp[i] + backup[i]);
            } else
                sb.append(dp[i] + backup[i] + " ");
        }
        System.out.println(sb);
    }

    static void dfs(int i, int value) {
        for(int next: child.get(i)) {
            backup[next] += value;
            dfs(next, value);
        }
    }
}

