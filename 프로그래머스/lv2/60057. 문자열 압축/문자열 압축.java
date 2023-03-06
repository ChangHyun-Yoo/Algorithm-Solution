import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String s) {
        
        int length = s.length();
        
        if(length == 1) {
            return 1;
        }
        
        Set<Integer> set = new HashSet<>();
        
        int answer = 1001;
        for(int i = 1; i <= length / 2; i++) {
            int a = check(s, i);
            if(answer > a) {
                answer = a;
            }
        }
        return answer;
    }
    
    public int check(String s, int num) {
        String result = "";
        String current = s.substring(0, num);
        int repeat = 1;
        for(int i = num; i <= s.length() - 1; i += num) {
            String sub = s.substring(i, Math.min(s.length(), i + num));
            if(current.equals(sub)) {//같으면
                repeat++;
            } else {//같지 않으면
                if(repeat > 1) {
                    result += repeat + current;
                } else {
                    result += current;
                }
                repeat = 1;
                current = sub;
            }
        }
        if(repeat > 1) {
            result += repeat + current;
        } else {
            result += current;
        }
        return result.length();
    }
}