import java.util.*;

class Solution {
    public List<List<String>> lst = new ArrayList<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        
        Set<Set<String>> answer = new HashSet<>();
        
        String[] output = new String[banned_id.length];
        boolean[] visited = new boolean[user_id.length];
        for(int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        int n = user_id.length;
        int r = banned_id.length;
        
        dfs(user_id, output, visited, 0, n, r);
        
        for(List<String> a:lst) {
            for(int b = 0; b < a.size(); b++) {
                if(check(banned_id[b], a.get(b))) {
                    if(b == a.size() - 1) {
                        answer.add(new HashSet<>(a));
                    } else
                        continue;
                }
                else {
                    break;
                }
            }
        }
        
        return answer.size();
    }
    
    public void dfs(String[] user_id, String[] output, boolean[] visited, int depth, int n, int r) {
        if(depth == r) {
            lst.add(new ArrayList<>(Arrays.asList(output)));
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = user_id[i];
                dfs(user_id, output, visited, depth+1, n, r);
                visited[i] = false;
            }
        }
    }
    
    public boolean check(String banned_id, String user_id) {
        if(banned_id.length() != user_id.length()) {
            return false;
        }
        
        char[] bannedChar = banned_id.toCharArray();
        char[] userChar = user_id.toCharArray();
        
        for(int i = 0; i < banned_id.length(); i++) {
            if(bannedChar[i] == '*') {
                if(i == banned_id.length() - 1)
                    return true;
                else
                    continue;
            } else if(bannedChar[i] == userChar[i]) {
                if(i == banned_id.length() - 1)
                    return true;
                else
                    continue;
            } else {
                return false;
            }
        }
        return false;
    }
}