import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int n = 0; n < N; n++) {
            String s = br.readLine();

            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < s.length(); i++) {
                if(stack.isEmpty()) {
                    stack.push(s.charAt(i));
                    continue;
                }

                if(s.charAt(i) == '(') {
                    stack.push('(');
                } else {
                    if(stack.peek() == '(') {
                        stack.pop();
                    } else if(stack.peek() == null) {
                        sb.append("NO").append('\n');
                        break;
                    } else {
                        stack.push(')');
                    }
                }
            }
            if(stack.isEmpty()) {
                sb.append("YES").append('\n');
            } else
                sb.append("NO").append('\n');
        }
        System.out.println(sb);
    }
}