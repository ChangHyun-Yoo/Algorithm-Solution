import java.util.*;

class Solution {
    
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        
        if(min == Integer.MAX_VALUE)
            return 0;
        else
            return min;
    }
    
    public static void dfs(String current, String target, String[] words, int num) {
        if(num > min)
            return;
        if(current.equals(target)) {
            min = num;
        }
        
        for(int i = 0; i < words.length; i++) {
            if(check(current, words[i]) && !visited[i]) {
                visited[i] = true;
                dfs(words[i], target, words, num + 1);
                visited[i] = false;
            }
        }
    }
    
    public static boolean check(String a, String b) {
        int count = 0;
        for(int i = 0; i < a.length(); i++) {
            if(!a.substring(i, i + 1).equals(b.substring(i, i + 1))) {
                count++;
            }
            if(count > 1) {
                return false;
            }
        }
        if(count == 1) return true;
        else return false;
    }
}