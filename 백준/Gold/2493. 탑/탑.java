import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Node> stack = new Stack<>();
        stack.push(new Node(Integer.parseInt(st.nextToken()), 1));
        sb.append(0).append(' ');
        for(int i = 2; i < N + 1; i++) {
            int current = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek().num <= current) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                sb.append(0).append(' ');
            } else {
                sb.append(stack.peek().index).append(' ');
            }
            stack.push(new Node(current, i));
        }

        System.out.println(sb);
    }

    static class Node {
        int num;
        int index;

        public Node(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }
}
