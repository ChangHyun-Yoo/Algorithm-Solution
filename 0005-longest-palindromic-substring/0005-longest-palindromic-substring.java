import java.util.*;
class Solution {
    
    public String longestPalindrome(String s) {
        
        String answer = s.substring(0, 1);
        
        char[] chs = s.toCharArray();
        
        Queue<Integer> odd = new LinkedList<>();
        for(int i = 1; i < s.length() - 1; i++) {
            if(chs[i - 1] == chs[i + 1]) {
                if(answer.length() < 3)
                    answer = s.substring(i - 1, i + 2);
                odd.add(i);
            }
        }
        
        int index = 2;
        while(!odd.isEmpty()) {
            
            int repeat = odd.size();
            
            for(int i = 0; i < repeat; i++) {
                int poll = odd.poll();
                
                if(poll - index < 0 || poll + index >= chs.length) continue;
                
                if(chs[poll - index] == chs[poll + index]) {
                    if(answer.length() < 2 * index + 1)
                        answer = s.substring(poll - index, poll + index + 1);
                    odd.add(poll);
                }
            }
            index++;
        }
        
        Queue<Integer> even = new LinkedList<>();
        for(int i = 0; i < chs.length - 1; i++) {
            if(chs[i] == chs[i + 1]) {
                if(answer.length() < 2)
                    answer = s.substring(i, i + 2);
                even.add(i);
            }
        }
        
        index = 2;
        while(!even.isEmpty()) {
            int repeat = even.size();

            for(int i = 0; i < repeat; i++) {
                int poll = even.poll();
                
                if(poll - 1 < 0 || poll + index >= chs.length) continue;
                
                if(chs[poll - 1] == chs[poll + index]) {
                    if(answer.length() < index + 2)
                        answer = s.substring(poll - 1, poll + index + 1);
                    even.add(poll - 1);
                }
            }
            index += 2;
        }
        
        return answer;
    }
}