import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {

        int answer = 0;
        
        int[][] map = new int[N+1][N+1];
        
        for(int i =0; i<map.length; i++) {
            for(int j =0; j<map[0].length; j++) {
                if(i != j) {
                    map[i][j] = 500001; // 음식 배달이 가능한 시간이 1 ~ 500000이므로, 500001로 초기화
                }
            }
        }
        
        for(int i =0; i<road.length; i++) {
            if(map[road[i][0]-1][road[i][1]-1] < road[i][2]) { // 주어진 시간보다 이전에 들어가 있었떤 시간이 더 작으면 -> 최단경로이므로 무시
                continue;
            }
            map[road[i][0]-1][road[i][1]-1] = road[i][2]; // 각 노드끼리 이동하는데 걸리는 시간
            map[road[i][1]-1][road[i][0]-1] = road[i][2];
        }
        
        for(int k =0; k < N; k++) {
            for(int i =0; i < N; i++) {
                for(int j =0; j < N; j++) {
                    if(map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        
        for(int[] ma: map) {
            System.out.println(Arrays.toString(ma));
        }
        for(int i = 0; i<map.length; i++) {
            if(map[0][i] <= K) {
                answer++;
            }
        }
 
        return answer;
    }
}