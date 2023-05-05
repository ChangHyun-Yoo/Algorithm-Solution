import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 1; i < N + 1; i++) {
            dq.offer(i);
        }

        while(dq.size() > 1) {
            dq.pollFirst();
            if(dq.size() == 1) {
                break;
            }
            int n = dq.pollFirst();
            dq.addLast(n);
        }
        System.out.println(dq.pollFirst());
    }
}