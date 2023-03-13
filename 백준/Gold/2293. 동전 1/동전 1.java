import java.io.*;
import java.util.*;

public class Main {

    static int[][] dp;
    static int[] coins;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        coins = new int[n];
        for(int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins);

        dp = new int[n + 1][k + 1];

        for(int i = 1; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i < k + 1; i++) {
            if(i % coins[0] == 0) {
                dp[1][i] = 1;
            }
        }

        for(int i = 2; i < n + 1; i++) {
            for(int j = 1; j < k + 1; j++) {
                int sec = j;
                int sum = 0;
                while(sec >= 0) {
                    sum += dp[i - 1][sec];
                    sec -= coins[i - 1];
                }
                dp[i][j] = sum;
            }
        }

        System.out.println(dp[n][k]);
    }
}
