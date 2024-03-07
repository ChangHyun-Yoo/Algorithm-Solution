import java.util.*;
import java.io.*;

public class Main {

    static int[][][] dp;
    static int[][] value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dp = new int[N][M][3];
        value = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int v = Integer.parseInt(st.nextToken());
                if(i == 0) {
                    dp[i][j][0] = v;
                    dp[i][j][1] = v;
                    dp[i][j][2] = v;
                }
                value[i][j] = v;
            }
        }

        for (int i = 1; i < N; i++) {
            for(int j = 0; j < M; j++) {

                if(j == M - 1) {
                    dp[i][j][0] = Integer.MAX_VALUE;
                } else {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + value[i][j];
                }
                dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + value[i][j];
                if(j == 0) {
                    dp[i][j][2] = Integer.MAX_VALUE;
                } else {
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][0]) + value[i][j];
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < 3; j++) {
                answer = Math.min(answer, dp[N - 1][i][j]);
            }
        }
        System.out.println(answer);
    }

}