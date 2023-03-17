import java.io.*;
import java.util.*;

public class Main {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        for(int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int time = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if(n == 0) {
                dp[i] = time;
            } else {
                for(int j = 0; j < n; j++) {
                    int l = Integer.parseInt(st.nextToken());
                    if(dp[i] < time + dp[l]) {
                        dp[i] = time + dp[l];
                    }
                }
            }
        }

        int answer = 0;
        for(int i: dp) {
            answer = Math.max(i, answer);
        }
        System.out.println(answer);
    }
}
