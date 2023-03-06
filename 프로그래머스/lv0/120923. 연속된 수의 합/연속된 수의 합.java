class Solution {
    public int[] solution(int num, int total) {
        int[] answer;
        answer = new int[num];
        total /= num;
        if(num % 2 == 1) {
            total -= num / 2;
        } else {
            total -= num / 2 - 1;
        }
        for(int i = 0; i < num; i++) {
            answer[i] = total;
            total++;
        }
        return answer;
    }
}