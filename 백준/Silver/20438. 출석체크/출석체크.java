import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] students = new boolean[N + 3];
        boolean[] visited = new boolean[N + 3];
        Set<Integer> sleep = new HashSet<>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < K; i++) {
            sleep.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < Q; i++) {
            int code = Integer.parseInt(st.nextToken());

            Queue<Integer> q = new LinkedList<>();
            q.offer(code);

            while(!q.isEmpty()) {
                int current = q.poll();

                if(sleep.contains(current) || visited[current]) continue;
                students[current] = true;
                visited[current] = true;
                for(int j = 1; j * current < students.length; j++) {
                    if(!visited[j * current])
                        q.offer(j * current);
                }
            }
        }

        int[] sum = new int[N + 3];
        if(!students[3]) sum[3] = 1;
        for(int i = 4; i < students.length; i++) {
            if(!students[i])
                sum[i] = sum[i - 1] + 1;
            else sum[i] = sum[i - 1];
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(sum[E] - sum[S - 1]).append('\n');
        }
        System.out.println(sb);
    }
}