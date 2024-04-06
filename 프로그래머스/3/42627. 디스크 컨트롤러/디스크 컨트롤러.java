import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                if(a1[0] == a2[0]) {
                    return a1[1] - a2[1];
                } else return a1[0] - a2[0];
            }
        });
        
        int answer = 0;
        int now = 0;
        PriorityQueue<Job> pq = new PriorityQueue<>();
        
        for(int i = 0; i < jobs.length; i++) {
            
            if(jobs[i][0] >= now) {
                now = jobs[i][0] + jobs[i][1];
                answer += jobs[i][1];
                i++;
            }
            
            while(i < jobs.length && jobs[i][0] < now) {
                pq.offer(new Job(jobs[i][0], jobs[i][1]));
                i++;
            }
            
            while(!pq.isEmpty()) {
                Job poll = pq.poll();
                
                now += poll.time;
            
                while(i < jobs.length && jobs[i][0] < now) {
                    pq.offer(new Job(jobs[i][0], jobs[i][1]));
                    i++;
                }
                
                answer += now - poll.s;
            }
            i--;
        }
        return answer / jobs.length;
    }
    
    static class Job implements Comparable<Job> {
        int s;
        int time;
        
        public Job(int s, int time) {
            this.s = s;
            this.time = time;
        }
        
        public int compareTo(Job j) {
            if(this.time == j.time) {
                return this.s - j.s;
            } else {
                return this.time - j.time;
            }
        }
    }
}