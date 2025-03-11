import java.util.*;
class Solution {
    public long solution(int k, int d) {
        long lk = k;
        long ld = d;
        long answer = 0;
        
        for(long l = 0; l <= ld; l += k) {
            // m에 대해 이분탐색
            long value = ld * ld - l * l;
            
            long low = 0;
            long high = 1000001;
            
            while(low < high) {
                long mid = low + (high - low) / 2;
                
                if(mid * mid > value) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            
            low--;
            
            answer += (low / lk) + 1;
        }
        
        return answer;
    }
}