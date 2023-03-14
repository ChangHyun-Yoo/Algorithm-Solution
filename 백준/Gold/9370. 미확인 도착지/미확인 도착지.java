import java.io.*;
import java.util.*;

public class Main {

    static List<List<Node>> roads;
    static boolean[] visited;
    static int[] min;
    static boolean[] status;
    static boolean[] across;

    static class Node implements Comparable<Node> {
        int num;
        int dis;

        public Node(int num, int dis) {
            this.num = num;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node n) {
            return this.dis - n.dis;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int q = 0; q < T; q++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());//num of nodes
            int m = Integer.parseInt(st.nextToken());//num of roads
            int t = Integer.parseInt(st.nextToken());//num of destinations

            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());//출발지
            //지난 곳
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            roads = new ArrayList<>();
            for(int i = 0; i < n + 1; i++) {
                roads.add(new ArrayList<>());
            }
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                roads.get(start).add(new Node(end, d));
                roads.get(end).add(new Node(start, d));
            }
            min = new int[n + 1];
            Arrays.fill(min, Integer.MAX_VALUE);
            visited = new boolean[n + 1];
            across = new boolean[n + 1];
            status = new boolean[n + 1];

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(s, 0));
            min[s] = 0;
            while(!pq.isEmpty()) {
                Node now = pq.poll();

                if(visited[now.num])
                    continue;
                visited[now.num] = true;

                for(Node node: roads.get(now.num)) {
                    if(min[node.num] > min[now.num] + node.dis) {
                        min[node.num] = min[now.num] + node.dis;
                        if(across[now.num] || (now.num == g && node.num == h) || (now.num == h && node.num == g)) {
                            across[node.num] = true;
                        } else {
                            across[node.num] = false;
                        }
                        pq.offer(new Node(node.num, min[node.num]));
                    } else if(min[node.num] == min[now.num] + node.dis && !across[node.num]) {//바꿀 필요가 있으면 바꿔라
                        if(across[now.num] || (now.num == g && node.num == h) || (now.num == h && node.num == g)) {
                            across[node.num] = true;
                        }
                    }
                }
            }

            List<Integer> cand = new ArrayList<>();
            for(int i = 0; i < t; i++) {
                int a = Integer.parseInt(br.readLine());
                if(across[a]) {
                    cand.add(a);
                }
            }
            Collections.sort(cand);
            for(int ca: cand)
                sb.append(ca + " ");
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
