import java.util.*;
class Solution {
    
    static int[][] dp;
    
    public int solution(int m, int n, int[][] puddles) {
        
        dp = new int[n + 1][m + 1];
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        for(int[] p: puddles) {
            dp[p[1]][p[0]] = 0;
        }
        dp[1][1] = 1;
        
        int answer = dp(n, m);
        return answer;
    }
    
    static int dp(int n, int m) {
        if(n == 0 || m == 0) return 0;
        
        if(dp[n][m] != -1) {
            return dp[n][m];
        }
        
        return dp[n][m] = (dp(n - 1, m) + dp(n, m - 1)) % 1000000007;
    }
}