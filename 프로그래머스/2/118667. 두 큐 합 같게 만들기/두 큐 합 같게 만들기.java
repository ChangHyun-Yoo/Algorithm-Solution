import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        for(int i: queue1) {
            q1.offer((long) i);
            sum1 += i;
        }
        for(int i: queue2) {
            q2.offer((long) i);
            sum2 += i;
        }
        long sum = sum1 + sum2;
        if(sum % 2 == 1) return -1;
        
        int size = queue1.length + queue2.length;
        
        for(int i = 0; i < 2*size; i++) {
            if(sum1 == sum / 2) return i;
            
            if(sum1 > sum / 2) {
                long polled = q1.poll();
                sum1 -= polled;
                sum2 += polled;
                q2.offer(polled);
            } else {
                long polled = q2.poll();
                sum1 += polled;
                sum2 -= polled;
                q1.offer(polled);
            }
        }
        
        return -1;
    }
}