import java.util.*;
class Solution {
    
    static int installedNum = 0;
    static boolean[] installed;
    
    public int solution(int[][] routes) {
        installed = new boolean[routes.length];
        List<Route> lst = new ArrayList<>();
        for(int[] route: routes) {
            lst.add(new Route(route[0], route[1]));
        }
        Collections.sort(lst);
        
        int answer = 0;
        
        while(installedNum < routes.length) {
            
            int end = 0;
            for(int i = 0; i < lst.size(); i++) {
                if(!installed[i]) {
                    end = lst.get(i).end;
                    break;
                }
            }
            for(int i = 0; i < lst.size(); i++) {
                if(!installed[i] && lst.get(i).start <= end && lst.get(i).end >= end) {
                    installed[i] = true;
                    installedNum++;
                }
            }
            answer++;
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