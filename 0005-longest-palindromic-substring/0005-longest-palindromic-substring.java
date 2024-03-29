import java.util.*;
class Solution {
    
    public String longestPalindrome(String s) {
        char[] chs = s.toCharArray();
        boolean[][] dp = new boolean[chs.length][chs.length];
        
        String answer = s.substring(0, 1);
        
        for(int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }
        for(int i = 0; i < dp.length - 1; i++) {
            if(chs[i] == chs[i + 1]) {
                dp[i][i + 1] = true;
                if(answer.length() < 2)
                    answer = s.substring(i, i + 2);
            }
        }
        for(int i = 2; i < chs.length; i++) {
            for(int j = 0; j + i < chs.length; j++) {
                if(chs[j] == chs[j + i] && dp[j + 1][j + i - 1]) {
                    dp[j][j + i] = true;
                    if(answer.length() < i + 1)
                        answer = s.substring(j, j + i + 1);
                }
            }
        }
        
        
        return answer;
    }
}