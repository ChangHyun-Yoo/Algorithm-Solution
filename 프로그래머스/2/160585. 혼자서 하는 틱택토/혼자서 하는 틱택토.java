import java.util.*;
class Solution {
    public int solution(String[] board) {
        int answer = 0;
        
        int o = 0;
        int x = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length(); j++) {
                if(board[i].charAt(j) == 'O') o++;
                else if(board[i].charAt(j) == 'X') x++;
            }
        }
        
        if(!(o - x == 1 || o - x == 0)) return 0;
        
        int oNum = 0;
        int xNum = 0;
        //o
        if(board[0].charAt(0) == 'O' && board[0].charAt(1) == 'O' && board[0].charAt(2) == 'O') oNum++;
        if(board[1].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[1].charAt(2) == 'O') oNum++;
        if(board[2].charAt(0) == 'O' && board[2].charAt(1) == 'O' && board[2].charAt(2) == 'O') oNum++;
        
        if(board[0].charAt(0) == 'O' && board[1].charAt(0) == 'O' && board[2].charAt(0) == 'O') oNum++;
        if(board[0].charAt(1) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(1) == 'O') oNum++;
        if(board[0].charAt(2) == 'O' && board[1].charAt(2) == 'O' && board[2].charAt(2) == 'O') oNum++;
        
        if(board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O') oNum++;
        if(board[2].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[0].charAt(2) == 'O') oNum++;
        
        //x
        if(board[0].charAt(0) == 'X' && board[0].charAt(1) == 'X' && board[0].charAt(2) == 'X') xNum++;
        if(board[1].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[1].charAt(2) == 'X') xNum++;
        if(board[2].charAt(0) == 'X' && board[2].charAt(1) == 'X' && board[2].charAt(2) == 'X') xNum++;
        
        if(board[0].charAt(0) == 'X' && board[1].charAt(0) == 'X' && board[2].charAt(0) == 'X') xNum++;
        if(board[0].charAt(1) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(1) == 'X') xNum++;
        if(board[0].charAt(2) == 'X' && board[1].charAt(2) == 'X' && board[2].charAt(2) == 'X') xNum++;
        
        if(board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X') xNum++;
        if(board[2].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[0].charAt(2) == 'X') xNum++;
        
        if(oNum > xNum && o > x) answer = 1;
        if(xNum > oNum && o == x) answer = 1;
        if(oNum == xNum && oNum == 0) answer = 1;
        
        return answer;
    }
}