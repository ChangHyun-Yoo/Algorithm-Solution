import java.util.*;
class Solution {
    public int solution(int[] a) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] latest = new int[a.length];
        boolean[] included = new boolean[a.length];
        int[] nums = new int[a.length];
        Arrays.fill(latest, -1);
        
        for(int i = 0; i < a.length; i++) {
            // 처음 나오는 수 이면
            if(map.get(a[i]) == null) {
                map.put(a[i], i);
                if(i == 0) {
                    included[i] = false;
                    nums[i] = 0;
                } else {
                    included[i] = true;
                    nums[i] = 1;
                }
            } else {
                latest[i] = map.get(a[i]);
                int dif = i - latest[i];
                // 바로 옆에 있을 때
                if(dif == 1) {
                    included[i] = false;
                    nums[i] = nums[latest[i]];
                }
                // 사이에 하나일 때
                else if(dif == 2) {
                    // 이전 수가 포함 되었을 경우
                    if(included[latest[i]]) {
                        included[i] = true;
                    } else {
                        included[i] = false;
                    }
                    nums[i] = nums[latest[i]] + 1;
                }
                // 사이에 두 개 이상일 때
                else {
                    // 이전 수가 포함 되었을 경우
                    if(included[latest[i]]) {
                        included[i] = true;
                        nums[i] = nums[latest[i]] + 1;
                    } else {
                        included[i] = true;
                        nums[i] = nums[latest[i]] + 2;
                    }
                }
                map.replace(a[i], i);
            }
        }
        
        Set<Integer> checked = new HashSet<>();
        checked.add(a[a.length - 1]);
        answer = Math.max(answer, nums[a.length - 1]);
        for(int i = a.length - 2; i >= 0; i--) {
            if(!checked.contains(a[i]) && !included[i]) {
                nums[i]++;
            }
            checked.add(a[i]);
            answer = Math.max(answer, nums[i]);
        }
        
        return answer * 2;
    }
}