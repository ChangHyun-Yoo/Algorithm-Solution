import java.io.*;
import java.util.*;

public class Main {

    static int[] before;
    static List<List<Integer>> next = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        before = new int[N + 1];
        for(int i = 0; i < N + 1; i++) {
            next.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int num = Integer.parseInt(st.nextToken());

            int b = -1;
            for(int j = 0; j < num; j++) {
                int current = Integer.parseInt(st.nextToken());

                if(b != -1) {
                    next.get(b).add(current);
                    before[current]++;
                }
                b = current;
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < N + 1; i++) {
            if(before[i] == 0) {
                q.offer(i);
            }
        }
        while(!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append('\n');
            count++;

            for(int nxt: next.get(now)) {
                before[nxt]--;
                if(before[nxt] == 0) {
                    q.offer(nxt);
                }
            }
        }
        if(count == N) System.out.println(sb);
        else System.out.println(0);
    }
}