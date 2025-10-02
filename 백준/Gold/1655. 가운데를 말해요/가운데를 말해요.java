import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());

            if(i == 0) {
                left.offer(value);
                sb.append(value).append('\n');
            } else if(i == 1) {
                if(value < left.peek()) {
                    right.offer(left.poll());
                    left.offer(value);
                } else {
                    right.offer(value);
                }
                sb.append(left.peek()).append('\n');
            } else {
                // 현재 짝수개이면
                if(i % 2 == 0) {
                    if(value <= right.peek()) {
                        left.offer(value);
                    } else {
                        left.offer(right.poll());
                        right.offer(value);
                    }
                    sb.append(left.peek()).append('\n');
                }
                // 현재 홀수개이면
                else {
                    if(value < left.peek()) {
                        right.offer(left.poll());
                        left.offer(value);
                    } else {
                        right.offer(value);
                    }
                    sb.append(left.peek()).append('\n');
                }
            }
        }

        System.out.print(sb.toString());

    }
}
