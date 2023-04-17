import java.io.*;
import java.util.*;

public class Main {

    static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            if(s.length() >= 6) {
                deque.addLast(Integer.parseInt(s.split(" ")[1]));
                continue;
            }

            if(s.equals("front")) {
                if(deque.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(deque.peekFirst()).append('\n');
                }
            } else if(s.equals("back")) {
                if(deque.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(deque.peekLast()).append('\n');
                }
            } else if(s.equals("pop")) {
                if(deque.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(deque.pollFirst()).append('\n');
                }
            } else if(s.equals("size")) {
                sb.append(deque.size()).append('\n');
            } else if(s.equals("empty")) {
                if(deque.isEmpty()) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }
}