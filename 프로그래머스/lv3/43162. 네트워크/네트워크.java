import java.util.*;

class Solution {
    
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        while(true) {
            int index = -1;
            for(int i = 0; i < n; i++) {
                if(!visited[i]) {
                    index = i;
                }
            }
            
            if(index == -1)
                break;
            visited[index] = true;
            Queue<Integer> q = new LinkedList<>();
            q.offer(index);
            while(!q.isEmpty()) {
                int c = q.poll();
                for(int i = 0; i < n; i++) {
                    if(!visited[i] && computers[c][i] == 1) {
                        q.offer(i);
                        visited[i] = true;
                    }
                }
            }
            answer++;
        }
        
        return answer;
    }
}