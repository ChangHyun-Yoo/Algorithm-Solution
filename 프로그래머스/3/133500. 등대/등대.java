import java.util.*;
class Solution {
    
    static int[][] dp;
    static List<List<Integer>> roads;
    static boolean[] visited;
    
    public int solution(int n, int[][] lighthouse) {
        dp = new int[n + 1][2];
        roads = new ArrayList<>();
        for(int i = 0; i < n + 1; i++) {
            roads.add(new ArrayList<>());
        }
        for(int i = 0; i < lighthouse.length; i++) {
            roads.get(lighthouse[i][0]).add(lighthouse[i][1]);
            roads.get(lighthouse[i][1]).add(lighthouse[i][0]);
        }
        visited = new boolean[n + 1];
        
        dfs(1);
        
        return Math.min(dp[1][0], dp[1][1]);
    }
    
    static void dfs(int current) {
        visited[current] = true;
        
        int count = 0;
        for(int next: roads.get(current)) {
            if(!visited[next]) count++;
        }
        
        if(count == 0) {
            dp[current][0] = 1;
            dp[current][1] = 0;
            return;
        }
        
        for(int next: roads.get(current)) {
            if(!visited[next]) {
                dfs(next);
                dp[current][0] += Math.min(dp[next][0], dp[next][1]);
                dp[current][1] += dp[next][0];
            }
        }
        dp[current][0]++;
    }
}