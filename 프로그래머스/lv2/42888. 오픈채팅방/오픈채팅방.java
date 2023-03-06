import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> user = new HashMap<>();
        
        List<List<String>> records = new ArrayList<>();
        
        for(String re: record) {
            String[] rec = re.split(" ");
            List<String> recc = new ArrayList<>();
            for(String r: rec) {
                recc.add(r);
            }
            records.add(recc);
        }
        
        int count = 0;
        for(List<String> re: records) {
            if(re.get(0).equals("Enter")) {
                if(user.get(re.get(1)) == null) {//처음 들어오는 사람일 때
                    user.put(re.get(1), re.get(2));
                } else {//나갔다 들어온 경우
                    user.replace(re.get(1), re.get(2));
                }
                count++;
            } else if(re.get(0).equals("Leave")) {
                count++;
                continue;
            } else {
                user.replace(re.get(1), re.get(2));
            }    
        }
        
        String[] answer = new String[count];
        
        int a = 0;
        for(List<String> re: records) {
            if(re.get(0).equals("Enter")) {
                answer[a] = user.get(re.get(1)) + "님이 들어왔습니다.";
            } else if(re.get(0).equals("Leave")) {
                answer[a] = user.get(re.get(1)) + "님이 나갔습니다.";
            } else {
                continue;
            }
            a++;
        }
        
        return answer;
    }
}