class Solution {
    
    static int length = 0;
    static int[] stoness;
    
    public int solution(int[] stones, int k) {
        
        int low = 1;
        int high = 200000001;
        length = stones.length;
        stoness = new int[stones.length];
        for(int i = 0; i < stones.length; i++) {
            stoness[i] = stones[i];
        }
        // System.out.println(check(3, k));
        while(low < high) {
            int mid = low + (high - low) / 2;
            
            if(!check(mid, k)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low - 1;
    }
    
    static boolean check(int value, int k) {
        int current = -1;
        
        while(current + k < length) {
            boolean b = false;
            for(int i = 1; i <= k; i++) {
                if(stoness[current + i] - value + 1 > 0) {
                    current += i;
                    b = true;
                    break;
                } else {
                    continue;
                }
            }
            if(!b) return false;
        }
        
        return true;
    }
}