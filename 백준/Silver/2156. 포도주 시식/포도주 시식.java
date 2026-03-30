import java.util.*;
import java.io.*;

public class Main {

    static int DIV = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] podo = new int[N];
        for(int i = 0; i < N; i++) {
            podo[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[3][N];

        for(int i = 0; i < N; i++) {
            if(i == 0) {
                dp[1][i] = podo[i];
            } else {
                dp[0][i] = Math.max(dp[0][i - 1], Math.max(dp[1][i - 1], dp[2][i - 1]));
                dp[1][i] = dp[0][i - 1] + podo[i];
                dp[2][i] = dp[1][i - 1] + podo[i];
            }
        }

        int answer = -1;
        for(int[] d: dp) {
            for(int dd: d) {
                answer = Math.max(answer, dd);
            }
        }

        System.out.println(answer);
    }
}
