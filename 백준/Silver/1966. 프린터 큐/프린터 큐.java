import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Node> q = new LinkedList<>();

            st = new StringTokenizer(br.readLine(), " ");
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < N; i++) {
                int x = Integer.parseInt(st.nextToken());
                if(i == M) q.offer(new Node(x, true));
                else q.offer(new Node(x, false));
                if(map.get(x) == null) {
                    map.put(x, 1);
                } else {
                    map.replace(x, map.get(x) + 1);
                }
            }

            int count = 0;
            while(!q.isEmpty()) {
                int max = Collections.max(map.keySet());

                Node now = q.poll();
                if(now.x == max) {
                    count++;
                    if(map.get(max) == 1) {
                        map.remove(max);
                    } else {
                        map.replace(max, map.get(max) - 1);
                    }
                    if(now.check) {
                        sb.append(count).append('\n');
                        break;
                    }
                } else {
                    q.offer(now);
                }
            }
        }
        System.out.println(sb);

    }

    static class Node {
        int x;
        boolean check;

        public Node(int x, boolean check) {
            this.x = x;
            this.check = check;
        }
    }
}