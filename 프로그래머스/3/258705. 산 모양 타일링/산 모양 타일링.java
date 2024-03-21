import java.util.*;
class Solution {
    
    static int[][] dp;
    
    public int solution(int n, int[] tops) {
        
        dp = new int[n][2];
        
        if(tops[0] == 1) {
            // 안넘어온 경우
            dp[0][0] = 3;
            // 넘어온 경우
            dp[0][1] = 1;
        } else {
            dp[0][0] = 2;
            dp[0][1] = 1;
        }
        
        for(int i = 1; i < n; i++) {
            // 위에 있는 경우
            if(tops[i] == 1) {
                // 안넘어가는 경우
                dp[i][0] = (dp[i - 1][0]*3 + dp[i - 1][1]*2) % 10007;
                // 넘어가는 경우
                dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) % 10007;
            } else {
                dp[i][0] = (dp[i - 1][0]*2 + dp[i - 1][1]) % 10007;
                dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) % 10007;
            }
        }
        
        return (dp[n - 1][0] + dp[n - 1][1]) % 10007;
    }
}