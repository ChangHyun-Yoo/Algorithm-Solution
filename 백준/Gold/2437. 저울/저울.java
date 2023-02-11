import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }

        if(pq.peek() != 1) {
            System.out.println(1);
            return;
        }

        long min = pq.poll();//1
        long max = min;//1
        long answer = 0;
        while(!pq.isEmpty()) {
            long polled = pq.poll();
            if(polled == max + 1) {
                if(min + polled > max + 2) {
                    answer = max + 2;
                    break;
                } else {
                    max += polled;
                }
            } else {
                if(max - min >= polled - 1) {
                    max += polled;
                } else {//측정 불가능한 게 나타날 때
                    answer = max + 1;
                    break;
                }
            }
        }
        if(answer == 0) {
            System.out.println(max + 1);
        } else {
            System.out.println(answer);
        }
    }
}