import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        if(enemy.length <= k) return enemy.length;
        
        // 무적권을 사용한 아이들
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        for(int i = 0; i < k; i++) {
            pq.offer(enemy[i]);
        }
        
        for(int i = k; i < enemy.length; i++) {
            if(pq.peek() < enemy[i]) {
                sum += pq.poll();
                pq.offer(enemy[i]);
            } else {
                sum += enemy[i];
            }
            
            if(sum > n) return i;
        }
        
        return enemy.length;
    }
}