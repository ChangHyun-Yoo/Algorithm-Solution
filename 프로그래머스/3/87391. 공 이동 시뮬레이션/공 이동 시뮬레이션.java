import java.util.*;
class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long sx = x;
        long sy = y;
        long ex = x + 1;
        long ey = y + 1;
        
        for(int i = queries.length - 1; i >= 0; i--) {
            int command = queries[i][0];
            int dx = queries[i][1];
            
            // 왼쪽 -> 오른쪽
            if(command == 0) {
                // sy
                if(sy != 0) {
                    if(sy + dx >= m) {
                        return 0L;
                    } else {
                        sy += dx;
                    }
                }
                // ey
                ey = Math.min(ey + dx, m);
            }
            // 오른쪽 -> 왼쪽
            else if(command == 1) {
                // sy
                sy = Math.max(sy - dx, 0);
                // ey
                if(ey != m) {
                    if(ey - dx <= 0) {
                        return 0L;
                    } else {
                        ey -= dx;
                    }
                }
            }
            // 위쪽 -> 아래쪽
            else if(command == 2) {
                // sx
                if(sx != 0) {
                    if(sx + dx >= n) {
                        return 0L;
                    } else {
                        sx += dx;
                    }
                }
                // ex
                ex = Math.min(ex + dx, n);
            }
            // 아래쪽 -> 위쪽
            else {
                // sx
                sx = Math.max(sx - dx, 0);
                // ex
                if(ex != n) {
                    if(ex - dx <= 0) {
                        return 0L;
                    } else {
                        ex -= dx;
                    }
                }
            }
            
            // System.out.println("sx = " + sx + ", sy = " + sy);
            // System.out.println("ex = " + ex + ", ey = " + ey);
        }
        
        return (ex - sx) * (ey - sy);
    }
}