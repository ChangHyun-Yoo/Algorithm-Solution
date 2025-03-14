import java.util.*;
class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        
        for(int i = 0; i < topping.length; i++) {
            if(right.containsKey(topping[i])) right.replace(topping[i], right.get(topping[i]) + 1);
            else right.put(topping[i], 1);
        }
        
        int answer = 0;
        for(int i = 0; i < topping.length - 1; i++) {
            if(left.containsKey(topping[i])) left.replace(topping[i], right.get(topping[i]) + 1);
            else left.put(topping[i], 1);
            
            if(right.get(topping[i]) == 1) right.remove(topping[i]);
            else right.replace(topping[i], right.get(topping[i]) - 1);
            
            if(left.keySet().size() == right.keySet().size()) {
                answer++;
            }
        }
        
        return answer;
    }
}