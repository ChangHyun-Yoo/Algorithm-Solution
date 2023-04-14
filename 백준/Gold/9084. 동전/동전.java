import java.io.*;
import java.util.*;

public class Main {

    static int[] coin;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {

            int N = Integer.parseInt(br.readLine());
            coin = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int n = 0; n < N; n++) {
                coin[n] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            dp = new int[N][M + 1];
            for(int i = 0; i < N; i++) {
                dp[i][0] = 1;
            }

            for(int i = 0; i < M + 1; i++) {
                if(i % coin[0] == 0) dp[0][i] = 1;
            }

            for(int i = 1; i < N; i++) {
                for(int j = 1; j <= M; j++) {
                    for(int k = 0; coin[i] * k <= j; k++) {
                        dp[i][j] += dp[i - 1][j - coin[i] * k];
                    }
                }
            }
            sb.append(dp[N - 1][M]).append('\n');
        }
        System.out.print(sb);
    }
}