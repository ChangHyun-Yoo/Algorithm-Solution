import java.util.*;
class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        int[] left = new int[a.length];
        int minLeft = Integer.MAX_VALUE;
        left[0] = minLeft;
        for(int i = 0; i < a.length - 1; i++) {
            minLeft = Math.min(minLeft, a[i]);
            left[i + 1] = minLeft;
        }
        int[] right = new int[a.length];
        int minRight = Integer.MAX_VALUE;
        right[right.length - 1] = minRight;
        for(int i = a.length - 1; i > 0; i--) {
            minRight = Math.min(minRight, a[i]);
            right[i - 1] = minRight;
        }
        for(int i = 0; i < left.length; i++) {
            if(!(a[i] > left[i] && a[i] > right[i])) answer++;
        }
        
        return answer;
    }
}