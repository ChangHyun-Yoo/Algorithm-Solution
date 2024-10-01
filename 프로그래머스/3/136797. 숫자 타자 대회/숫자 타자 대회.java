import java.util.*;
class Solution {
    
    public int solution(String numbers) {
        int[][] roads = {
            {1,7,6,7,5,4,5,3,2,3},
            {7,1,2,4,2,3,5,4,5,6},
            {6,2,1,2,3,2,3,5,4,5},
            {7,4,2,1,5,3,2,6,5,4},
            {5,2,3,5,1,2,4,2,3,5},
            {4,3,2,3,2,1,2,3,2,3},
            {5,5,3,2,4,2,1,5,3,2},
            {3,4,5,6,2,3,5,1,2,4},
            {2,5,4,5,3,2,3,2,1,2},
            {3,6,5,4,5,3,2,4,2,1}
        };
        
        int[][][] dp = new int[10][10][numbers.length() + 1];
        for(int[][] dd: dp) {
            for(int[] d: dd) {
                Arrays.fill(d, Integer.MAX_VALUE);
            }
        }
        
        dp[4][6][0] = 0;
        
        for(int i = 1; i < dp[0][0].length; i++) {
            int next = chtoi(numbers.charAt(i - 1));
            
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k < 10; k++) {
                    if(j != k && dp[j][k][i - 1] != Integer.MAX_VALUE) {
                        // 왼쪽이 다음 위치와 같을 경우
                        if(j == next) {
                            dp[j][k][i] = Math.min(dp[j][k][i], dp[j][k][i - 1] + 1);
                        }
                        // 오른쪽이 다음 위치와 같을 경우
                        else if(k == next) {
                            dp[j][k][i] = Math.min(dp[j][k][i], dp[j][k][i - 1] + 1);
                        }
                        // 둘다 이동해야 하는 경우
                        else {
                            // 왼쪽이 이동하는 경우
                            dp[next][k][i] = Math.min(dp[next][k][i], dp[j][k][i - 1] + roads[j][next]);
                            // 오른쪽이 이동하는 경우
                            dp[j][next][i] = Math.min(dp[j][next][i], dp[j][k][i - 1] + roads[k][next]);
                        }
                    }
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                answer = Math.min(answer, dp[i][j][dp[0][0].length - 1]);
            }
        }
        
        return answer;
    }
    
    static int chtoi(char ch) {
        return (int) ch - 48;
    }
}