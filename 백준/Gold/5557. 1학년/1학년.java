import java.io.*;
import java.util.*;

public class Main {

    static long[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] lst = new int[N];
        dp = new long[N][N][21];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            lst[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][0][lst[0]] = 1;

        for(int i = 1; i < N - 1; i++) {
            for(int j = 0; j < 21; j++) {
                if(dp[0][i - 1][j] != 0) {
                    if(j + lst[i] <= 20) {
                        dp[0][i][j + lst[i]] += dp[0][i - 1][j];
                    }

                    if(j - lst[i] >= 0) {
                        dp[0][i][j - lst[i]] += dp[0][i - 1][j];
                    }
                }
            }
        }

        System.out.println(dp[0][N - 2][lst[N - 1]]);
    }
}