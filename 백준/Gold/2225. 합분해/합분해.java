import java.io.*;
import java.util.*;

public class Main {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][K + 1];

        for(int i = 0; i < N + 1; i++) {
            dp[i][1] = 1;
        }

        for(int i = 0; i < N + 1; i++) {
            for(int j = 2; j < K + 1; j++) {
                int sum = 0;
                int ii = i;
                while(ii >= 0) {
                    sum = (sum + (dp[ii][j - 1] % 1000000000)) % 1000000000;
                    ii--;
                }
                dp[i][j] = sum % 1000000000;
            }
        }

        System.out.println(dp[N][K]);
    }
}
