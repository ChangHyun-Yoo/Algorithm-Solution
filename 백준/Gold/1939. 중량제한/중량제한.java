import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static List<List<Node>> roads;
    static int start;
    static int end;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        roads = new ArrayList<>();
        for(int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            roads.get(A).add(new Node(B, C));
            roads.get(B).add(new Node(A, C));
        }

        st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int low = 1;
        int high = 1000000001;
        while(low < high) {
            int mid = low + (high - low) / 2;

            if(bfs(mid)) {//건널 수 있으면
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        System.out.println(low - 1);
    }

    private static boolean bfs(int mid) {
        boolean result = false;
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[N + 1];
        q.offer(new Node(start, 0));
        visited[start] = true;

        while(!q.isEmpty()) {
            Node now = q.poll();
            if(now.num == end) {
                result = true;
                break;
            }

            for(Node next: roads.get(now.num)) {
                if(!visited[next.num] && next.weight >= mid) {
                    q.offer(new Node(next.num, next.weight));
                    visited[next.num] = true;
                }
            }
        }
        return result;
    }

    private static class Node {
        int num;
        int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }
}
