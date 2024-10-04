class Solution {
    
    public int solution(int sticker[]) {
        int[][] dp = new int[sticker.length][2];
        
        if(sticker.length == 1) return sticker[0];
        
        int answer = Integer.MIN_VALUE;
        
        // 첫번 째를 뜯는 경우
        for(int i = 0; i < dp.length - 1; i++) {
            if(i == 0) dp[i][0] = sticker[i];
            else if(i == 1) dp[i][0] = sticker[i];
            else if(i == 2) dp[i][0] = sticker[i] + dp[i - 2][0];
            else {
                dp[i][0] = Math.max(dp[i - 2][0], dp[i - 3][0]) + sticker[i];
            }
            
            answer = Math.max(answer, dp[i][0]);
        }
        
        // 두번 째를 뜯는 경우
        for(int i = 1; i < dp.length; i++) {
            if(i == 1) dp[i][1] = sticker[i];
            else if(i == 2) dp[i][1] = sticker[i];
            else if(i == 3) dp[i][1] = sticker[i] + dp[i - 2][1];
            else {
                dp[i][1] = Math.max(dp[i - 2][1], dp[i - 3][1]) + sticker[i];
            }
            
            answer = Math.max(answer, dp[i][1]);
        }
        
        return answer;
    }
}