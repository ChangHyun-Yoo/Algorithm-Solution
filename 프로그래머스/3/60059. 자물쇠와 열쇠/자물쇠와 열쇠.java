import java.util.*;
class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;
        
        int[][] temp = new int[M][M];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < M; j++) {
                temp[i][j] = key[i][j];
            }
        }
        if(find(temp, lock)) return true;
        
        // key를 시계 방향 90도 회전
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < M; j++) {
                temp[i][j] = key[j][M - i - 1];
            }
        }
        if(find(temp, lock)) return true;
        
        // key를 180도 회전
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < M; j++) {
                temp[i][j] = key[M - i - 1][M - j - 1];
            }
        }
        if(find(temp, lock)) return true;
        
        // key를 270도 회전
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < M; j++) {
                temp[i][j] = key[M - j - 1][i];
            }
        }
        if(find(temp, lock)) return true;
        
        return false;
    }
    
    static boolean find(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;
        
        for(int k = M - 1; k >= -N + 1; k--) {
            for(int l = M - 1; l >= -N + 1; l--) {
                boolean flag = false;
                loopI:
                for(int i = 0; i < N; i++) {
                    for(int j = 0; j < N; j++) {
                        int ni = i + k;
                        int nj = j + l;
                        
                        if(ni >= 0 && ni < M && nj >= 0 && nj < M) {
                            if(lock[i][j] + key[ni][nj] != 1) {
                                flag = true;
                                break loopI;
                            }
                        } else {
                            if(lock[i][j] != 1) {
                                flag = true;
                                break loopI;
                            }
                        }
                    }
                }
                if(flag) continue;
                else return true;
            }
        }
        
        return false;
    }
}