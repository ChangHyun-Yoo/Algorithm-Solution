import java.util.*;
class Solution {
    
    static final int MAX = Integer.MAX_VALUE;
    
    public int solution(int alp, int cop, int[][] problems) {
        int minAlp = 0;
        int minCop = 0;
        for(int[] problem: problems) {
            minAlp = Math.max(minAlp, problem[0]);
            minCop = Math.max(minCop, problem[1]);
        }
        
        int[][] dp = new int[minAlp + 1][minCop + 1];
        for(int[] d: dp) {
            Arrays.fill(d, MAX);
        }
        
        dp[Math.min(alp, minAlp)][Math.min(cop, minCop)] = 0;
        for(int i = 0; i < minAlp + 1; i++) {
            for(int j = 0; j < minCop + 1; j++) {
                
                if(dp[i][j] != MAX) {
                    for(int k = 0; k < problems.length; k++) {
                        int[] problem = problems[k];
                        
                        if(i < minAlp)
                            dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                        
                        if(j < minCop)
                            dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                        
                        if(i >= problem[0] && j >= problem[1]) {
                            int newI = Math.min(i + problem[2], minAlp);
                            int newJ = Math.min(j + problem[3], minCop);
                            dp[newI][newJ] = Math.min(dp[newI][newJ], dp[i][j] + problem[4]);
                        }
                        
                        
                    }
                }
            }
        }
        
        return dp[minAlp][minCop];
    }
}