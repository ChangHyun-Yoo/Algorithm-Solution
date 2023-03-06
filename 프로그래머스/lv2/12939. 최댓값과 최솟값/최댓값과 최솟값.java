class Solution {
    public String solution(String s) {
        String answer = "";
        String[] splited_str = s.split(" ");
        int min = 10000;
        int max = -10000;
        for(String a: splited_str) {
            int test = Integer.parseInt(a);
            if (test < min) {
                min = test;
            }
            if (test > max) {
                max = test;
            }
        }
        answer = Integer.toString(min) + " " + Integer.toString(max);
        return answer;
    }
}