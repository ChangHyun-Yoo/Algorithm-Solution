import java.util.*;
class Solution {
    
    static int MAX = Integer.MAX_VALUE;
    
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        temperature += 10;
        t1 += 10;
        t2 += 10;
        int[][] dp = new int[onboard.length + 1][51];
        for(int[] d: dp) {
            Arrays.fill(d, MAX);
        }
        dp[0][temperature] = 0;
        
        for(int i = 0; i < onboard.length; i++) {
            for(int j = 0; j < 51; j++) {
                if(dp[i][j] != MAX) {
                    if(i == onboard.length - 1) {
                        // 온도를 높이는 경우
                        if(j != 50)
                            dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + a);

                        // 온도가 유지되는 경우
                        dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + b);

                        // 온도를 낮추는 경우
                        if(j != 0)
                            dp[i + 1][j - 1] = Math.min(dp[i + 1][j - 1], dp[i][j] + a);

                        if(j > temperature && j != 0)
                            dp[i + 1][j - 1] = Math.min(dp[i + 1][j - 1], dp[i][j]);
                        else if(j == temperature)
                            dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);
                        else if(j < temperature && j != 50)
                            dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j]);
                    } else {
                        // 온도를 만족시켜야 하는 경우
                        if(onboard[i + 1] == 1) {
                            // 온도를 높이는 경우
                            if(j != 50 && j + 1 >= t1 && j + 1 <= t2)
                                dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + a);

                            // 온도가 유지되는 경우
                            if(j >= t1 && j <= t2)
                                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + b);

                            // 온도를 낮추는 경우
                            if(j != 0 && j - 1 >= t1 && j - 1 <= t2)
                                dp[i + 1][j - 1] = Math.min(dp[i + 1][j - 1], dp[i][j] + a);

                            if(j > temperature && j - 1 >= t1 && j - 1 <= t2 && j != 0)
                                dp[i + 1][j - 1] = Math.min(dp[i + 1][j - 1], dp[i][j]);
                            else if(j == temperature && j >= t1 && j <= t2)
                                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);
                            else if(j < temperature && j + 1 >= t1 && j + 1 <= t2 && j != 50)
                                dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j]);
                        } else {
                            // 온도를 높이는 경우
                            if(j != 50)
                                dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + a);

                            // 온도가 유지되는 경우
                            dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + b);

                            // 온도를 낮추는 경우
                            if(j != 0)
                                dp[i + 1][j - 1] = Math.min(dp[i + 1][j - 1], dp[i][j] + a);

                            if(j > temperature && j != 0)
                                dp[i + 1][j - 1] = Math.min(dp[i + 1][j - 1], dp[i][j]);
                            else if(j == temperature)
                                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);
                            else if(j < temperature && j != 50)
                                dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j]);
                        }
                    }
                }
            }
        }
        
        int answer = MAX;
        for(int i = 0; i < dp[0].length; i++) {
            answer = Math.min(answer, dp[onboard.length][i]);
        }
        return answer;
    }
}