import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if(n > s) {
            int[] a = {-1};
            return a;
        }
        
        int num = s / n;
        int r = s % n;
        
        int[] answer = new int[n];
        for(int i = 0; i < n; i++) {
            if(i < r) {
                answer[i] = num + 1;
            } else {
                answer[i] = num;
            }
        }
        Arrays.sort(answer);
        return answer;
    }
}