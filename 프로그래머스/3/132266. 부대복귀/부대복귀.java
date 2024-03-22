import java.util.*;
class Solution {
    
    static List<List<Node>> r = new ArrayList<>();
    static int[] min;
    static final int INF = Integer.MAX_VALUE;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        for(int i = 0; i < n + 1; i++) {
            r.add(new ArrayList<>());
        }
        min = new int[n + 1];
        Arrays.fill(min, INF);
        
        for(int[] road: roads) {
            r.get(road[0]).add(new Node(road[1], 1));
            r.get(road[1]).add(new Node(road[0], 1));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(destination, 0));
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(now.dis > min[now.num]) continue;
            min[now.num] = now.dis;
            
            for(Node next: r.get(now.num)) {
                if(min[next.num] > min[now.num] + next.dis) {
                    min[next.num] = min[now.num] + next.dis;
                    pq.offer(new Node(next.num, min[next.num]));
                }
            }
        }
        
        int[] answer = new int[sources.length];
        for(int i = 0; i < answer.length; i++) {
            if(min[sources[i]] == INF) answer[i] = -1;
            else answer[i] = min[sources[i]];
        }
        return answer;
    }
    
    static class Node implements Comparable<Node> {
        int num;
        int dis;
        
        public Node(int num, int dis) {
            this.num = num;
            this.dis = dis;
        }
        
        public int compareTo(Node n) {
            return this.dis - n.dis;
        }
    }
}