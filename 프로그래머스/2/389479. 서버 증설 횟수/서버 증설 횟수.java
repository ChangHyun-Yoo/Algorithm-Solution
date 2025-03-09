import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        
        Queue<Info> queue = new LinkedList<>();
        int answer = 0;
        int current = 0;
        for(int time = 0; time < players.length; time++) {
            if(!queue.isEmpty() && queue.peek().time == time) {
                Info polled = queue.poll();
                current -= polled.num;
            }
            
            if(players[time] / m > current) {
                int add = players[time] / m - current;
                answer += add;
                current += add;
                queue.add(new Info(add, time + k));
            }
        }
        
        return answer;
    }
    
    static class Info {
        int num;
        int time;
        
        public Info(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }
}