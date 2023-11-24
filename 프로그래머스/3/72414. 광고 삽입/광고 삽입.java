import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTimeSec = timeToSec(play_time);
        long[] played = new long[playTimeSec];
        for(String log: logs) {
            String[] l = log.split("-");
            int start = timeToSec(l[0]);
            int end = timeToSec(l[1]);
            
            for(int i = start; i < end; i++) {
                played[i]++;
            }
        }
        
        long[] sum = new long[played.length + 1];
        long current = 0;
        for(int i = 1; i < sum.length; i++) {
            current += played[i - 1];
            sum[i] = current;
        }
        
        int advTimeSec = timeToSec(adv_time);
        
        long max = -1;
        int maxStart = -1;
        for(int i = 0; i + advTimeSec < sum.length; i++) {
            if(sum[i + advTimeSec] - sum[i] > max) {
                max = sum[i + advTimeSec] - sum[i];
                maxStart = i;
            }
        }
        
        return secToTime(maxStart);
    }
    
    static String secToTime(int time) {
        String answer = "";
        
        if(time / 3600 >= 0 && time / 3600 < 10) {
            answer += "0" + time / 3600;
        } else {
            answer += time / 3600;
        }
        time -= (time / 3600) * 3600;
        answer += ":";
        
        if(time / 60 >= 0 && time / 60 < 10) {
            answer += "0" + time / 60;
        } else {
            answer += time / 60;
        }
        time -= (time / 60) * 60;
        answer += ":";
        
        if(time >= 0 && time < 10) {
            answer += "0" + time;
        } else {
            answer += time;
        }
        
        return answer;
    }
    
    static int timeToSec(String time) {
        String[] strs = time.split(":");
        int hour = Integer.parseInt(strs[0]);
        int min = Integer.parseInt(strs[1]);
        int sec = Integer.parseInt(strs[2]);
        
        return hour*3600 + min*60 + sec;
    }
}