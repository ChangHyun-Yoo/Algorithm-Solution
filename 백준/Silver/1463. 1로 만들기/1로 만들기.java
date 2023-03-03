import java.io.*;
import java.util.*;

public class Main {

    static int[] dp = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 1) {
            System.out.println(0);
            return;
        }
        dp[2] = 1;
        dp[3] = 1;
        System.out.println(cal(N));
    }

    private static int cal(int n) {
        if(dp[n] != 0) {
            return dp[n];
        }

        int num = 0;
        if(n % 6 == 0) {
            num = Math.min(cal(n / 2), Math.min(cal(n / 3), cal(n - 1))) + 1;
        } else if(n % 2 == 0) {
            num = Math.min(cal(n / 2), cal(n - 1)) + 1;
        } else if(n % 3 == 0) {
            num = Math.min(cal(n / 3), cal(n - 1)) + 1;
        } else {
            num = cal(n - 1) + 1;
        }

        dp[n] = num;
        return num;
    }
}
