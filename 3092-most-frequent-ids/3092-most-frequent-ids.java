import java.util.*;
class Solution {
    
    static long[] info;
    
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        info = new long[100001];
        long[] answer = new long[nums.length];
        
        Map<Long, Long> m = new HashMap<>();
        TreeSet<Long> ts = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
            
            Long now = m.get(info[nums[i]]);
            if(now != null) {
                if(now == 1L) {
                    m.remove(info[nums[i]]);
                    ts.remove(info[nums[i]]);
                } else {
                    m.replace(info[nums[i]], now - 1L);
                }
            }
            
            info[nums[i]] += freq[i];
            Long after = m.get(info[nums[i]]);
            
            if(after == null) {
                m.put(info[nums[i]], 1L);
            } else {
                m.replace(info[nums[i]], after + 1L);
            }
            ts.add(info[nums[i]]);
            
            answer[i] = ts.last();
        }
        
        return answer;
    }
}