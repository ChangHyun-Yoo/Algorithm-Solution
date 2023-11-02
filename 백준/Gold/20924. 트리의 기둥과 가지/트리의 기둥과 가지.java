import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int current;
    static List<List<Node>> nexts;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        current = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        nexts = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            nexts.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            long v = Long.parseLong(st.nextToken());

            nexts.get(s).add(new Node(e, v));
            nexts.get(e).add(new Node(s, v));
        }

        long answer1 = 0;
        long answer2 = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(current, 0));

        while(!q.isEmpty()) {
            Node c = q.poll();
            visited[c.x] = true;
            answer1 = Math.max(answer1, c.value);
            int count = 0;

            for(Node next: nexts.get(c.x)) {
                if(!visited[next.x])
                    count++;
            }

            if(count == 0) {
                System.out.println(c.value + " " + 0);
                return;
            }
            else if(count == 1) {
                for(Node next: nexts.get(c.x)) {
                    if(!visited[next.x])
                        q.offer(new Node(next.x, c.value + next.value));
                }
            } else {
                q.offer(new Node(c.x, 0));
                break;
            }
        }

        while(!q.isEmpty()) {
            Node n = q.poll();
            visited[n.x] = true;

            answer2 = Math.max(answer2, n.value);

            for(Node next: nexts.get(n.x)) {
                if(!visited[next.x]) {
                    q.offer(new Node(next.x, n.value + next.value));
                }
            }
        }

        System.out.println(answer1 + " " + answer2);
    }

    static class Node {
        int x;
        long value;

        public Node(int x, long value) {
            this.x = x;
            this.value = value;
        }
    }
}