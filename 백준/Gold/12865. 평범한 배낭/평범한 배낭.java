import java.util.*;
import java.io.*;

public class Main {

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N][K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if (i == 0) {
                for (int j = W; j < K + 1; j++) {
                    dp[i][j] = V;
                }
            } else {
                for (int j = 0; j < K + 1; j++) {
                    if(j < W) dp[i][j] = dp[i - 1][j];
                    else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W] + V);
                }
            }
        }
        System.out.println(dp[N - 1][K]);
    }
}