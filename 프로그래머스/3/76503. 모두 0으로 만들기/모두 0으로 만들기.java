import java.util.*;
class Solution {
    public long solution(int[] a, int[][] edges) {
        int[] conn = new int[a.length];
        long[] w = new long[a.length];
        List<List<Integer>> roads = new ArrayList<>();
        for(int i = 0; i < a.length; i++) {
            roads.add(new ArrayList<>());
            w[i] = (long) a[i];
        }
        for(int[] edge: edges) {
            roads.get(edge[0]).add(edge[1]);
            roads.get(edge[1]).add(edge[0]);
            conn[edge[0]]++;
            conn[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < conn.length; i++) {
            if(conn[i] == 1) q.offer(i);
        }
        
        long answer = 0;
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int next: roads.get(now)) {
                if(w[next] != 0) {
                
                    w[next] += w[now];
                    answer += (long) Math.abs(w[now]);
                    w[now] = 0L;
                    conn[next]--;

                    if(conn[next] == 1L) {
                        q.offer(next);
                    }
                    break;
                }
            }
        }
        
        for(long ww: w) {
            if(ww != 0) return -1L;
        }
        
        return answer;
    }
}