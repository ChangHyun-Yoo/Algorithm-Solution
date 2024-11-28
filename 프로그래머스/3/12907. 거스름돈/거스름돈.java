import java.util.*;
class Solution {
    
    static final int MOD = 1000000007;
    
    public int solution(int n, int[] money) {
        int[][] dp = new int[money.length][n + 1];
        
        for(int i = 0; i < money.length; i++) {
            for(int j = 0; j < n + 1; j++) {
                int m = money[i];
                if(i == 0) {
                    if(j % m == 0) dp[i][j] = 1;
                } else {
                    if(j == 0) dp[i][j] = 1;
                    else {
                        if(j >= m) {
                            dp[i][j] = (dp[i - 1][j] % MOD + dp[i][j - m] % MOD) % MOD;
                        } else {
                            dp[i][j] = dp[i - 1][j];
                        }
                    }
                }
            }
        }
        
        return dp[money.length - 1][n];
    }
}