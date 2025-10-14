import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] before = new int[N + 1];
        List<List<Integer>> roads = new ArrayList<>();
        for(int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            roads.get(S).add(E);
            before[E]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i < before.length; i++) {
            if(before[i] == 0) pq.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            int now = pq.poll();

            sb.append(now).append(' ');

            for(int next: roads.get(now)) {
                if(--before[next] == 0) {
                    pq.offer(next);
                }
            }
        }

        System.out.print(sb.toString());
    }
}
