import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] before = new int[N + 1];
        int[] answer = new int[N + 1];
        List<List<Integer>> roads = new ArrayList<>();
        for(int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            roads.get(A).add(B);
            before[B]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < before.length; i++) {
            if(before[i] == 0) q.offer(i);
        }

        int semester = 1;
        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                int now = q.poll();
                answer[now] = semester;

                for(int next: roads.get(now)) {
                    if(--before[next] == 0) q.offer(next);
                }
            }

            semester++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < answer.length; i++) {
            sb.append(answer[i]).append(' ');
        }

        System.out.print(sb.toString());
    }
}
