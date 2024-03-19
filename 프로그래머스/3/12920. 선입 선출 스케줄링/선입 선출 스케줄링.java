import java.util.*;
class Solution {
    
    public int solution(int n, int[] cores) {
        if(cores.length >= n) return cores[n - 1];
        
        int low = 0;
        int high = 100000001;
        
        while(low < high) {
            int mid = low + (high - low) / 2;
            
            int p = 0;
            for(int core: cores) {
                p += mid / core;
                if(mid % core != 0) p++;
            }
            if(p >= n) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        low--;
        
        int inputed = 0;
        
        PriorityQueue<Core> pq = new PriorityQueue<>();
        for(int i = 0; i < cores.length; i++) {
            inputed += low / cores[i];
            if(low % cores[i] != 0) inputed++;
            pq.offer(new Core(cores[i], i + 1, low % cores[i]));
        }
        
        int answer = 0;
        while(!pq.isEmpty()) {
            Core c = pq.poll();
            
            inputed++;
            if(inputed == n) {
                answer = c.num;
                break;
            }
            c.finish += c.time;
            pq.offer(c);
        }
        
        return answer;
    }
    
    static class Core implements Comparable<Core> {
        int time;
        int num;
        long finish;
        
        public Core(int time, int num, long finish) {
            this.time = time;
            this.num = num;
            this.finish = finish;
        }
        
        public int compareTo(Core c) {
            if(this.finish == c.finish) {
                return this.num - c.num;
            } else {
                if(this.finish < c.finish) {
                    return -1;
                } else {
                    return 1;
                }
                // return this.finish - c.finish;
            }
        }
    }
}