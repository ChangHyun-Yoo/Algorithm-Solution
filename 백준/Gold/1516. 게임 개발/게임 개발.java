import java.io.*;
import java.util.*;

public class Main {

    static int[] before;
    static int[] time;
    static int[] answer;
    static List<List<Integer>> nexts = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        before = new int[N + 1];
        time = new int[N + 1];
        answer = new int[N + 1];

        for(int i = 0; i < N + 1; i++) {
            nexts.add(new ArrayList<>());
        }

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            time[i] = Integer.parseInt(st.nextToken());

            int b = 0;
            while(true) {
                int j = Integer.parseInt(st.nextToken());

                if(j == -1) break;

                b++;
                nexts.get(j).add(i);
            }
            before[i] = b;
        }

        Queue<Node> q = new LinkedList<>();
        for(int i = 1; i < before.length; i++) {
            if(before[i] == 0) q.offer(new Node(i, time[i]));
        }
        while(!q.isEmpty()) {
            Node now = q.poll();

            answer[now.x] = Math.max(answer[now.x], now.time);
            for(int next: nexts.get(now.x)) {
                before[next]--;
                answer[next] = Math.max(answer[next], answer[now.x] + time[next]);

                if(before[next] == 0) {
                    q.offer(new Node(next, now.time + time[next]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < answer.length; i++) {
            sb.append(answer[i]).append('\n');
        }
        System.out.println(sb);
    }

    static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}