import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Node> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());

            if(stack.isEmpty()) {
                sb.append(0).append(' ');
                stack.add(new Node(i, height));
                continue;
            }

            // 자신보다 크거나 같은 탑을 만날 때까지 제거
            while(!stack.isEmpty() && stack.peek().height < height) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                sb.append(0).append(' ');
                stack.add(new Node(i, height));
            } else {
                sb.append(stack.peek().index).append(' ');
                stack.add(new Node(i, height));
            }
        }

        System.out.print(sb.toString());
    }

    static class Node {
        int index;
        int height;

        public Node(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}
