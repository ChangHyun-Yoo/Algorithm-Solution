import java.util.*;
class Solution {
    
    static Map<String, String> parent = new HashMap<>();
    static Map<String, Integer> index = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        int[] answer = new int[enroll.length];
        
        for(int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
            index.put(enroll[i], i);
        }
        
        for(int i = 0; i < seller.length; i++) {
            String cur = seller[i];
            int am = amount[i] * 100;
            
            boolean b = false;
            while(!parent.get(cur).equals("-")) {
                answer[index.get(cur)] += am - am / 10;
                if(am / 10 == 0) {
                    b = true;
                    break;
                }
                cur = parent.get(cur);
                am /= 10;
            }
            if(b) continue;
            answer[index.get(cur)] += am - am / 10;
        }
        
        return answer;
    }
}