import java.util.*;
class Solution {
    
    public int solution(String[] maps) {
        int answer = -1;
        int exitX = 0;
        int exitY = 0;
        int leverX = 0;
        int leverY = 0;
        boolean[][] visited1 = new boolean[maps.length][maps[0].length()];
        boolean[][] visited2 = new boolean[maps.length][maps[0].length()];
        Queue<Node> q1 = new LinkedList<>();
        
        int[][] map = new int[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length(); j++) {
                if(maps[i].charAt(j) == 'S') {
                    q1.offer(new Node(i, j, 0));
                    map[i][j] = 0;
                } else if(maps[i].charAt(j) == 'E') {
                    exitX = i;
                    exitY = j;
                    map[i][j] = 0;
                } else if(maps[i].charAt(j) == 'L') {
                    leverX = i;
                    leverY = j;
                    map[i][j] = 0;
                } else if(maps[i].charAt(j) == 'O') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1;
                }
            }
        }
        
        while(!q1.isEmpty()) {
            Node now = q1.poll();
            
            if(visited1[now.x][now.y]) continue;
            visited1[now.x][now.y] = true;
            
            if(now.x == leverX && now.y == leverY) {
                answer = now.time;
                break;
            }
            
            if(now.x != 0 && !visited1[now.x - 1][now.y] && map[now.x - 1][now.y] != 1) {
                q1.offer(new Node(now.x - 1, now.y, now.time + 1));
            }
            if(now.y != 0 && !visited1[now.x][now.y - 1] && map[now.x][now.y - 1] != 1) {
                q1.offer(new Node(now.x, now.y - 1, now.time + 1));
            }
            if(now.x != map.length - 1 && !visited1[now.x + 1][now.y] && map[now.x + 1][now.y] != 1) {
                q1.offer(new Node(now.x + 1, now.y, now.time + 1));
            }
            if(now.y != map[0].length - 1 && !visited1[now.x][now.y + 1] && map[now.x][now.y + 1] != 1) {
                q1.offer(new Node(now.x, now.y + 1, now.time + 1));
            }
        }
        
        if(answer == -1) return -1;
        
        Queue<Node> q2 = new LinkedList<>();
        q2.offer(new Node(leverX, leverY, 0));
        int add = -1;
        while(!q2.isEmpty()) {
            Node now = q2.poll();
                        
            if(visited2[now.x][now.y]) continue;
            visited2[now.x][now.y] = true;
            
            if(now.x == exitX && now.y == exitY) {
                add = now.time;
                break;
            }
            
            if(now.x != 0 && !visited2[now.x - 1][now.y] && map[now.x - 1][now.y] != 1) {
                q2.offer(new Node(now.x - 1, now.y, now.time + 1));
            }
            if(now.y != 0 && !visited2[now.x][now.y - 1] && map[now.x][now.y - 1] != 1) {
                q2.offer(new Node(now.x, now.y - 1, now.time + 1));
            }
            if(now.x != map.length - 1 && !visited2[now.x + 1][now.y] && map[now.x + 1][now.y] != 1) {
                q2.offer(new Node(now.x + 1, now.y, now.time + 1));
            }
            if(now.y != map[0].length - 1 && !visited2[now.x][now.y + 1] && map[now.x][now.y + 1] != 1) {
                q2.offer(new Node(now.x, now.y + 1, now.time + 1));
            }
            
        }
        
        if(add == -1) return -1;
        
        answer += add;
        
        return answer;
    }
    
    static class Node {
        int x;
        int y;
        int time;
        
        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}