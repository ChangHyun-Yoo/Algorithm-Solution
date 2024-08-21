import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        
        long sum = sequence[0];
        int left = 0;
        int right = 0;
        int length = Integer.MAX_VALUE;
        int answerLeft = Integer.MAX_VALUE;
        int answerRight = Integer.MAX_VALUE;
        
        while(true) {
            if(sum == k) {
                if(right - left + 1 < length) {
                    answerLeft = left;
                    answerRight = right;
                    length = right - left + 1;
                }
                sum -= sequence[left];
                left++;
                right++;
                if(right == sequence.length) break;
                sum += sequence[right];
            } else if(sum > k) {
                sum -= sequence[left];
                left++;
            } else {
                right++;
                if(right == sequence.length) break;
                sum += sequence[right];
            }
        }
        
        return new int[] {answerLeft, answerRight};
    }
}