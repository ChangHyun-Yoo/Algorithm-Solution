import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        Queue<Info> q = new LinkedList<>();
        for(int i = 0; i < routes.length; i++) {
            q.offer(new Info(i, points[routes[i][0] - 1][0], points[routes[i][0] - 1][1], 0));
        }
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            int[][] visited = new int[101][101];
            
            for(int i = 0; i < size; i++) {
                Info now = q.poll();
                
                visited[now.x][now.y]++;
                
                // 목적지에 도착했으면
                if(now.x == points[routes[now.i][now.dest] - 1][0] && now.y == points[routes[now.i][now.dest] - 1][1]) {
                    // 안 끝났으면
                    if(now.dest != routes[now.i].length - 1) {
                        now.dest++;
                        if(now.x < points[routes[now.i][now.dest] - 1][0]) {
                            now.x++;
                        } else if(now.x > points[routes[now.i][now.dest] - 1][0]) {
                            now.x--;
                        } else {
                            if(now.y < points[routes[now.i][now.dest] - 1][1]) {
                                now.y++;
                            } else {
                                now.y--;
                            }
                        }
                        q.offer(now);
                    }
                }
                // 목적지에 도착 안했으면
                else {
                    if(now.x < points[routes[now.i][now.dest] - 1][0]) {
                        now.x++;
                    } else if(now.x > points[routes[now.i][now.dest] - 1][0]) {
                        now.x--;
                    } else {
                        if(now.y < points[routes[now.i][now.dest] - 1][1]) {
                            now.y++;
                        } else {
                            now.y--;
                        }
                    }
                    q.offer(now);
                }
            }
            
            for(int[] vv: visited) {
                for(int v: vv) {
                    if(v > 1) answer++;
                }
            }
        }
        
        return answer;
    }
    
    static class Info {
        int i;
        int x;
        int y;
        int dest;
        
        public Info(int i, int x, int y, int dest) {
            this.i = i;
            this.x = x;
            this.y = y;
            this.dest = dest;
        }
    }
}