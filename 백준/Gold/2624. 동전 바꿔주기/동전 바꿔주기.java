import java.io.*;
import java.util.*;

public class Main {

    static int T;
    static int k;
    static int[][] dp;
    static Coin[] coins;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        dp = new int[k][T + 1];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        coins = new Coin[k];

        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int p = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            coins[i] = new Coin(p, n);
        }

        Arrays.sort(coins);
        for(int i = 0; i <= coins[0].count && i * coins[0].value <= T; i++) {
            dp[0][i * coins[0].value] = 1;
        }

        System.out.println(dp(T, k - 1));
    }

    static class Coin implements Comparable<Coin> {
        int value;
        int count;

        public Coin(int value, int count) {
            this.value = value;
            this.count = count;
        }

        public int compareTo(Coin c) {
            return this.value - c.value;
        }
    }

    static int dp(int remain, int coin) {
        if(coin == 0)
            if(dp[coin][remain] != -1) return dp[coin][remain];
            else return 0;

        if(dp[coin][remain] != -1) return dp[coin][remain];

        int answer = 0;
        for(int i = 0; i <= coins[coin].count && i * coins[coin].value <= remain; i++) {
            answer += dp(remain - i * coins[coin].value, coin - 1);
        }
        dp[coin][remain] = answer;
        return answer;
    }
}