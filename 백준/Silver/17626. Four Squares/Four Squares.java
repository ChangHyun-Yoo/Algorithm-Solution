import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[50001];

        for(int i = 1; i * i < 50001; i++) {
            dp[i * i] = 1;
        }

        for(int i = 1; i < 50001; i++) {
            if(dp[i] == 0) {
                int max = (int) Math.sqrt(i);
                int min = Integer.MAX_VALUE;

                for(int j = 1; j <= max; j++) {
                    if(min > dp[i - j * j] + 1) {
                        min = dp[i - j * j] + 1;
                    }
                }

                dp[i] = min;
            }
        }

        System.out.println(dp[n]);
    }
}