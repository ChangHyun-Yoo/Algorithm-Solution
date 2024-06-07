import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

    static BigInteger[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dp = new BigInteger[n + 1][m + 1];
        for(BigInteger[] d: dp) {
            Arrays.fill(d, new BigInteger("-1"));
        }

        System.out.println(com(n, m));
    }

    static BigInteger com(int n, int m) {
        if(!dp[n][m].equals(new BigInteger("-1"))) return dp[n][m];

        if(n == 1 || m == 0) return dp[n][m] = new BigInteger("1");
        if(n == m) return dp[n][m] = new BigInteger("1");

        return dp[n][m] = com(n - 1, m - 1).add(com(n - 1, m));
    }
}
