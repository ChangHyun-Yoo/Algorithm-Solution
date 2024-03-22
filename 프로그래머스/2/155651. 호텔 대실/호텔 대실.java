class Solution {
    
    public int solution(String[][] book_time) {
        
        int[] num = new int[2000];
        
        for(String[] bt: book_time) {
            String[] splited1 = bt[0].split(":");
            String[] splited2 = bt[1].split(":");
            int start = Integer.parseInt(splited1[0])*60 + Integer.parseInt(splited1[1]);
            int end = Integer.parseInt(splited2[0])*60 + Integer.parseInt(splited2[1]) + 10;
            
            num[start]++;
            num[end]--;
        }
        
        int max = -1;
        int sum = 0;
        for(int i = 0; i < num.length; i++) {
            sum += num[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}