class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int answer1 = 0;
        int answer2 = 0;
        int count = 0;
        while(true) {
            int c = 0;
            if(s.equals("1")) {
                break;
            } else {
                char[] chs = s.toCharArray();
                for(char ch:chs) {
                    if(ch == '0') {
                        answer1 += 1;
                    } else {
                        c += 1;
                    }
                }
            }
            count += 1;
            s = convert(c);
        }
        
        answer[0] = count;
        answer[1] = answer1;
        return answer;
    }
    
    public String convert(int input) {
        String answer = "";
        
        int check = 1;
        int cnt = 0;
        while(check <= input) {
            check *= 2;
            cnt += 1;
        }
        
        check /= 2;
        
        for(int i = 0; i < cnt; i++) {
            
            if(input >= check) {
                int ori = input;
                input -= check;
                answer += "1";
                if((input == 0) && (ori == 0)) {
                    answer += "0";
                }
            } else {
                answer += "0";
            }
            check /= 2;
        }
        return answer;
    }
}