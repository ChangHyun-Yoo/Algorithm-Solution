import java.util.*;

class Solution {
    
    static int[][] dist;
    
    public int solution(int n, int[][] results) {
        
        dist = new int[n][n];
        
        for(int[] result: results) {
            dist[result[0] - 1][result[1] - 1] = 1;
        }
        
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(dist[i][j] == 0 &&
                      dist[i][k] == 1 &&
                      dist[k][j] == 1) {
                        dist[i][j] = 1;
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < n; i++) {
            int s = 0;
            int r = 0;
            for(int j = 0; j < n; j++) {
                if(dist[j][i] == 1) s++;
                if(dist[i][j] == 1) r++;
            }
            if(s + r == n - 1) answer++;
        }
        return answer;
    }
}