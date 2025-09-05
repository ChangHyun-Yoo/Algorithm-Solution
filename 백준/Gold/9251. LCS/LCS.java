import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();

        int n = first.length();
        int m = second.length();

        int[][] dp = new int[n][m];

        if(first.charAt(0) == second.charAt(0)) dp[0][0] = 1;
        for(int i = 1; i < n; i++) {
            if(first.charAt(i) == second.charAt(0) || dp[i - 1][0] == 1)
                dp[i][0] = 1;
        }
        for(int i = 1; i < m; i++) {
            if(first.charAt(0) == second.charAt(i) || dp[0][i - 1] == 1)
                dp[0][i] = 1;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                boolean check = first.charAt(i) == second.charAt(j);
                int value = dp[i - 1][j - 1];
                if(check) value++;
                dp[i][j] = Math.max(value, Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }

        System.out.println(dp[n - 1][m - 1]);
    }
}