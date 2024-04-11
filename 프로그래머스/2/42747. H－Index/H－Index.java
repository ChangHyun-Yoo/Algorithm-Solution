import java.util.*;
class Solution {
    
    public int solution(int[] citations) {
        
        List<Integer> c = new ArrayList<>();
        for(int citation: citations) {
            c.add(citation);
        }
        Collections.sort(c, Collections.reverseOrder());
        
        int answer = 0;
        for(int i = 0; i < c.size(); i++) {
            if(i + 1 >= c.get(i)) return Math.max(i, c.get(i));
        }
        
        return c.size();
    }
}