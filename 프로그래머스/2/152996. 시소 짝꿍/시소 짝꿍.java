import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Map<Integer, Integer> def = new HashMap<>();
        Map<Integer, Integer> mul = new HashMap<>();
        for(int weight: weights) {
            insert(weight, def);
            insert(weight * 2, mul);
            insert(weight * 3, mul);
            insert(weight * 4, mul);
        }
        
        for(int w: mul.keySet()) {
            if(mul.get(w) >= 2) {
                answer += com(mul.get(w));
            }
        }
        for(int w: def.keySet()) {
            if(def.get(w) >= 2) {
                answer -= com(def.get(w)) * 2;
            }
        }
        
        return answer;
    }
    
    static long com(int n) {
        long l = (long) n;
        return l * (l - 1) / 2;
    }
    
    static void insert(int weight, Map<Integer, Integer> map) {
        if(map.containsKey(weight)) {
            map.replace(weight, map.get(weight) + 1);
        } else {
            map.put(weight, 1);
        }
    }
}