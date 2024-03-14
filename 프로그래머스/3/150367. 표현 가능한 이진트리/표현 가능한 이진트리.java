import java.util.*;
class Solution {
    
    static char[] chs;
    static boolean result;
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            answer[i] = findAnswer(numbers[i]);
        }
        return answer;
    }
    
    static int findAnswer(long n) {
        if(n == 1) return 1;
        
        String b = Long.toBinaryString(n);
        
        int i = 1;
        while(true) {
            if(Math.pow(2, i) - 1 >= b.length()) break;
            else i++;
        }
        
        long length = (long) Math.pow(2, i) - 1;
        
        while(b.length() != length) {
            b = "0" + b;
        }
        chs = b.toCharArray();
        
        result = true;
        start();
        if(result) return 1;
        else return 0;
    }
    
    static void start() {
        int start = chs.length / 2;
        
        if(chs[start] == '0') result = false;
        check(start, start / 2);
        check(start, 2*start - start / 2);
    }
    
    static void check(int parent, int child) {
        if(!result) return;
        
        if(chs[parent] == '0' && chs[child] == '1') result = false;
        
        if(Math.abs(parent - child) == 1) return;
        check(child, child - Math.abs(parent - child) / 2);
        check(child, child + Math.abs(parent - child) / 2);
    }
}