import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N][H + 1];
        dp[0][0] = 1;
        for(int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            if(i != 0) {
                for(int j = 0; j < H + 1; j++) {
                    dp[i][j] = dp[i - 1][j];
                }
            }

            while(st.hasMoreTokens()) {
                int a = Integer.parseInt(st.nextToken());

                if(i == 0) {
                    if(a <= H) dp[i][a] = 1;
                } else {
                    for(int j = 0; j + a < H + 1; j++) {
                        dp[i][j + a] += dp[i - 1][j];
                        dp[i][j + a] %= 10007;
                    }
                }
            }
        }

        System.out.println(dp[N - 1][H]);
    }
}