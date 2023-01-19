import java.io.*;
import java.util.*;

public class Main {
    public static List<List<Integer>> col = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            map.put(i, new ArrayList<>());
        }
        int[] answer = new int[N];
        boolean[] visited = new boolean[N];

        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            List<Integer> c = map.get(a - 1);
            c.add(b - 1);
            map.replace(a - 1, c);
            List<Integer> d = map.get(b - 1);
            d.add(a - 1);
            map.replace(b - 1, d);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        while(!q.isEmpty()) {
            int current = q.poll();

            for(int i = 0; i < map.get(current).size(); i++) {
                int test = map.get(current).get(i);
                if(!visited[test]) {
                    answer[test] = current + 1;
                    visited[test] = true;
                    q.add(test);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < N; i++) {
            sb.append(answer[i]).append('\n');
        }
        System.out.println(sb);
    }

}