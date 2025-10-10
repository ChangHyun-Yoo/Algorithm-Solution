import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());

            int[] files = new int[K];
            int[] sums = new int[K + 1];
            int[][] dp = new int[K + 1][K + 1];
            for(int[] d: dp) {
                Arrays.fill(d, Integer.MAX_VALUE);
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < K; i++) {
                files[i] = Integer.parseInt(st.nextToken());
                sums[i + 1] = sums[i] + files[i];
            }

            sb.append(dp(0, K, files, dp, sums)).append('\n');
        }

        System.out.print(sb.toString());
    }

    static int dp(int s, int e, int[] files, int[][] dp, int[] sums) {
        if(dp[s][e] != Integer.MAX_VALUE) return dp[s][e];
        if(e - s == 1) return dp[s][e] = 0;

        int min = Integer.MAX_VALUE;
        for(int i = s + 1; i < e; i++) {
            min = Math.min(min, dp(s, i, files, dp, sums) + dp(i, e, files, dp, sums) + sums[e] - sums[s]);
        }

        return dp[s][e] = min;
    }
}
