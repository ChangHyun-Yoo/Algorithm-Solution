import java.util.*;
class Solution {
    
    static int num;
    static int oil;
    static List<Integer> oils = new ArrayList<>();
    
    public int solution(int[][] land) {
        num = 2;
        for(int i = 0; i < land.length; i++) {
            for(int j = 0; j < land[0].length; j++) {
                if(land[i][j] == 1) {
                    oil = 0;
                    dfs(i, j, land);
                    oils.add(oil);
                    num++;
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < land[0].length; i++) {
            Set<Integer> set = new HashSet<>();
            int all = 0;
            for(int j = 0; j < land.length; j++) {
                if(land[j][i] != 0 && !set.contains(land[j][i])) {
                    set.add(land[j][i]);
                    all += oils.get(land[j][i] - 2);
                }
            }
            max = Math.max(max, all);
        }
        
        return max;
    }
    
    static void dfs(int i, int j, int[][] land) {
        if(i >= 0 && i < land.length && j >= 0 && j < land[0].length && land[i][j] == 1) {
            land[i][j] = num;
            oil++;
            
            dfs(i - 1, j, land);
            dfs(i + 1, j, land);
            dfs(i, j - 1, land);
            dfs(i, j + 1, land);
        }
    }
}