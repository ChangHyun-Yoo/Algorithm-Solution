import java.util.*;
class Solution {
    
    static int[][] min;
    static List<List<Node>> roads = new ArrayList<>();
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        min = new int[n + 1][n + 1];
        for(int[] m: min) {
            Arrays.fill(m, Integer.MAX_VALUE);
        }
        for(int i = 0; i < n + 1; i++) {
            roads.add(new ArrayList<>());
        }
        for(int[] fare: fares) {
            roads.get(fare[0]).add(new Node(fare[1], fare[2]));
            roads.get(fare[1]).add(new Node(fare[0], fare[2]));
        }
        
        for(int i = 1; i <= n; i++) {
            
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(i, 0));
            
            while(!pq.isEmpty()) {
                Node now = pq.poll();
                
                if(min[i][now.num] < now.dis) continue;
                min[i][now.num] = now.dis;
                
                for(Node next: roads.get(now.num)) {
                    if(min[i][next.num] > min[i][now.num] + next.dis) {
                        min[i][next.num] = min[i][now.num] + next.dis;
                        pq.add(new Node(next.num, min[i][next.num]));
                    }
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        
        //합석 안할 경우
        answer = Math.min(answer, min[s][a] + min[s][b]);
        
        // 합석할 경우
        for(int i = 1; i < n + 1; i++) {
            answer = Math.min(answer, min[s][i] + min[i][a] + min[i][b]);
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