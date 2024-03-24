import java.util.*;
class Solution {
    
    static List<List<Node>> roads = new ArrayList<>();
    static int[] min;
    
    public int solution(int n, int[][] edge) {
        min = new int[n + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        for(int i = 0; i < n + 1; i++) {
            roads.add(new ArrayList<>());
        }
        
        for(int[] e: edge) {
            roads.get(e[0]).add(new Node(e[1], 1));
            roads.get(e[1]).add(new Node(e[0], 1));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(now.dis > min[now.num]) continue;
            min[now.num] = now.dis;
            
            for(Node next: roads.get(now.num)) {
                if(min[next.num] > min[now.num] + next.dis) {
                    min[next.num] = min[now.num] + next.dis;
                    pq.offer(new Node(next.num, min[next.num]));
                }
            }
        }
        
        int max = 0;
        int maxNum = 0;
        for(int i = 1; i <= n; i++) {
            if(min[i] > max) {
                max = min[i];
                maxNum = 1;
            } else if(min[i] == max) {
                maxNum++;
            }
        }
        return maxNum;
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