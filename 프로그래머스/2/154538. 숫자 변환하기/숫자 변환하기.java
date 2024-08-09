import java.util.*;
class Solution {
    
    static int[] dp;
    
    public int solution(int x, int y, int n) {
        dp = new int[y + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;
        
        for(int i = x + 1; i <= y; i++) {
            if(i % 2 == 0 && dp[i / 2] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if(i % 3 == 0 && dp[i / 3] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if(i - n >= 0 && dp[i - n] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - n] + 1);
            }
        }
        
        return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
    }
}