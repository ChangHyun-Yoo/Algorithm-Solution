import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        char[] chs = s.toCharArray();
        
        Stack<Character> stack = new Stack<Character>();
        stack.push(chs[0]);
        for(int i = 1; i < chs.length; i++) {
            if(stack.isEmpty()) {
                stack.push(chs[i]);
            }
            else if(stack.peek() == chs[i]) {
                stack.pop();
            } else {
                stack.push(chs[i]);
            }
        }
        
        if(stack.isEmpty()) {
            answer = 1;
        } else {
            answer = 0;
        }

        return answer;
    }
}