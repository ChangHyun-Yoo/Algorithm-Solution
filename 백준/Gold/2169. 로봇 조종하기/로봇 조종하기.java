import java.io.*;
import java.util.*;

public class Main {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] nums = new int[N][M];
        int[][] temp = new int[2][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][M];
        int sum = 0;
        for(int i = 0; i < M; i++) {
            sum += nums[0][i];
            dp[0][i] = sum;
        }

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(j == 0) {
                    temp[0][0] = dp[i - 1][0] + nums[i][0];
                    continue;
                }

                temp[0][j] = Math.max(dp[i - 1][j], temp[0][j - 1]) + nums[i][j];
            }

            for(int j = M - 1; j >= 0; j--) {
                if(j == M - 1) {
                    temp[1][j] = nums[i][j] + dp[i - 1][j];
                    continue;
                }

                temp[1][j] = Math.max(temp[1][j + 1], dp[i - 1][j]) + nums[i][j];
            }
            for(int k = 0; k < M; k++) {
                dp[i][k] = Math.max(temp[0][k], temp[1][k]);
            }
        }

        System.out.println(dp[N - 1][M - 1]);
    }


}
