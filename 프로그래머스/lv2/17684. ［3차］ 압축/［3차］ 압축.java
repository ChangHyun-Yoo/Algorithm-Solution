import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dic = new HashMap<>();
        
        dic.put("A", 1);
        dic.put("B", 2);
        dic.put("C", 3);
        dic.put("D", 4);
        dic.put("E", 5);
        dic.put("F", 6);
        dic.put("G", 7);
        dic.put("H", 8);
        dic.put("I", 9);
        dic.put("J", 10);
        dic.put("K", 11);
        dic.put("L", 12);
        dic.put("M", 13);
        dic.put("N", 14);
        dic.put("O", 15);
        dic.put("P", 16);
        dic.put("Q", 17);
        dic.put("R", 18);
        dic.put("S", 19);
        dic.put("T", 20);
        dic.put("U", 21);
        dic.put("V", 22);
        dic.put("W", 23);
        dic.put("X", 24);
        dic.put("Y", 25);
        dic.put("Z", 26);
        
        int dictLast = 26;
        int index = 0;
        int maxLength = 1;
        List<Integer> result = new ArrayList<>();
        while(index < msg.length()) {
            int last = index + maxLength;
            while(true) {
                if(dic.get(msg.substring(index, Math.min(last, msg.length()))) != null) {
                    if(dic.get(msg.substring(index, Math.min(last, msg.length()))) == 43) {
                        System.out.println(msg.substring(index, Math.min(last, msg.length())));
                    }
                    result.add(dic.get(msg.substring(index, Math.min(last, msg.length()))));
                    break;
                } else {
                    last -= 1;
                }
            }
            int tempIndex = index;
            index += msg.substring(index, Math.min(last, msg.length())).length();
            if(index >= msg.length()) {
                break;
            }
            dictLast += 1;
            dic.put(msg.substring(tempIndex, Math.min(last, msg.length()) + 1), dictLast);
            maxLength = Math.max(maxLength, msg.substring(tempIndex, Math.min(last, msg.length()) + 1).length());
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}