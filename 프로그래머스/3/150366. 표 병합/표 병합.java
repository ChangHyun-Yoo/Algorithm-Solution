import java.util.*;
class Solution {
    
    static String[] current = new String[2500];
    static int[] parent = new int[2500];
    
    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();
        Arrays.fill(current, "");
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        
        for(String command: commands) {
            String[] splited = command.split(" ");
            
            if(splited[0].equals("UPDATE") && splited.length == 4) {
                int r = Integer.parseInt(splited[1]);
                int c = Integer.parseInt(splited[2]);
                String value = splited[3];
                
                int root = findRoot(convert(r, c));
                
                current[root] = value;
            } else if(splited[0].equals("UPDATE") && splited.length == 3) {
                String value1 = splited[1];
                String value2 = splited[2];

                for(int i = 0; i < current.length; i++) {
                    if(current[i].equals(value1)) current[i] = value2;
                }
            } else if(splited[0].equals("MERGE")) {
                int r1 = Integer.parseInt(splited[1]);
                int c1 = Integer.parseInt(splited[2]);
                int r2 = Integer.parseInt(splited[3]);
                int c2 = Integer.parseInt(splited[4]);
                int root1 = findRoot(convert(r1, c1));
                int root2 = findRoot(convert(r2, c2));
                
                if(root1 == root2) continue;
                
                String rootString = current[root1].isBlank()? current[root2]: current[root1];
                
                current[root1] = rootString;
                union(root1, root2);
            } else if(splited[0].equals("UNMERGE")) {
                int r = Integer.parseInt(splited[1]);
                int c = Integer.parseInt(splited[2]);
                int root = findRoot(convert(r, c));
                String v = current[root];
                
                List<Integer> delete = new ArrayList<>();
                for(int i = 0; i < 2500; i++) {
                    if(findRoot(i) == root) {
                        delete.add(i);
                    }
                }
                
                for(int d: delete) {
                    current[d] = "";
                    parent[d] = d;
                }
                current[convert(r, c)] = v;
            } else {
                int r = Integer.parseInt(splited[1]);
                int c = Integer.parseInt(splited[2]);
                int root = findRoot(convert(r, c));
                
                if(current[root].isBlank()) answer.add("EMPTY");
                else answer.add(current[root]);
            }
        }
        
        String[] r = new String[answer.size()];
        for(int i = 0; i < r.length; i++) {
            r[i] = answer.get(i);
        }
        return r;
    }
    
    static int convert(int r, int c) {
        return (r - 1) * 50 + (c - 1);
    }
    
    static int findRoot(int i) {
        if(i == parent[i]) return i;
        
        return parent[i] = findRoot(parent[i]);
    }
    
    static void union(int i, int j) {
        int rootI = findRoot(i);
        int rootJ = findRoot(j);
        
        parent[rootJ] = rootI;
    }
}