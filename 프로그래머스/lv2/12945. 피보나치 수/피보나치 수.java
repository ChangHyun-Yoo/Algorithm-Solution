class Solution {
    public int solution(int n) {
        return fibo(n);
    }
    
    public int fibo(int input) {
        int[] list = new int[input + 1];
        list[0] = 0;
        list[1] = 1;
        for(int i = 2; i < input + 1; i++) {
            list[i] = (list[i-1] % 1234567 + list[i-2] % 1234567) % 1234567;
        }
        return list[input];
    }
}