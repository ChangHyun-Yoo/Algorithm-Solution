import java.util.*;
class Solution {
    
    static int max = 0;
    
    public int solution(int[] info, int[][] edges) {
        
        List<List<Integer>> roads = new ArrayList<>();
        for(int i = 0; i < info.length; i++) {
            roads.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            roads.get(edge[0]).add(edge[1]);
            roads.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> current = new HashSet<>();
        current.add(0);
        dfs(current, 1, 0, roads, info);
        
        return max;
    }
    
    static void dfs(Set<Integer> current, int yang, int wolf, List<List<Integer>> roads, int[] info) {
        max = Math.max(max, yang);
        
        List<Integer> currents = new ArrayList<>();
        for(int c: current) currents.add(c);
        for(int c: currents) {
            for(int next: roads.get(c)) {
                if(!current.contains(next)) {
                    if(info[next] == 1 && yang - 1 == wolf) continue;
                    // 늑대인데 잡아먹히지 않는 경우
                    else if(info[next] == 1 && yang - 1 != wolf) {
                        current.add(next);
                        dfs(current, yang, wolf + 1, roads, info);
                        current.remove(next);
                    }
                    // 양인 경우
                    else {
                        current.add(next);
                        dfs(current, yang + 1, wolf, roads, info);
                        current.remove(next);
                    }
                }
            }
        }
    }
}