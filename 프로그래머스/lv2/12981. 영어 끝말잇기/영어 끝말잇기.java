class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        int index = -1;
        for(int i = 1; i < words.length; i++) {
            if(isExist(words, i)) {
                index = i;
                break;
            } else if(words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) {
                index = i;
                break;
            }
        }
        
        if(index == -1) {
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }
        else {
            answer[0] = index % n + 1;
            answer[1] = index / n + 1;
            return answer;
        }
        
    }
    
    public boolean isExist(String[] words, int index) {
        for(int i = 0; i < index; i++) {
            if (words[i].equals(words[index])) {
                return true;
            }
        }
        return false;
    }
}