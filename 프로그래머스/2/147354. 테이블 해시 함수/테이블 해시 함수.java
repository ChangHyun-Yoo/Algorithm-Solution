import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[col - 1] == o2[col - 1]) {
                    return o2[0] - o1[0];
                } else {
                    return o1[col - 1] - o2[col - 1];
                }
            }
        });
        
        for(int i = 0; i < data[0].length; i++) {
            answer += data[row_begin - 1][i] % row_begin;
        }
        for(int i = row_begin; i < row_end; i++) {
            int val = 0;
            for(int j = 0; j < data[0].length; j++) {
                val += data[i][j] % (i + 1);
            }
            answer ^= val;
        }
        
        return answer;
    }
}