import java.util.*;
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int[][] value = new int[board.length + 1][board[0].length + 1];
        int[][] sums = new int[board.length + 1][board[0].length + 1];
        
        for(int i = 0; i < skill.length; i++) {
            int startRow = skill[i][1];
            int endRow = skill[i][3];
            int startCol = skill[i][2];
            int endCol = skill[i][4];
            int s = 0;
            if(skill[i][0] == 2) {
                s = skill[i][5];
            } else {
                s = -skill[i][5];
            }
            value[startRow][startCol] += s;
            value[startRow][endCol + 1] -= s;
            value[endRow + 1][startCol] -= s;
            value[endRow + 1][endCol + 1] += s;
        }
        
        for(int i = 0; i < value.length; i++) {
            int sum = 0;
            for(int j = 0; j < value[0].length; j++) {
                sum += value[i][j];
                sums[i][j] = sum;
            }
        }
        
        for(int i = 0; i < value[0].length; i++) {
            int sum = 0;
            for(int j = 0; j < value.length; j++) {
                sum += sums[j][i];
                sums[j][i] = sum;
            }
        }
        
        int answer = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] + sums[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}