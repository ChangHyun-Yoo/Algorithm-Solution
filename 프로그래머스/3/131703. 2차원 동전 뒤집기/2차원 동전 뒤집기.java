import java.util.*;
class Solution {
    
    static int[][] current;
    static int[][] target;
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] beginning, int[][] target) {
        current = new int[beginning.length][beginning[0].length];
        for(int i = 0; i < beginning.length; i++) {
            for(int j = 0; j < beginning[0].length; j++) {
                if(beginning[i][j] != target[i][j])
                    current[i][j] = 1;
            }
        }
        int n = 0;
        for(int i = 0; i < beginning.length; i++) {
            if(current[i][0] == 1) {
                row(i);
                n++;
            }
        }
        
        for(int j = 0; j < beginning[0].length; j++) {
            if(current[0][j] == 1) {
                col(j);
                n++;   
            }
        }
        
        boolean check = false;
        for(int i = 0; i < beginning.length; i++) {
            for(int j = 0; j < beginning[0].length; j++) {
                if(current[i][j] == 1) {
                    check = true;
                    break;
                }
            }
            if(check) break;
        }
        
        if(!check) answer = Math.min(answer, n);
        
        current = new int[beginning.length][beginning[0].length];
        this.target = new int[beginning.length][beginning[0].length];
        for(int i = 0; i < beginning.length; i++) {
            for(int j = 0; j < beginning[0].length; j++) {
                if(beginning[i][j] != target[i][j])
                    current[i][j] = 1;
            }
        }
        
        n = 0;
        for(int i = 0; i < beginning.length; i++) {
            if(current[i][0] == 0) {
                row(i);
                n++;
            }
        }
        
        for(int j = 0; j < beginning[0].length; j++) {
            if(current[0][j] == 1) {
                col(j);
                n++;   
            }
        }
        
        check = false;
        for(int i = 0; i < beginning.length; i++) {
            for(int j = 0; j < beginning[0].length; j++) {
                if(current[i][j] == 1) {
                    check = true;
                    break;
                }
            }
            if(check) break;
        }
        
        if(!check) answer = Math.min(answer, n);
        
        current = new int[beginning.length][beginning[0].length];
        this.target = new int[beginning.length][beginning[0].length];
        for(int i = 0; i < beginning.length; i++) {
            for(int j = 0; j < beginning[0].length; j++) {
                if(beginning[i][j] != target[i][j])
                    current[i][j] = 1;
            }
        }
        
        n = 0;
        for(int j = 0; j < beginning[0].length; j++) {
            if(current[0][j] == 1) {
                col(j);
                n++;
            }
        }
        
        for(int i = 0; i < beginning.length; i++) {
            if(current[i][0] == 1) {
                row(i);
                n++;   
            }
        }
        
        check = false;
        for(int i = 0; i < beginning.length; i++) {
            for(int j = 0; j < beginning[0].length; j++) {
                if(current[i][j] == 1) {
                    check = true;
                    break;
                }
            }
            if(check) break;
        }
        
        if(!check) answer = Math.min(answer, n);
        
        n = 0;
        for(int j = 0; j < beginning[0].length; j++) {
            if(current[0][j] == 0) {
                col(j);
                n++;
            }
        }
        
        for(int i = 0; i < beginning.length; i++) {
            if(current[i][0] == 1) {
                row(i);
                n++;   
            }
        }
        
        check = false;
        for(int i = 0; i < beginning.length; i++) {
            for(int j = 0; j < beginning[0].length; j++) {
                if(current[i][j] == 1) {
                    check = true;
                    break;
                }
            }
            if(check) break;
        }
        
        if(!check) answer = Math.min(answer, n);
        
        if(answer == Integer.MAX_VALUE) return -1;
        else return answer;
    }
    
    static void row(int i) {
        for(int j = 0; j < current[0].length; j++) {
            if(current[i][j] == 1) current[i][j] = 0;
            else current[i][j] = 1;
        }
    }
    
    static void col(int j) {
        for(int i = 0; i < current.length; i++) {
            if(current[i][j] == 1) current[i][j] = 0;
            else current[i][j] = 1;
        }
    }
}