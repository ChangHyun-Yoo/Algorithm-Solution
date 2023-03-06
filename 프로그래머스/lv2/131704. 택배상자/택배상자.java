import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        int length = order.length;
        
        Stack<Integer> sup = new Stack<>();
        int current = 1;
        int i = 0;
        while(i < order.length || current != order.length + 1) {
            if(current == order[i]) {//현재 컨테이너와 주문이 일치
                current++;
                i++;
                answer++;
            } else if(current != order[i] && sup.size() == 0) {//현재 컨테이너 주문 불일치, 보조 컨테이너에 없을 때
                sup.push(current);
                current++;
            } else if(current != order[i] && sup.peek() == order[i]) {//현재 컨테이너 주문 불일치, 보조 컨테이너 일치
                sup.pop();
                i++;
                answer++;
            } else if(current != order[i] && sup.peek() != order[i]) {//현재 컨테이너 주문 불일치, 보조 컨테이너 불일치
                sup.push(current);
                current++;
                if(current > order.length) {
                    break;
                }
            }
        }
        
        return answer;
    }
}