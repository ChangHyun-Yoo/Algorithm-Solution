import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        
        PriorityQueue<Exam> pq = new PriorityQueue<>();
        Stack<Exam> stack = new Stack<>();
        for(String[] plan: plans) {
            String[] s = plan[1].split(":");
            int start = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
            pq.offer(new Exam(plan[0], start, Integer.parseInt(plan[2])));
        }
        
        int time = pq.peek().start;
        while(!pq.isEmpty() || !stack.isEmpty()) {
            if(!pq.isEmpty()) {
                if(time == pq.peek().start) {
                    Exam now = pq.poll();
                    if(pq.isEmpty()) {
                        answer.add(now.name);
                    } else {
                        if(time + now.remain <= pq.peek().start) {
                            time += now.remain;
                            answer.add(now.name);
                        } else {
                            now.remain -= pq.peek().start - time;
                            time = pq.peek().start;
                            stack.push(now);
                        }
                    }
                } else if(time < pq.peek().start) {
                    while(!stack.isEmpty()) {
                        Exam now = stack.pop();
                        if(time + now.remain <= pq.peek().start) {
                            time += now.remain;
                            answer.add(now.name);
                        } else {
                            now.remain -= pq.peek().start - time;
                            time = pq.peek().start;
                            stack.push(now);
                            break;
                        }
                    }
                    time = pq.peek().start;
                }
            }
            else if(pq.isEmpty() && !stack.isEmpty()) {
                while(!stack.isEmpty()) {
                    answer.add(stack.pop().name);
                }
            }
        }
        
        String[] a = new String[answer.size()];
        for(int i = 0; i < a.length; i++) {
            a[i] = answer.get(i);
        }
        return a;
    }
    
    static class Exam implements Comparable<Exam> {
        String name;
        int start;
        int remain;
        
        public Exam(String name, int start, int remain) {
            this.name = name;
            this.start = start;
            this.remain = remain;
        }
        
        public int compareTo(Exam e) {
            return this.start - e.start;
        }
    }
}