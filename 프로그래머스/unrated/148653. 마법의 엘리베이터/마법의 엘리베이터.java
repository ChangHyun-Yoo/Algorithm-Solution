import java.lang.*;
import java.util.*;

class Solution {
    private int min = -1;
    
    public int solution(int storey) {
        int answer = 0;
        int length = (int) (Math.log10(storey));
        int init = (int) Math.pow(10, length);
        System.out.println(length);
        
        dp(init*10 - storey, init, 1, 1);
        dp(storey, init, 0, 1);
        return this.min;
    }
    
    public void dp(int storey, int init, int sum, int num) {
        if(init < 1) {//마지막일때
            if(this.min == -1) {
                this.min = sum + Math.min(storey, 10 - storey);
                return;
            } else {
                this.min = Math.min(this.min, sum + Math.min(storey, 10 - storey));
                return;
            }
        } else {
            dp(storey - (storey / init) * init, init / 10, sum + storey / init, num + 1);
            dp((storey / init + 1) * init - storey, init / 10, sum + storey / init + 1, num + 1);
        }
    }
    
    
}