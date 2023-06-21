import java.io.*;
import java.util.*;

public class Main {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        dp = new int[11];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i < 11; i++) {
            dp[i] = dp(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
        }
        System.out.println(sb);
    }

    static int dp(int n) {
        if(dp[n] != 0) return dp[n];

        int answer = 0;
        for(int i = 1; i <= 3 && i <= n; i++) {
            answer += dp(n - i);
        }
        return answer;
    }
}