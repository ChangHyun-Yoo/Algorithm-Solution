import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<AbsInteger> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if(n == 0) {
                if(pq.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(pq.poll().value).append('\n');
                }
            } else {
                pq.offer(new AbsInteger(n));
            }
        }
        System.out.println(sb);
    }

    static class AbsInteger implements Comparable<AbsInteger> {
        int value;

        public AbsInteger(int value) {
            this.value = value;
        }

        public int compareTo(AbsInteger o) {
            if(Math.abs(this.value) == Math.abs(o.value)) {
                return this.value - o.value;
            } else {
                return Math.abs(this.value) - Math.abs(o.value);
            }
        }
    }
}