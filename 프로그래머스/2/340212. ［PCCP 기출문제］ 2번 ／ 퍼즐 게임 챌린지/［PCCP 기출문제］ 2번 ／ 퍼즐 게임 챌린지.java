import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int low = 1;
        int high = 100000;
        
        while(low < high) {
            int mid = low + (high - low) / 2;
            
            boolean pass = pass(diffs, times, limit, mid);
            if(pass) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    static boolean pass(int[] diffs, int[] times, long limit, int level) {
        long spent = 0;
        int time_prev = -1;
        
        for(int i = 0; i < diffs.length; i++) {
            if(spent > limit) return false;
            int diff = diffs[i];
            int time_cur = times[i];
            
            if(diff <= level) {
                spent += time_cur;
            } else {
                spent += (time_cur + time_prev) * (diff - level) + time_cur;
            }
            
            time_prev = time_cur;
        }
        
        return spent <= limit;
    }
}