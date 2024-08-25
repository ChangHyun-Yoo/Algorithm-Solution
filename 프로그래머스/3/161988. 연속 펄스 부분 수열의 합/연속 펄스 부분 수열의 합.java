import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        long[] sum1 = new long[sequence.length + 1];
        long[] sum2 = new long[sequence.length + 1];
        for(int i = 0; i < sequence.length; i++) {
            if(i % 2 == 0) {
                sum1[i + 1] = sum1[i] + sequence[i];
            } else {
                sum1[i + 1] = sum1[i] - sequence[i];
            }
            sum2[i + 1] = -sum1[i + 1];
        }
        
        long[][] m1 = new long[sequence.length][2];
        for(int i = 1; i < m1.length; i++) {
            m1[i][0] = Math.min(m1[i - 1][0], sum1[i]);
        }
        m1[m1.length - 1][1] = sum1[sum1.length - 1];
        for(int i = m1.length - 2; i >= 0; i--) {
            m1[i][1] = Math.max(sum1[i + 1], m1[i + 1][1]);
        }
        
        long[][] m2 = new long[sequence.length][2];
        for(int i = 1; i < m2.length; i++) {
            m2[i][0] = Math.min(m2[i - 1][0], sum2[i]);
        }
        m2[m2.length - 1][1] = sum2[sum2.length - 1];
        for(int i = m2.length - 2; i >= 0; i--) {
            m2[i][1] = Math.max(sum2[i + 1], m2[i + 1][1]);
        }
        
        long answer = Long.MIN_VALUE;
        for(long[] m: m1) {
            answer = Math.max(answer, m[1] - m[0]);
        }
        
        for(long[] m: m2) {
            answer = Math.max(answer, m[1] - m[0]);
        }
        
        return answer;
    }
}