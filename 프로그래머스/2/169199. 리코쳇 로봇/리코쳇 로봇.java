import java.util.*;
class Solution {
    
    static int[][] map;
    static boolean[][] visited;
    static int goalX;
    static int goalY;
    
    public int solution(String[] board) {
        map = new int[board.length][board[0].length()];
        visited = new boolean[board.length][board[0].length()];
        
        Queue<Node> q = new LinkedList<>();
        
        for(int i = 0; i < board.length; i++) {
            String b = board[i];
            for(int j = 0; j < b.length(); j++) {
                if(b.charAt(j) == '.') {
                    map[i][j] = 0;
                } else if(b.charAt(j) == 'D') {
                    map[i][j] = 1;
                } else if(b.charAt(j) == 'G') {
                    map[i][j] = 0;
                    goalX = i;
                    goalY = j;
                } else {
                    q.add(new Node(i, j, 0));
                }
            }
        }
        
        while(!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            
            if(x == goalX && y == goalY) return now.num;
            if(visited[x][y]) continue;
            visited[x][y] = true;
            
            int[] u = up(x, y);
            int[] d = down(x, y);
            int[] l = left(x, y);
            int[] r = right(x, y);
            if(!visited[u[0]][u[1]]) q.offer(new Node(u[0], u[1], now.num + 1));
            if(!visited[d[0]][d[1]]) q.offer(new Node(d[0], d[1], now.num + 1));
            if(!visited[l[0]][l[1]]) q.offer(new Node(l[0], l[1], now.num + 1));
            if(!visited[r[0]][r[1]]) q.offer(new Node(r[0], r[1], now.num + 1));
        }
        
        return -1;
    }
        
    static int[] up(int x, int y) {
        while(x != 0 && map[x - 1][y] == 0) {
            x--;
        }
        
        return new int[] {x, y};
    }
    
    static int[] down(int x, int y) {
        while(x != map.length - 1 && map[x + 1][y] == 0) {
            x++;
        }
        
        return new int[] {x, y};
    }
    
    static int[] left(int x, int y) {
        while(y != 0 && map[x][y - 1] == 0) {
            y--;
        }
        
        return new int[] {x, y};
    }
    
    static int[] right(int x, int y) {
        while(y != map[0].length - 1 && map[x][y + 1] == 0) {
            y++;
        }
        
        return new int[] {x, y};
    }
    
    static class Node {
        int x;
        int y;
        int num;
        
        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}