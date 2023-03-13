import java.io.*;
import java.util.*;

public class Main {

    static int[][] things;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        things = new int[N][2];
        dp = new int[N + 1][K + 1];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            things[i][0] = Integer.parseInt(st.nextToken());
            things[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(things, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for(int i = 1; i < dp.length; i++) {
            for(int w = 1; w < dp[0].length; w++) {
                int wi = things[i - 1][0];
                int vi = things[i - 1][1];

                if(wi > w) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], vi + dp[i - 1][w - wi]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
