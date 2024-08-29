class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i = 0; i < balls.length; i++) {
            int[] ball = balls[i];
            
            int min = Integer.MAX_VALUE;
            // x축 대칭
            if(!(startX == ball[0] && startY >= ball[1]))
                min = Math.min(min, (startX - ball[0])*(startX - ball[0]) + (startY + ball[1])*(startY + ball[1]));
            if(!(startY == ball[1] && startX >= ball[0]))
                min = Math.min(min, (startX + ball[0])*(startX + ball[0]) + (startY - ball[1])*(startY - ball[1]));
            if(!(startX == ball[0] && startY <= ball[1]))
                min = Math.min(min, (startX - ball[0])*(startX - ball[0]) + (2*n - startY - ball[1])*(2*n - startY - ball[1]));
            if(!(startY == ball[1] && startX <= ball[0]))
                min = Math.min(min, (2*m - startX - ball[0])*(2*m - startX - ball[0]) + (startY - ball[1])*(startY - ball[1]));
            
            answer[i] = min;
        }
        
        return answer;
    }
}