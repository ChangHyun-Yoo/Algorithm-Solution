class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char ch[] = s.toCharArray();
        
        if(ch.length % 2 == 1) {
            return false;
        }
        
        int check = 0;
        for(char c:ch) {
            if (c == '(') {
                check += 1;
            } else {
                check -= 1;
            }
            
            if(check < 0) {
                return false;
            }
        }

        if (check > 0) {
            return false;
        }
        return answer;
    }
}