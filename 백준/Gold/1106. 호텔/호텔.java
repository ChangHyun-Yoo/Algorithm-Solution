import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] dp = new int[1101];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int man = Integer.parseInt(st.nextToken());

            if(i == 0) {
                for(int j = 0; j * man < 1101; j++) {
                    dp[j * man] = j * cost;
                }
                continue;
            }

            for(int j = 0; j < 1101; j++) {
                if(j >= man) {
                    if(dp[j] != Integer.MAX_VALUE && dp[j - man] != Integer.MAX_VALUE) {
                        dp[j] = Math.min(dp[j], dp[j - man] + cost);
                    } else if(dp[j] == Integer.MAX_VALUE && dp[j - man] != Integer.MAX_VALUE) {
                        dp[j] = dp[j - man] + cost;
                    }
                }
            }
        }

//        System.out.println(Arrays.toString(dp));
        int answer = Integer.MAX_VALUE;
        for(int i = C; i < 1101; i++) {
            answer = Math.min(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
