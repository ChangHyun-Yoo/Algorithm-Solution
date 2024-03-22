import java.util.*;
class Solution {
    
    public int solution(int[][] routes) {
        List<Route> lst = new ArrayList<>();
        for(int[] route: routes) {
            lst.add(new Route(route[0], route[1]));
        }
        Collections.sort(lst);
        
        int answer = 0;
        
        int max = lst.get(0).end;
        answer++;
        for(int i = 0; i < lst.size(); i++) {
            if(max < lst.get(i).start) {
                max = lst.get(i).end;
                answer++;
            }
        }
        
        return answer;
    }
    
    static class Route implements Comparable<Route> {
        int start;
        int end;
        
        public Route(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        public int compareTo(Route r) {
            return this.end - r.end;
        }
    }
}