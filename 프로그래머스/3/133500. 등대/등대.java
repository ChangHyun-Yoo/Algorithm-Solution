import java.util.*;

class Solution {
    
    static List<List<Integer>> roads = new ArrayList<>();
    // 0 -> 끄는 경우, 1 -> 키는 경우
    static int[][] results;
    static boolean[] visited;
    
    public int solution(int n, int[][] lighthouse) {
        for(int i = 0; i <= n; i++) {
            roads.add(new ArrayList<>());
        }
        results = new int[n + 1][2];
        for(int[] r: results) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        visited = new boolean[n + 1];
        
        for(int[] l: lighthouse) {
            roads.get(l[0]).add(l[1]);
            roads.get(l[1]).add(l[0]);
        }
        
        dfs(1);
        return Math.min(results[1][0], results[1][1]);
    }
    
    static void dfs(int current) {
        visited[current] = true;
        
        int count = 0;
        for(int next: roads.get(current)) {
            if(!visited[next]) {
                count++;
            }
        }
        
        if(count == 0) {
            results[current][0] = 0;
            results[current][1] = 1;
        } else {
            List<Integer> ns = new ArrayList<>();
            int offs = 0;
            int forOn = 0;
            for(int next: roads.get(current)) {
                if(!visited[next]) {
                    ns.add(next);
                    dfs(next);
                    // 끄는 경우, 무조건 켜져있어야한다.
                    offs += results[next][1];
                    // 키는 경우, 최솟값들을 더한다.
                    forOn += Math.min(results[next][0], results[next][1]);
                }
            }
            
            results[current][0] = offs;
            results[current][1] = forOn + 1;
        }
        
    }
}