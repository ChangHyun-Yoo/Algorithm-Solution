import java.util.*;
class Solution {
    
    static int[][] dp;
    
    public int[] solution(int target) {
        int[] answer = new int[2];
        
        // 0->개수. 1->불 개수
        dp = new int[2][100001];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        Arrays.fill(dp[1], 0);
        dp[0][0] = 0;
        dp[1][0] = 0;
        
        dp(target);
        
        answer[0] = dp[0][target];
        answer[1] = dp[1][target];
        
        return answer;
    }
    
    static int[] dp(int target) {
        int[] result = new int[2];
        
        if(dp[0][target] != Integer.MAX_VALUE) {
            result[0] = dp[0][target];
            result[1] = dp[1][target];
            return result;
        }
        
        if(target >= 50) {
            dp(target - 50);
            if(dp[0][target] > dp[0][target - 50] + 1) {
                dp[0][target] = dp[0][target - 50] + 1;
                dp[1][target] = dp[1][target - 50] + 1;
            } else if(dp[0][target] == dp[0][target - 50] + 1) {
                if(dp[1][target] < dp[1][target - 50] + 1) {
                    dp[1][target] = dp[1][target - 50] + 1;
                }
            }
        }
        
        for(int i = 1; i <= 20; i++) {
            if(target >= i) {
                dp(target - i);
                if(dp[0][target] > dp[0][target - i] + 1) {
                    dp[0][target] = dp[0][target - i] + 1;
                    dp[1][target] = dp[1][target - i] + 1;
                } else if(dp[0][target] == dp[0][target - i] + 1) {
                    if(dp[1][target] < dp[1][target - i] + 1) {
                        dp[1][target] = dp[1][target - i] + 1;
                    }
                }
            }
            
            if(target >= 2 * i) {
                dp(target - 2 * i);
                if(dp[0][target] > dp[0][target - 2 * i] + 1) {
                    dp[0][target] = dp[0][target - 2 * i] + 1;
                    dp[1][target] = dp[1][target - 2 * i];
                } else if(dp[0][target] == dp[0][target - 2 * i] + 1) {
                    if(dp[1][target] < dp[1][target - 2 * i]) {
                        dp[1][target] = dp[1][target - 2 * i];
                    }
                }
            }
            
            if(target >= 3 * i) {
                dp(target - 3 * i);
                if(dp[0][target] > dp[0][target - 3 * i] + 1) {
                    dp[0][target] = dp[0][target - 3 * i] + 1;
                    dp[1][target] = dp[1][target - 3 * i];
                } else if(dp[0][target] == dp[0][target - 3 * i] + 1) {
                    if(dp[1][target] < dp[1][target - 3 * i]) {
                        dp[1][target] = dp[1][target - 3 * i];
                    }
                }
            }
        }
        return result;
    }
}