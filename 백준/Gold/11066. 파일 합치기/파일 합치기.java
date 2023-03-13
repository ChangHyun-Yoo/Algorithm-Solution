import java.io.*;
import java.util.*;

public class Main {

    static int[][] dp;
    static int[][] sums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] nums = new int[K];

            for(int j = 0; j < K; j++) {
                nums[j] = Integer.parseInt(st.nextToken());
            }

            dp = new int[K + 1][K + 1];
            sums = new int[K + 1][K + 1];
            for(int[] s: sums) {
                Arrays.fill(s, -1);;
            }
            for(int j = 1; j < K + 1; j++) {
                dp[j][j] = nums[j - 1];
                sums[j][j] = 0;
            }

            for(int length = 1; length < K; length++) {
                for(int k = 1; k + length <= K; k++) {
                    if(length == 1) {
                        dp[k][k + length] = dp[k][k] + dp[k + length][k + length];
                        sums[k][k + length] = dp[k][k + length];
                    } else {
                        int min = Integer.MAX_VALUE;
                        int index = 0;
                        for(int l = 0; l < length; l++) {
                            if(sums[k][k + l] + sums[k + l + 1][k + length] < min) {
                                min = sums[k][k + l] + sums[k + l + 1][k + length];
                                index = l;
                            }
                        }
                        dp[k][k + length] = dp[k][k + index] + dp[k + index + 1][k + length];
                        sums[k][k + length] = dp[k][k + length] + sums[k][k + index] + sums[k + index + 1][k + length];
                    }
                }
            }

            sb.append(sums[1][K]).append('\n');
        }
        System.out.println(sb);
    }

}
