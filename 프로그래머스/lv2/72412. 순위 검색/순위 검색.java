import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        Map<String, List<Integer>> infos = new HashMap<>();
        
        for(String i: info) {
            String[] inf = i.split(" ");
            List<String> in = new ArrayList<>();
            for(int it = 0; it < 8; it++) {
                if(it % 2 == 0) {
                    in.add(inf[it / 2]);
                } else {
                    in.add("-");
                }
            }
            for(int j = 0; j < 2; j++) {
                for(int k = 2; k < 4; k++) {
                    for(int l = 4; l < 6; l++) {
                        for(int m = 6; m < 8; m++) {
                            String key = in.get(j) + in.get(k) + in.get(l) + in.get(m);
                            if(infos.get(key) == null) {
                                List<Integer> value = new ArrayList<>();
                                value.add(Integer.parseInt(inf[4]));
                                infos.put(key, value);
                            } else {
                                infos.get(key).add(Integer.parseInt(inf[4]));
                            }
                        }
                    }
                }
            }
        }
        
        Set<String> keySet = infos.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        while(keyIterator.hasNext()) {
            String key = keyIterator.next();
            Collections.sort(infos.get(key));
        }
        
        List<Integer> ans = new ArrayList<>();
        for(String que: query) {
            String[] q = que.split(" and | ");
            String word = q[0] + q[1] + q[2] + q[3];
            int score = Integer.parseInt(q[4]);
            
            if(infos.get(word) == null) {
                ans.add(0);
            } else {
                List<Integer> scores = infos.get(word);
                int low = 0;
                int high = scores.size();

                while(low < high) {
                    int mid = (low + high) / 2;

                    if(score <= scores.get(mid)) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }
                ans.add(scores.size() - low);
            }
        }
        
        for(int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}