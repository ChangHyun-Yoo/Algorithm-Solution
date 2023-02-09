import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String num = br.readLine();
        char[] chars = num.toCharArray();

        Deque<Character> deque = new ArrayDeque<>();
        for(int i = 0; i < N; i++) {

            while(K > 0 && !deque.isEmpty() && deque.getLast() < chars[i]) {
                deque.removeLast();
                K--;
            }
            deque.addLast(chars[i]);
        }

        StringBuilder sb = new StringBuilder();

        while(deque.size() > K) {
            sb.append(deque.removeFirst());
        }

        System.out.println(sb);
    }
}