import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static int max = -1;
    public static int maxNode = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] length = new int[n + 1];
        Map<Integer, List<Integer>> road = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            road.put(i, new ArrayList<>());
        }

        if(n == 1) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            road.get(parent).add(child);
            road.get(parent).add(weight);
            road.get(child).add(parent);
            road.get(child).add(weight);
            length[child] = length[parent] + weight;
        }

        List<Integer> ll = new ArrayList<>();
        for(int l: length) {
            ll.add(l);
        }
        int firstIndex = ll.indexOf(Collections.max(ll));

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(firstIndex);
        visited[firstIndex] = true;

        bfs(visited, road, 0, firstIndex);
        System.out.println(max);
    }

    public static void bfs(boolean[] visited, Map<Integer, List<Integer>> road, int sum, int current) {
        boolean b = false;
        for(int i = 0; i < road.get(current).size() / 2; i++) {
            if(visited[road.get(current).get(2*i)]) {//방문한 적 있으면
                continue;
            } else {//방문한 적 없으면
                b = true;
                boolean[] copy = visited.clone();
                copy[current] = true;
                bfs(copy, road, sum + road.get(current).get(2*i + 1), road.get(current).get(2*i));
            }
        }
        if(!b) {
            if(sum > max) {
                max = sum;
                maxNode = current;
            }
        }
    }
}
