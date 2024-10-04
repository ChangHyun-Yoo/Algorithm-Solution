class Solution {
    
    static final long MOD = 1000000007;
    
    public int solution(int n) {
        
        if(n % 2 == 1) return 0;
        
        long[] dp = new long[n + 1];
        
        dp[2] = 3;
        dp[4] = 11;
        
        for(int i = 6; i <= n; i += 2) {
            dp[i] = (4 * dp[i - 2] % MOD - dp[i - 4] % MOD + MOD) % MOD;
        }
        
        return (int) dp[n];
    }
}