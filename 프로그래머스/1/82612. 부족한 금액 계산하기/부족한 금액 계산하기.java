class Solution {
    public long solution(int price, int money, int count) {
        long p = price;
        long m = money;
        long c = count;
        
        long r = c*(p + p*c) / 2;
        
        return (r - m < 0)? 0: r - m;
    }
}