import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> ipq = new PriorityQueue<>();
        PriorityQueue<Integer> dpq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < operations.length; i++) {
            String[] splited = operations[i].split(" ");
            if(splited[0].equals("I")) {
                ipq.offer(Integer.parseInt(splited[1]));
                dpq.offer(Integer.parseInt(splited[1]));
            } else {
                if(splited[1].equals("1")) {
                    ipq.remove(dpq.poll());
                } else {
                    dpq.remove(ipq.poll());
                }
            }
        }
        
        if(ipq.size() > 0) {
            answer[0] = dpq.peek();
            answer[1] = ipq.peek();
        }
        
        return answer;
    }
}