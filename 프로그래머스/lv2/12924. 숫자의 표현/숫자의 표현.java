class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int half = n / 2;
        
        for(int i = 0; i < n; i++) {
            int check = 0;
            for(int j = i + 1; j <= n; j++) {
                check += j;
                if(check == n) {
                    answer += 1;
                } else if(check > n) {
                    break;
                }
            }
        }
        
        return answer;
    }
}