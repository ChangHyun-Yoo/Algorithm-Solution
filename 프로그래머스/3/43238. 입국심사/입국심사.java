class Solution {
    public long solution(int n, int[] times) {
        
        long low = 1L;
        long high = 1000000000000000000L;
        
        while(low < high) {
            long mid = low + (high - low) / 2;
            
            long man = 0;
            for(int time: times) {
                man += mid / time;
            }
            
            if(man >= n) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}