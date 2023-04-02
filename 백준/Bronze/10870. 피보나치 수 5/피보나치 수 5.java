import java.io.*;
import java.util.*;

public class Main {

    static int[] dp = new int[21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        dp(20);

        System.out.println(dp[n]);
    }

    static int dp(int num) {
        if(dp[num] != -1) return dp[num];

        int answer = dp(num - 2) + dp(num - 1);
        dp[num] = answer;
        return answer;
    }
}

