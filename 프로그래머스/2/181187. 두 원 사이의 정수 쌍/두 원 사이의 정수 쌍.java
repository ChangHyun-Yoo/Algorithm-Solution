import java.util.*;
class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        long rr1 = (long) r1 * (long) r1;
        long rr2 = (long) r2 * (long) r2;
        
        for(long x = 0; x < r2; x++) {
            long value1 = rr1 - x * x;
            
            long low1 = 1;
            long high1 = 1000001;
            
            while(low1 < high1) {
                long mid1 = low1 + (high1 - low1) / 2;
                
                if(mid1 * mid1 >= value1) {
                    high1 = mid1;
                } else {
                    low1 = mid1 + 1;
                }
            }
            
            long value2 = rr2 - x * x;
            
            long low2 = 1;
            long high2 = 1000001;
            
            while(low2 < high2) {
                long mid2 = low2 + (high2 - low2) / 2;
                
                if(mid2 * mid2 > value2) {
                    high2 = mid2;
                } else {
                    low2 = mid2 + 1;
                }
            }
            
            answer += low2 - low1;
        }
        
        return answer * 4;
    }
}