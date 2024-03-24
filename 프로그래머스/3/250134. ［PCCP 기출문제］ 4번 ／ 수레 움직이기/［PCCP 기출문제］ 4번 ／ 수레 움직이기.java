import java.util.*;
class Solution {
    
    static int[][] maze;
    static boolean[][] visitedB;
    static boolean[][] visitedR;
    static int rowB;
    static int colB;
    static int rowR;
    static int colR;
    static int answer = Integer.MAX_VALUE;
    static int[] dir = {-1, 1};
    
    public int solution(int[][] m) {
        maze = new int[m.length][m[0].length];
        visitedB = new boolean[m.length][m[0].length];
        visitedR = new boolean[m.length][m[0].length];
        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[0].length; j++) {
                if(m[i][j] == 1) {
                    rowR = i;
                    colR = j;
                    maze[i][j] = 0;
                } else if(m[i][j] == 2) {
                    rowB = i;
                    colB = j;
                    maze[i][j] = 0;
                } else maze[i][j] = m[i][j];
            }
        }
        
        dfs(0, rowB, colB, rowR, colR);
        
        if(answer == Integer.MAX_VALUE) return 0;
        else return answer;
    }
    
    static void dfs(int move, int rowB, int colB, int rowR, int colR) {
        if(answer <= move) return;
        
        // 밖으로 가면 리턴
        if(!(rowB >= 0 && rowB < maze.length && colB >= 0 && colB < maze[0].length)) return;
        if(!(rowR >= 0 && rowR < maze.length && colR >= 0 && colR < maze[0].length)) return;
        // 벽으로 가면 리턴
        if(maze[rowB][colB] == 5 || maze[rowR][colR] == 5) return;
        // 서로 같은 곳으로 가면 리턴
        if(rowB == rowR && colB == colR) return;
        // 방문했던 칸
        if(visitedB[rowB][colB] || visitedR[rowR][colR]) return;
        
        if(maze[rowR][colR] == 3 && maze[rowB][colB] == 4) answer = move;
        else if(maze[rowR][colR] == 3 && maze[rowB][colB] != 4) {
            visitedB[rowB][colB] = true;
            for(int i = 0; i < dir.length; i++) {
                dfs(move + 1, rowB + dir[i], colB, rowR, colR);
                dfs(move + 1, rowB, colB + dir[i], rowR, colR);
            }
            visitedB[rowB][colB] = false;
        } else if(maze[rowR][colR] != 3 && maze[rowB][colB] == 4) {
            visitedR[rowR][colR] = true;
            for(int i = 0; i < dir.length; i++) {
                dfs(move + 1, rowB, colB, rowR + dir[i], colR);
                dfs(move + 1, rowB, colB, rowR, colR + dir[i]);
            }
            visitedR[rowR][colR] = false;
        } else {
            visitedB[rowB][colB] = true;
            visitedR[rowR][colR] = true;
            for(int i = 0; i < dir.length; i++) {
                for(int j = 0; j < dir.length; j++) {
                    if(!(rowB + dir[i] == rowR && colB == colR && rowR + dir[j] == rowB)) {
                        dfs(move + 1, rowB + dir[i], colB, rowR + dir[j], colR);
                    }
                    if(!(rowB + dir[i] == rowR && colB == colR 
                         && rowR == rowB && colR + dir[j] == colB)) {
                        dfs(move + 1, rowB + dir[i], colB, rowR, colR + dir[j]);
                    }
                    if(!(rowB == rowR && colB + dir[i] == colR
                        && rowR + dir[j] == rowB && colR == colB)) {
                        dfs(move + 1, rowB, colB + dir[i], rowR + dir[j], colR);
                    }
                    if(!(rowB == rowR && colB + dir[i] == colR && rowR == rowB && colR + dir[j] == colB)) {
                        dfs(move + 1, rowB, colB + dir[i], rowR, colR + dir[j]);
                    }
                }
            }
            visitedB[rowB][colB] = false;
            visitedR[rowR][colR] = false;
        }
        
    }
}