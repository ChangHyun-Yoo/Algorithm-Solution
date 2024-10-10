import java.util.*;
class Solution {
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int minCourse = Integer.MAX_VALUE;
        int minIntensity = Integer.MAX_VALUE;
        int[] intensities = new int[n + 1];
        Arrays.fill(intensities, Integer.MAX_VALUE);
        // 카카오 해설 참고해서 다시 풀어보자
        Set<Integer> summit = new HashSet<>();
        for(int sum: summits) {
            summit.add(sum);
        }
        Set<Integer> gate = new HashSet<>();
        for(int ga: gates) {
            gate.add(ga);
        }
        List<List<Node>> roads = new ArrayList<>();
        for(int i = 0; i < n + 1; i++) {
            roads.add(new ArrayList<>());
        }
        for(int[] path: paths) {
            roads.get(path[0]).add(new Node(path[1], path[2]));
            roads.get(path[1]).add(new Node(path[0], path[2]));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int ga: gates) {
            pq.offer(new Node(ga, 0));
        }
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(now.intensity > minIntensity) continue;
            if(now.intensity >= intensities[now.num]) continue;
            intensities[now.num] = now.intensity;
            // 산봉우리 도착
            if(summit.contains(now.num)) {
                if(now.intensity == minIntensity) {
                    minCourse = Math.min(minCourse, now.num);
                } else {
                    minIntensity = now.intensity;
                    minCourse = now.num;
                }
            } else {
                for(Node next: roads.get(now.num)) {
                    if(!gate.contains(next.num)) {
                        pq.offer(new Node(next.num, Math.max(now.intensity, next.intensity)));
                    }
                }
            }
        }
        
        return new int[] {minCourse, minIntensity};
    }
    
    static class Node implements Comparable<Node> {
        int num;
        int intensity;
        
        public Node(int num, int intensity) {
            this.num = num;
            this.intensity = intensity;
        }
        
        public int compareTo(Node n) {
            return this.intensity - n.intensity;
        }
    }
}