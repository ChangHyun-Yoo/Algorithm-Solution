import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        
        String newM = change(m);
        
        List<List<String>> infos = new ArrayList<>();
        
        List<List<String>> candidates = new ArrayList<>();
        
        for(String info:musicinfos) {
            List<String> lst = new ArrayList<>();
            String[] infoss = info.split(",");
            int beforeHour = Integer.parseInt(infoss[0].split(":")[0]);
            int beforeMin = Integer.parseInt(infoss[0].split(":")[1]);
            int afterHour = Integer.parseInt(infoss[1].split(":")[0]);
            int afterMin = Integer.parseInt(infoss[1].split(":")[1]);
            
            if(afterMin < beforeMin) {
                afterHour -= 1;
                afterMin += 60;
            }
            int abs = (afterHour - beforeHour) * 60 + afterMin - beforeMin;
            
            String result = "";
            char[] mel = change(infoss[3]).toCharArray();
            for(int i = 0; i < abs; i++) {
                result += mel[i % mel.length];
            }
            lst.add(infoss[2]);
            lst.add(result);
            lst.add(Integer.toString(abs));
            
            infos.add(lst);
        }
        
        for(int i = 0; i < infos.size(); i++) {
            List<String> candidate = new ArrayList<>();
            if(infos.get(i).get(1).contains(newM)) {
                candidate.add(infos.get(i).get(0));
                candidate.add(infos.get(i).get(2));
                candidates.add(candidate);
            }
        }
        
        if(candidates.size() == 0) {
            answer = "(None)";
        } else {
            int max = 0;
            for(List<String> a: candidates) {
                if(Integer.parseInt(a.get(1)) > max) {
                    max = Integer.parseInt(a.get(1));
                    answer = a.get(0);
                }
            }
        }
        
        return answer;
    }
    
    public String change(String input) {
        char[] ch = input.toCharArray();
        List<Character> chs = new ArrayList<>();
        for(int i = 0; i < ch.length; i++) {
            if(i < ch.length - 1 && ch[i + 1] == '#') {
                chs.add(Character.toLowerCase(ch[i]));
                i += 1;
            } else {
                chs.add(ch[i]);
            }
        }
        
        char[] newCh = new char[chs.size()];
        for(int i = 0; i < newCh.length; i++) {
            newCh[i] = chs.get(i);
        }
        
        return new String(newCh);
    }
}