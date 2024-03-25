import java.util.*;
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        Set<Integer> s = new HashSet<>();
        List<Integer> t = new ArrayList<>();
        
        for(int num: nums) {
            if(s.contains(num)) {
                t.add(num);
            } else {
                s.add(num);
            }
        }
        
        return t;
    }
}