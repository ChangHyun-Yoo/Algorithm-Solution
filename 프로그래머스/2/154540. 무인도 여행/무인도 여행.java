import java.util.*;
class Solution {
    public int[] solution(String[] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        int[][] islands = new int[maps.length][maps[0].length()];
        
        int num = 0;
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length(); j++) {
                if(maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    num++;
                    dfs(i, j, maps, visited, islands, num);
                }
            }
        }
        
        if(num == 0) return new int[] {-1};
        
        int[] answer = new int[num];
        for(int i = 0; i < islands.length; i++) {
            for(int j = 0; j < islands[i].length; j++) {
                if(islands[i][j] != 0) {
                    answer[islands[i][j] - 1] += ((int) maps[i].charAt(j)) - 48;
                }
            }
        }
        Arrays.sort(answer);
        
        return answer;
    }
    
    static void dfs(int i, int j, String[] maps, boolean[][] visited, int[][] islands, int num) {
        if(i >= 0 && i < visited.length && j >= 0 && j < visited[0].length) {
            if(maps[i].charAt(j) != 'X' && !visited[i][j]) {
                islands[i][j] = num;
                visited[i][j] = true;
                dfs(i - 1, j, maps, visited, islands, num);
                dfs(i + 1, j, maps, visited, islands, num);
                dfs(i, j - 1, maps, visited, islands, num);
                dfs(i, j + 1, maps, visited, islands, num);
            }
        }
    }
}