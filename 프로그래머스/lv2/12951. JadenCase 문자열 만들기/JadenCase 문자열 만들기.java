class Solution {
    public String solution(String s) {
        String answer = "";
        
        Boolean isEmpty = false;
        char[] test = s.toCharArray();
        if(test[s.length() - 1] == ' ') {
            isEmpty = true;
        }
        
        String[] splited = s.split(" ");
        String[] edited = new String[splited.length];
        for(int j = 0; j < splited.length; j++) {
            char[] ch = splited[j].toCharArray();
            for(int i = 0; i < ch.length; i++) {
                if(i == 0) {
                    ch[i] = Character.toUpperCase(ch[i]);   
                }
                else {
                    ch[i] = Character.toLowerCase(ch[i]);    
                }
            }
            edited[j] = new String(ch);
        }
        
        if (isEmpty == true) {
            answer = String.join(" ", edited) + " ";
        } else {
            answer = String.join(" ", edited);    
        }
        
        
        return answer;
    }
}