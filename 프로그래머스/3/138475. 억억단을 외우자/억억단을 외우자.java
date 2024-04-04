import java.util.*;
class Solution {
    public int[] solution(int e, int[] starts) {
        int[] yaksu = new int[5000001];
        int[] answer = new int[starts.length];
        
        for(int i = 1; i < yaksu.length; i++) {
            for(int j = 1; i * j < yaksu.length; j++) {
                yaksu[i * j]++;
            }
        }
        
        int[] dp = new int[e + 1];
        int max = yaksu[e];
        dp[e] = e;
        
        for(int i = e - 1; i >= 1; i--) {
            if(yaksu[i] >= max) {
                max = yaksu[i];
                dp[i] = i;
            } else {
                dp[i] = dp[i + 1];
            }
        }
        
        for(int i = 0; i < starts.length; i++) {
            answer[i] = dp[starts[i]];
        }
        
        return answer;
    }
}