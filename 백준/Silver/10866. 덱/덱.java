import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();
            switch (cmd) {
                case "push_front":
                    dq.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    dq.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if(dq.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(dq.pollFirst()).append('\n');
                    break;
                case "pop_back":
                    if(dq.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(dq.pollLast()).append('\n');
                    break;
                case "size":
                    sb.append(dq.size()).append('\n');
                    break;
                case "empty":
                    if(dq.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "front":
                    if(dq.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(dq.peekFirst()).append('\n');
                    break;
                case "back":
                    if(dq.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(dq.peekLast()).append('\n');
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}