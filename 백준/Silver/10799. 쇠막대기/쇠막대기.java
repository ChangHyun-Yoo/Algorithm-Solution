import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chs = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chs.length; i++) {
            if(chs[i] == ')') {
                if(stack.peek() == '(') {
                    stack.pop();
                    stack.push('1');
                } else {
                    stack.push(chs[i]);
                }
            } else {
                stack.push(chs[i]);
            }
        }

        int current = 0;
        int answer = 0;
        while(!stack.isEmpty()) {
            char p = stack.pop();

            if(p == ')') {
                current++;
            } else if(p == '1') {
                answer += current;
            } else {
                answer++;
                current--;
            }
        }
        System.out.println(answer);
    }
}