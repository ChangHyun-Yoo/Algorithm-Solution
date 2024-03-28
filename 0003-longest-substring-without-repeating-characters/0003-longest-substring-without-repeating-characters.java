import java.util.*;
class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        
        char[] chs = s.toCharArray();
        
        Set<Character> set = new HashSet<>();
        
        int left = 0;
        int right = 0;
        
        int answer = 0;
        
        while(right < s.length()) {
            
            if(set.contains(chs[right])) {
                set.remove(chs[left]);
                left++;
            } else {
                set.add(chs[right]);
                answer = Math.max(answer, right - left + 1);
                right++;
            }
        }
        
        return answer;
    }
}