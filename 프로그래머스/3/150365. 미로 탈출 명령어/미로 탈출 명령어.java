import java.util.*;
class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int move = Math.abs(x - r) + Math.abs(y - c);
        if((k - move) % 2 != 0 || move > k) return "impossible";
        
        StringBuilder sb = new StringBuilder();
        int chance = (k - move) / 2;
        int curX = x;
        int curY = y;
        
        while(sb.length() < k) {
            if(curX < r) {
                sb.append('d');
                curX++;
                continue;
            }
            if(curY > c) {
                if(chance > 0) {
                    if(curX < n) {
                        curX++;
                        sb.append('d');
                        chance--;
                        continue;
                    }
                }
                sb.append('l');
                curY--;
                continue;
            }
            if(curY < c) {
                if(chance > 0) {
                    if(curX < n) {
                        curX++;
                        sb.append('d');
                        chance--;
                        continue;
                    }
                    if(curY > 1) {
                        curY--;
                        sb.append('l');
                        chance--;
                        continue;
                    }
                }
                sb.append('r');
                curY++;
                continue;
            }
            if(curX > r) {
                if(chance > 0) {
                    if(curX < n) {
                        curX++;
                        sb.append('d');
                        chance--;
                        continue;
                    }
                    if(curY > 1) {
                        curY--;
                        sb.append('l');
                        chance--;
                        continue;
                    }
                    if(curY < m) {
                        curY++;
                        sb.append('r');
                        chance--;
                        continue;
                    }
                }
                sb.append('u');
                curX--;
                continue;
            }
            
            chance--;
            if(curX < n) {
                curX++;
                sb.append('d');
                continue;
            }
            if(curY > 1) {
                curY--;
                sb.append('l');
                continue;
            }
            if(curY < m) {
                curY++;
                sb.append('r');
                continue;
            }
            if(curX > 1) {
                curY--;
                sb.append('u');
                continue;
            }
        }
        
        return sb.toString();
    }
}