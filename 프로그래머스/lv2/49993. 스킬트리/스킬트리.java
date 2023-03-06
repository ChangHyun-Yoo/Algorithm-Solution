import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        List<String> origin = new ArrayList<>();
        for(int i = 0; i < skill.length(); i++) {
            origin.add(skill.substring(i, i + 1));
        }
        
        for(String ski: skill_trees) {
            String modSkill = "";
            for(int i = 0; i < ski.length(); i++) {
                if(origin.contains(ski.substring(i, i + 1))) {
                    modSkill += ski.substring(i, i + 1);
                }
            }
            boolean check = false;
            for(int i = 0; i < modSkill.length(); i++) {
                if(!modSkill.substring(i, i + 1).equals(skill.substring(i, i + 1))) {
                    check = true;
                    break;
                }
            }
            if(!check) {
                answer++;
            }
        }
        return answer;
    }
}