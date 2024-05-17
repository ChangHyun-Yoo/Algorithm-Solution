import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N == 1) {
            System.out.println(1);
            return;
        }

        if(N == 2) {
            System.out.println(3);
            return;
        }

        int[] dp = new int[N];
        dp[0] = 1;
        dp[1] = 3;

        for(int i = 2; i < N; i++) {
            dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007;
        }

        System.out.println(dp[N - 1]);
    }

}
