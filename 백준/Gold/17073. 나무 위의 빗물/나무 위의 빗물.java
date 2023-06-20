import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int W;
    static boolean[] visited;
    static List<List<Integer>> roads = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];

        for(int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            roads.get(s).add(e);
            roads.get(e).add(s);
        }

        int leaf  = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while(!q.isEmpty()) {
            int now = q.poll();
            visited[now] = true;

            int count = 0;
            for(int next: roads.get(now)) {
                if(!visited[next]) {
                    q.offer(next);
                    count++;
                }
            }
            if(count == 0) leaf++;
        }
        System.out.println(W / (double) leaf);
    }
}