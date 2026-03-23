import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(N >= K) {
            System.out.println(N - K);
            return;
        }

        Queue<Integer> q = new LinkedList<>();

        boolean[] visited = new boolean[100001];
        visited[N] = true;

        q.offer(N);
        int answer = 0;

        while(true) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                int now = q.poll();

                if(now == K) {
                    System.out.println(answer);
                    return;
                }

                int next;
                next = now - 1;
                if(next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
                next = now + 1;
                if(next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
                next = now * 2;
                if(next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }

            answer++;
        }
    }
}
