import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int del = n - 1;
        int pic = n - 1;
        
        while(del >= 0 && deliveries[del] == 0) {
            del--;
        }
        while(pic >= 0 && pickups[pic] == 0) {
            pic--;
        }
        while(del >= 0 || pic >= 0) {
            answer += (Math.max(del, pic) + 1) * 2;
            
            int d = 0;
            while(del >= 0) {
                d += deliveries[del];
                if(d > cap) {
                    deliveries[del] = d - cap;
                    break;
                }
                del--;
            }
            
            int p = 0;
            while(pic >= 0) {
                p += pickups[pic];
                if(p > cap) {
                    pickups[pic] = p - cap;
                    break;
                }
                pic--;
            }
        }
        
        return answer;
    }
}