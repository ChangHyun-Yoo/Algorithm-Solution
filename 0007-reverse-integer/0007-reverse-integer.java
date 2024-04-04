import java.util.*;
class Solution {
    
    public int reverse(int x) {
        
        if(x == Integer.MIN_VALUE) return 0;
        
        String abs = Integer.toString(Math.abs(x));
        StringBuilder sb = new StringBuilder(abs);
        String reversed = sb.reverse().toString();
        
        long r = Long.parseLong(reversed);
        if(x < 0) r *= -1;
        
        if(r < Integer.MIN_VALUE || r > Integer.MAX_VALUE) return 0;
        else return (int) r;
    }
}