import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] W;
    static int[][] dp;
    static final int INF = 16000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][1 << N];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }

        System.out.println(dfs(0, 1));
    }

    static int dfs(int now, int visited) {
        // 모두 방문
        if(visited == (1 << N) - 1) {
            if(W[now][0] == 0) return INF;
            return W[now][0];
        }

        if(dp[now][visited] != -1) return dp[now][visited];
        dp[now][visited] = INF;

        for(int i = 0; i < N; i++) {
            if((visited & (1 << i)) == 0 && W[now][i] != 0) {
                dp[now][visited] = Math.min(dp[now][visited], W[now][i] + dfs(i, visited | (1 << i)));
            }
        }
        return dp[now][visited];
    }
}


