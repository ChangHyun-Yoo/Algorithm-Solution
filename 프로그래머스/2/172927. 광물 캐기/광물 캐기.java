import java.util.*;
class Solution {
    
    static int min = Integer.MAX_VALUE;
    static int[] picks;
    static String[] minerals;
    
    public int solution(int[] picks, String[] minerals) {
        this.picks = picks;
        this.minerals = minerals;
        
        dfs(0, 0);
        
        return min;
    }
    
    static void dfs(int current, int tired) {
        
        // 모든 곡괭이를 사용하면 피로도 최신화
        if(picks[0] == 0 && picks[1] == 0 && picks[2] == 0) {
            min = Math.min(min, tired);
            return;
        }
        
        // 모든 광물 다 캐면 피로도 최신화
        if(current == minerals.length) {
            min = Math.min(min, tired);
            return;
        }
        
        if(picks[0] > 0) {
            picks[0]--;
            int addTired = 0;
            
            int i = current;
            for(; i < Math.min(current + 5, minerals.length); i++) {
                addTired++;
            }
            dfs(i, tired + addTired);
            
            picks[0]++;
        }
        
        if(picks[1] > 0) {
            picks[1]--;
            int addTired = 0;
            
            int i = current;
            for(; i < Math.min(current + 5, minerals.length); i++) {
                if(minerals[i].equals("diamond")) {
                    addTired += 5;
                } else {
                    addTired++;
                }
            }
            dfs(i, tired + addTired);
            
            picks[1]++;
        }
        
        if(picks[2] > 0) {
            picks[2]--;
            int addTired = 0;
            
            int i = current;
            for(; i < Math.min(current + 5, minerals.length); i++) {
                if(minerals[i].equals("diamond")) {
                    addTired += 25;
                } else if(minerals[i].equals("iron")) {
                    addTired += 5;
                } else {
                    addTired++;
                }
            }
            dfs(i, tired + addTired);
            
            picks[2]++;
        }
    }
}