class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++) {
            for(int j = i + 1; j < prices.length; j++) {
                if(prices[j] < prices[i] || j == prices.length - 1) {
                    answer[i] = j - i;
                    break;
                } else {
                    continue;
                }
            }
        }
        return answer;
    }
}