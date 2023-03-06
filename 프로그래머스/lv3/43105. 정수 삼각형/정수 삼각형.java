import java.util.*;

class Solution {
    public int max = -1;
    
    public int solution(int[][] triangle) {
        
        for(int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i-1][0];
            for(int j = 1; j < i; j++) {
                int max = (triangle[i-1][j-1] > triangle[i-1][j]) ? triangle[i-1][j-1] : triangle[i-1][j];
                triangle[i][j] += max;
            }
            triangle[i][i] += triangle[i-1][i-1];
        }
        
        for(int a:triangle[triangle.length - 1]) {
            if(a > max)
                max = a;
        }
        
        return max;
    }
}