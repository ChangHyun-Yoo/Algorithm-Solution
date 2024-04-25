import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] value = new int[N];
        for(int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }
        if(N == 1) {
            System.out.println(value[0]);
            return;
        }
        // 0 -> 2개 연속, 1 -> 새로 하나
        int[][] dp = new int[N][2];
        dp[0][0] = value[0];
        dp[0][1] = value[0];
        dp[1][0] = dp[0][0] + value[1];
        dp[1][1] = value[1];

        for(int i = 2; i < N; i++) {
            dp[i][0] = dp[i - 1][1] + value[i];
            dp[i][1] = Math.max(dp[i - 2][0] + value[i], dp[i - 2][1] + value[i]);
        }

        System.out.println(Math.max(dp[N - 1][0], dp[N - 1][1]));
    }
}