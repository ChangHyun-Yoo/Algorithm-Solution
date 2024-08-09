import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        
        int answer = 1;
        int max = targets[0][1];
        for(int i = 1; i < targets.length; i++) {
            if(targets[i][0] >= max) {
                answer++;
                max = targets[i][1];
            }
        }
        return answer;
    }
}