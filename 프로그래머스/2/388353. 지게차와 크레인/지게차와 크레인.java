import java.util.*;
class Solution {
    public int solution(String[] storage, String[] requests) {
        char[][] chars = new char[storage.length + 2][storage[0].length() + 2];
        for(int i = 0; i < chars.length; i++) {
            for(int j = 0; j < chars[i].length; j++) {
                if(i == 0 || i == chars.length - 1 || j == 0 || j == chars[i].length - 1)
                    chars[i][j] = '-';
                else
                    chars[i][j] = storage[i - 1].charAt(j - 1);
            }
        }
        
        for(String request: requests) {
            char container = request.charAt(0);
            if(request.length() == 2) {
                // 모두 꺼내야 하는 경우
                for(int i = 0; i < chars.length; i++) {
                    for(int j = 0; j < chars[i].length; j++) {
                        if(chars[i][j] == container) chars[i][j] = '-';
                    }
                }
            } else {
                // 바깥쪽만 꺼내는 경우
                Queue<Node> q = new LinkedList<>();
                q.offer(new Node(0, 0));
                boolean[][] visited = new boolean[chars.length][chars[0].length];
                while(!q.isEmpty()) {
                    Node now = q.poll();
                    
                    if(visited[now.i][now.j]) continue;
                    visited[now.i][now.j] = true;
                    
                    if(chars[now.i][now.j] == '-') {
                        if(now.i != 0) q.offer(new Node(now.i - 1, now.j));
                        if(now.j != 0) q.offer(new Node(now.i, now.j - 1));
                        if(now.i != chars.length - 1) q.offer(new Node(now.i + 1, now.j));
                        if(now.j != chars[0].length - 1) q.offer(new Node(now.i, now.j + 1));
                    } else if(chars[now.i][now.j] == container) chars[now.i][now.j] = '-';
                }
            }
        }
        
        int answer = 0;
        for(int i = 0; i < chars.length; i++) {
            for(int j = 0; j < chars[i].length; j++) {
                if(chars[i][j] != '-') {
                    answer++;
                }
            }
        }
        return answer;
    }
    
    static class Node {
        int i;
        int j;
        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}