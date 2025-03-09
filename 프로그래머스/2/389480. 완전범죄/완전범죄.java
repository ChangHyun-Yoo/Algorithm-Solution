import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = Integer.MAX_VALUE;
        int[][] dp = new int[info.length + 1][m];
        
        for(int[] d: dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        
        dp[0][0] = 0;
        for(int i = 0; i < info.length; i++) {
            for(int j = 0; j < m; j++) {
                if(dp[i][j] != Integer.MAX_VALUE) {
                    int A = info[i][0];
                    int B = info[i][1];
                    
                    dp[i + 1][j] = Math.min(dp[i][j] + A, dp[i + 1][j]);
                    if(j + B < m) {
                        dp[i + 1][j + B] = Math.min(dp[i + 1][j + B], dp[i][j]);
                    }
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            min = Math.min(min, dp[info.length][i]);
        }
        
        return min >= n ? -1 : min;
    }
}