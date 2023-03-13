import java.io.*;
import java.util.*;

public class Main {

    static int[] dp;
    static Set<Integer> coinSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        coinSet = new HashSet<>();

        for(int i = 0; i < n; i++) {
            coinSet.add(Integer.parseInt(br.readLine()));
        }

        int[] coins = new int[coinSet.size()];
        int idx = 0;
        for(int s: coinSet) {
            coins[idx] = s;
            idx++;
        }
        Arrays.sort(coins);
        n = coins.length;
        dp = new int[k + 1];
        for(int i = 1; i < k + 1; i++) {
            dp[i] = 10001;
        }

        for(int i = 0; i < n; i++) {
            for(int j = coins[i]; j < k + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        System.out.println(dp[k] == 10001 ? -1 : dp[k]);
    }
}
