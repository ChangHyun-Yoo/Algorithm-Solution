import java.util.*;
class Solution {
    public int solution(int[] elements) {
        
        int[] element = new int[elements.length * 2 - 1];
        for(int i = 0; i < elements.length; i++) {
            element[i] = elements[i];
        }
        for(int i = 0; i < elements.length - 1; i++) {
            element[i + elements.length] = elements[i];
        }
        int[] sums = new int[element.length + 1];
        for(int i = 0; i < element.length; i++) {
            sums[i + 1] = sums[i] + element[i];
        }
        
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < sums.length - 1; i++) {
            for(int j = i + 1; j < sums.length && j - i <= elements.length; j++) {
                set.add(sums[j] - sums[i]);
            }
        }
        return set.size();
    }
}