import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        long[] work = new long[50001];
        
        for(int w: works) {
            work[w]++;
        }
        
        for(int i = 50000; i >= 1; i--) {
            if(n == 0) {
                break;
            }
            if(work[i] == 0) {
                continue;
            } else if(work[i] >= n) {
                work[i] -= n;
                work[i - 1] += n;
                n = 0;
            } else {
                work[i - 1] += work[i];
                n -= work[i];
                work[i] = 0;
            }
        }
        
        for(int i = 1; i <= 50000; i++) {
            if(work[i] != 0) {
                answer += i * i * work[i];
            }
        }
        
        return answer;
    }
}