import java.util.*;
class Solution {
    
    static int answer = Integer.MAX_VALUE;
    static int[][] status;
    
    public int solution(int[][] clockHands) {
        int[] rotate = new int[clockHands.length];
        status = new int[clockHands.length][clockHands[0].length];
        dfs(0, rotate, clockHands);
        return answer;
    }
    
    static void dfs(int cur, int[] rotate, int[][] clockHands) {
        if(cur == rotate.length) {
            for(int i = 0; i < clockHands.length; i++) {
                for(int j = 0; j < clockHands[0].length; j++) {
                    status[i][j] = clockHands[i][j];
                }
            }
            int num = 0;
            for(int i = 0; i < clockHands.length; i++) {
                r(0, i, rotate[i]);
                num += rotate[i];
            }
            
            for(int i = 1; i < clockHands.length; i++) {
                for(int j = 0; j < clockHands[0].length; j++) {
                    if(status[i - 1][j] != 0) {
                        num += 4 - status[i - 1][j];
                        r(i, j, 4 - status[i - 1][j]);
                    }
                }
            }
            
            boolean zero = true;
            for(int i = 0; i < clockHands.length; i++) {
                for(int j = 0; j < clockHands[0].length; j++) {
                    // System.out.println(Arrays.toString(status[i]));
                    if(status[i][j] != 0) {
                        zero = false;
                    }
                }
                // System.out.println(num);
                
            }
            if(zero)
                answer = Math.min(answer, num);
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            rotate[cur] = i;
            dfs(cur + 1, rotate, clockHands);
        }
    }
    
    static void r(int i, int j, int rr) {
        status[i][j] = (status[i][j] + rr) % 4;
        if(i != 0) status[i - 1][j] = (status[i - 1][j] + rr) % 4;
        if(j != 0) status[i][j - 1] = (status[i][j - 1] + rr) % 4;
        if(i != status.length - 1) status[i + 1][j] = (status[i + 1][j] + rr) % 4;
        if(j != status[0].length - 1) status[i][j + 1] = (status[i][j + 1] + rr) % 4;
    }
}