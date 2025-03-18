import java.util.*;
class Solution {
    
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        for(int i = 0; i < dungeons.length; i++) {
            if(k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(i, dungeons, k - dungeons[i][1], 1, visited);
                visited[i] = false;
            }
        }
        
        return answer;
    }
    
    static void dfs(int current, int[][] dungeons, int k, int num, boolean[] visited) {
        answer = Math.max(answer, num);
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(i, dungeons, k - dungeons[i][1], num + 1, visited);
                visited[i] = false;
            }
        }
    }
}