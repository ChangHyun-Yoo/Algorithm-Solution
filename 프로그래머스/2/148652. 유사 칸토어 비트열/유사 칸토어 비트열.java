class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        
        for(long i = l - 1; i <= r - 1; i++) {
            
            int nn = n;
            long div = (long) Math.pow(5, nn - 1);
            if(i >= div * 2 && i < div * 3) continue;
            long j = i / div;
            long ii = i;
            
            boolean check = false;
            while(nn != 1) {
                nn--;
                if(ii >= div * 2 && ii < div * 3) {
                    check = true;
                    break;
                }
                ii = ii - ((ii / div) * div);
                div /= 5;
            }
            
            if(check) continue;
            
            if(ii != 2) {
                answer++;
            }
        }
        
        return answer;
    }
}