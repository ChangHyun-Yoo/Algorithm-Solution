import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> nexts = new ArrayList<>();
    static int[] beforeNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N + 1; i++) {
            nexts.add(new ArrayList<>());
        }
        beforeNum = new int[N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int b = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            nexts.get(b).add(a);
            beforeNum[a]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i < N + 1; i++) {
            if(beforeNum[i] == 0) {
                pq.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            int now = pq.poll();
            sb.append(now + " ");

            for(int next: nexts.get(now)) {
                beforeNum[next]--;
                if(beforeNum[next] == 0) {
                    pq.offer(next);
                }
            }
        }
        System.out.println(sb);
    }

}
