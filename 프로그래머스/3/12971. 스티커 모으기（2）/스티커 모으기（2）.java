class Solution {
    
    static int[][] dp;
    
    public int solution(int sticker[]) {
        dp = new int[sticker.length][2];
        
        if(sticker.length == 1) return sticker[0];
        if(sticker.length == 2) return Math.max(sticker[0], sticker[1]);
        
        dp[0][0] = sticker[0];
        dp[1][0] = Math.max(sticker[0], sticker[1]);
        dp[1][1] = sticker[1];
        dp[2][1] = Math.max(sticker[1], sticker[2]);
        
        for(int i = 2; i < sticker.length - 1; i++) {
            dp[i][0] = (sticker[i] + dp[i - 2][0] > dp[i - 1][0]) ? (sticker[i] + dp[i - 2][0]): dp[i - 1][0];
        }
        for(int i = 3; i < sticker.length; i++) {
            dp[i][1] = (sticker[i] + dp[i - 2][1] > dp[i - 1][1]) ? (sticker[i] + dp[i - 2][1]): dp[i - 1][1];
        }
        
        return Math.max(dp[sticker.length - 2][0], dp[sticker.length - 1][1]);
    }
}