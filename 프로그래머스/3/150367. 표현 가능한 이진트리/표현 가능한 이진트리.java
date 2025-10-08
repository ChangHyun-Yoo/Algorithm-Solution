import java.util.*;
class Solution {
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int j = 0; j < numbers.length; j++) {
            String bs = Long.toBinaryString(numbers[j]);
            
            int length = 0;
            for(int i = 1; true; i++) {
                if(bs.length() <= (int) Math.pow(2, i) - 1) {
                    length = (int) Math.pow(2, i) - 1;
                    break;
                }
            }
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < length - bs.length(); i++) {
                sb.append("0");
            }
            sb.append(bs);
            bs = sb.toString();
            
            if(bs.charAt(bs.length() / 2) == '0') {
                answer[j] = 0;
                continue;
            }
            if(dfs(0, bs.length(), bs, '1')) answer[j] = 1;
            else answer[j] = 0;
        }
        
        return answer;
    }
    
    static boolean dfs(int start, int end, String bs, char parent) {        
        int half = (start + end) / 2;
        char halfChar = bs.charAt(half);
        if(parent == '0' && halfChar == '1') return false;
        
        if(start != half) {
            if(!dfs(start, half, bs, halfChar)) return false;
        }
        if(half + 1 != end) {
            if(!dfs(half + 1, end, bs, halfChar)) return false;
        }
        
        return true;
    }
}