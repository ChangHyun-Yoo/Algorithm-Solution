import java.io.*;
import java.util.*;

public class Main {

    static List<int[]> roads = new ArrayList<>();
    static List<Integer> point = new ArrayList<>();
    static int[][] info;
    static int[] min;
    static boolean[] visited;

    static class Node implements Comparable<Node> {
        int num;
        int distance;

        public Node(int num, int distance) {
            this.num = num;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            if(e > D || e - s <= l) {
                continue;
            } else {
                int[] road = new int[3];
                road[0] = s;
                road[1] = e;
                road[2] = l;
                roads.add(road);
                if(!point.contains(s))
                    point.add(s);
                if(!point.contains(e))
                    point.add(e);
            }
        }
        if(!point.contains(0))
            point.add(0);
        if(!point.contains(D))
            point.add(D);
        Collections.sort(point);

        info = new int[point.size()][point.size()];
        for(int[] inf: info) {
            Arrays.fill(inf,-1);
        }

        for(int i = 0; i < roads.size(); i++) {
            int value = info[point.indexOf(roads.get(i)[0])][point.indexOf(roads.get(i)[1])];
            if(value == -1 || value > roads.get(i)[2]) {
                info[point.indexOf(roads.get(i)[0])][point.indexOf(roads.get(i)[1])] = roads.get(i)[2];
            }
        }

        for(int i = 0; i < info.length - 1; i++) {
            for(int j = i + 1; j < info.length; j++) {
                if(info[i][j] == -1) {
                    info[i][j] = point.get(j) - point.get(i);
                }
            }
        }
        for(int i = 0; i < info.length; i++) {
            if(info[i][info.length - 1] == -1) {
                info[i][info.length - 1] = point.get(info.length - 1) - point.get(i);
            }
        }

        min = new int[info.length];
        Arrays.fill(min, Integer.MAX_VALUE);
        visited = new boolean[info.length];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));
        min[0] = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();

            if(visited[node.num]) {
                continue;
            }

            visited[node.num] = true;

            for(int i = node.num + 1; i < info.length; i++) {
                if(info[node.num][i] != -1 && min[i] > min[node.num] + info[node.num][i]) {
                    min[i] = min[node.num] + info[node.num][i];
                    pq.offer(new Node(i, min[i]));
                }
            }
        }
        
        System.out.println(min[min.length - 1]);
    }
}
