import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> roads = new ArrayList<>();
        for(int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }
        int[] before = new int[N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            before[B]++;
            roads.get(A).add(B);
        }

        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < N + 1; i++) {
            if(before[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()) {
            int now = q.poll();

            sb.append(now).append(' ');

            for(int next: roads.get(now)) {
                if(--before[next] == 0) q.offer(next);
            }
        }

        System.out.print(sb.toString());
    }
}
