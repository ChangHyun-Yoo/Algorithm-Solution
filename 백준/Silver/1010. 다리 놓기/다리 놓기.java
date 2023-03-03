import java.io.*;
import java.util.*;

public class Main {

    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int west = Integer.parseInt(st.nextToken());
            int east = Integer.parseInt(st.nextToken());

            sb.append(com(east, west)).append('\n');
        }
        System.out.println(sb);
    }

    private static int com(int n, int r) {
        if(dp[n][r] != 0) {
            return dp[n][r];
        }

        if(n == r) {
            dp[n][r] = 1;
            return 1;
        } else if(r == 1) {
            dp[n][r] = n;
            return n;
        } else {
            int num = com(n - 1, r - 1) + com(n - 1, r);
            dp[n][r] = num;
            return num;
        }
    }
}
