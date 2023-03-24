import java.io.*;
import java.util.*;

public class Main {

    static List<List<Node>> roads = new ArrayList<>();
    static boolean[] visited;
    static int[][] length;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) == 0? 0 : -1;
            }
        }

        int country = 1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == -1) {
                    Queue<Integer> q = new LinkedList<>();
                    q.offer(i);
                    q.offer(j);
                    while(!q.isEmpty()) {
                        int x = q.poll();
                        int y = q.poll();
                        try {
                            if(map[x][y] == -1) {
                                map[x][y] = country;
                                q.offer(x + 1);
                                q.offer(y);
                                q.offer(x - 1);
                                q.offer(y);
                                q.offer(x);
                                q.offer(y + 1);
                                q.offer(x);
                                q.offer(y - 1);
                            }
                        } catch(Exception e) {};
                    }
                    country++;
                }
            }
        }

        length = new int[country][country];
        for(int[] l: length) {
            Arrays.fill(l, Integer.MAX_VALUE);
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0 ; j < M; j++) {
                if(map[i][j] != 0) {
                    findRoute(i, j, map[i][j]);
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[country];
        q.offer(1);
        v[1] = true;
        while(!q.isEmpty()) {
            int p = q.poll();
            for(int i = 1; i < country; i++) {
                if(length[p][i] != Integer.MAX_VALUE && !v[i]) {
                    q.offer(i);
                    v[i] = true;
                }
            }
        }
        for(int i = 1; i < v.length; i++) {
            if(!v[i]) {
                System.out.println(-1);
                return;
            }
        }

        visited = new boolean[country];
        int answer = 0;
        int cnt = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.num]) continue;
            visited[now.num] = true;
            answer += now.dis;
            cnt++;
            if(cnt == country - 1) break;

            for(int i = 1; i < country; i++) {
                if(length[now.num][i] != Integer.MAX_VALUE && !visited[i]) {
                    pq.offer(new Node(i, length[now.num][i]));
                }
            }
        }
        System.out.println(answer);
    }

    private static void findRoute(int i, int j, int value) {
        //right
        for(int k = j + 1; k < map[0].length; k++) {
            if(map[i][k] == 0) continue;
            else if(map[i][k] == value) break;
            else {
                if(k - j - 1 > 1 && length[value][map[i][k]] > k - j - 1) {
                    length[value][map[i][k]] = k - j - 1;
                    length[map[i][k]][value] = k - j - 1;
                }
                break;
            }
        }
        //down
        for(int k = i + 1; k < map.length; k++) {
            if(map[k][j] == 0) continue;
            else if(map[k][j] == value) break;
            else {
                if(k - i - 1 > 1 && length[value][map[k][j]] > k - i - 1) {
                    length[value][map[k][j]] = k - i - 1;
                    length[map[k][j]][value] = k - i - 1;
                }
                break;
            }
        }
    }

    static class Node implements Comparable<Node> {
        int num;
        int dis;

        public Node(int num, int dis) {
            this.num = num;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            return this.dis - o.dis;
        }
    }
}

