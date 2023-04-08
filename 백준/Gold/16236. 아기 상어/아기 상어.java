import java.io.*;
import java.util.*;

public class Main {

    static int sharkX;
    static int sharkY;
    static int sSize = 2;
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static PriorityQueue<Node> eats = new PriorityQueue<>();
    static int ate = 0;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 9) {
                    sharkX = i;
                    sharkY = j;
                } else {
                    map[i][j] = num;
                }
            }
        }

        int answer = 0;
        while(true) {
            find();
            if(eats.isEmpty()) break;
            answer += eats.peek().dis;

            sharkX = eats.peek().x;
            sharkY = eats.peek().y;
            map[eats.peek().x][eats.peek().y] = 0;
            ate++;
            if(ate == sSize) {
                ate = 0;
                sSize++;
            }
        }
        System.out.println(answer);
    }

    static void find() {
        min = Integer.MAX_VALUE;
        eats.clear();
        for(boolean[] v: visited) {
            Arrays.fill(v, false);
        }
        int x = sharkX;
        int y = sharkY;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0));
        while(!q.isEmpty()) {
            Node now = q.poll();
            if(min < now.dis) {
                break;
            }
            if(now.x >= 0 && now.x < N && now.y >= 0 && now.y < N) {
                if(!visited[now.x][now.y]) {
                    visited[now.x][now.y] = true;
                    if(map[now.x][now.y] == 0 || map[now.x][now.y] == sSize) {
                        q.offer(new Node(now.x - 1, now.y, now.dis + 1));
                        q.offer(new Node(now.x, now.y - 1, now.dis + 1));
                        q.offer(new Node(now.x, now.y + 1, now.dis + 1));
                        q.offer(new Node(now.x + 1, now.y, now.dis + 1));
                    } else if(map[now.x][now.y] > 0 && map[now.x][now.y] < sSize) {
                        min = now.dis;
                        eats.offer(new Node(now.x, now.y, now.dis));
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int dis;

        public Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }

        public int compareTo(Node o) {
            if(this.x == o.x) {
                return this.y - o.y;
            } else {
                return this.x - o.x;
            }
        }
    }
}

