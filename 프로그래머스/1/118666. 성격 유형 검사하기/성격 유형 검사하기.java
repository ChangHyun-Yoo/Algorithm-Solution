import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        // RT, FC, MJ, AN => 양수이면 R, F, M, A
        int[] index = new int[4];
        
        for(int i = 0; i < survey.length; i++) {
            if(survey[i].equals("RT")) {
                index[0] -= choices[i] - 4;
            } else if(survey[i].equals("TR")) {
                index[0] += choices[i] - 4;
            }  else if(survey[i].equals("FC")) {
                index[1] -= choices[i] - 4;
            }  else if(survey[i].equals("CF")) {
                index[1] += choices[i] - 4;
            }  else if(survey[i].equals("MJ")) {
                index[2] -= choices[i] - 4;
            }  else if(survey[i].equals("JM")) {
                index[2] += choices[i] - 4;
            }  else if(survey[i].equals("AN")) {
                index[3] -= choices[i] - 4;
            }  else if(survey[i].equals("NA")) {
                index[3] += choices[i] - 4;
            } 
        }
        
        String answer = "";
        if(index[0] > 0)
            answer += "R";
        else if(index[0] < 0)
            answer += "T";
        else
            answer += "R";
        
        if(index[1] > 0)
            answer += "F";
        else if(index[1] < 0)
            answer += "C";
        else
            answer += "C";
        
        if(index[2] > 0)
            answer += "M";
        else if(index[2] < 0)
            answer += "J";
        else
            answer += "J";
        
        if(index[3] > 0)
            answer += "A";
        else if(index[3] < 0)
            answer += "N";
        else
            answer += "A";
        
        return answer;
    }
}