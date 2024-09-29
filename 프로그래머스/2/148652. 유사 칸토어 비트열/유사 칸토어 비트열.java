class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        
        for(long i = l - 1; i <= r - 1; i++) {
            answer += check(n, i);
        }
        
        return answer;
    }
    
    // n번째 비트열의 i번째 값
    static int check(int n, long i) {
        if(n == 1) {
            if(i == 2) return 0;
            else return 1;
        }
        
        long div = (long) Math.pow(5, n - 1);
        if(div * 2 <= i && i < div * 3) return 0;
        else return check(n - 1, i % div);
    }
}