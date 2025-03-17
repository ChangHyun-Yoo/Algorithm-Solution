import java.util.*;
class Solution {
    
    static int answer = 0;
    
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        
        for(int i = 1; i < cards.length + 1; i++) {
            visited[i - 1] = true;
            dfs(i, 1, cards, visited, 0);
            visited[i - 1] = false;
        }
        
        return answer;
    }
    
    static void dfs(int current, int group1, int[] cards, boolean[] visited, int group2) {
        visited[current - 1] = true;
        
        int next = cards[current - 1];
        if(visited[next - 1]) {
            // 이미 방문함
            if(group2 == 0) {
                // 그룹1 진행 중
                for(int i = 1; i < cards.length + 1; i++) {
                    if(!visited[i - 1]) {
                        visited[i - 1] = true;
                        dfs(i, group1, cards, visited, 1);
                    }
                }
            } else {
                // 그룹2 진행 중
                answer = Math.max(answer, group1 * group2);
            }
        } else {
            // 아직 방문하지 않음
            visited[next - 1] = true;
            if(group2 == 0) {
                dfs(next, group1 + 1, cards, visited, group2);
            } else {
                dfs(next, group1, cards, visited, group2 + 1);
            }
        }
        
        visited[current - 1] = false;
    }
}