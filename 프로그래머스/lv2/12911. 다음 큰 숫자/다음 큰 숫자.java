class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int how = Integer.bitCount(n);
        int a = n + 1;
        while(true) {
            if(how == Integer.bitCount(a)) {
                break;
            }
            a += 1;
        }
        return a;
    }
    
}