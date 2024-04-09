class Solution {
    public int[] solution(int n, long left, long right) {
        int length = (int) (right - left) + 1;
        int[] answer = new int[length];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = (int) Math.max(left / n, left % n) + 1;
            left++;
        }
        
        return answer;
    }
}