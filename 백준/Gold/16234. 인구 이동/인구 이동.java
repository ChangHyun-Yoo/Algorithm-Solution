import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int L;
    static int R;
    static int[][] current;
    static boolean[][] visited;
    static int[][] country;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        current = new int[N][N];
        visited = new boolean[N][N];
        country = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                current[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while(true) {
            int count = findCountry();
            if(count == N * N) break;

            int[][] list = new int[count + 1][2];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    list[country[i][j]][0]++;
                    list[country[i][j]][1] += current[i][j];
                }
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    current[i][j] = list[country[i][j]][1] / list[country[i][j]][0];
                }
            }

//            for(int[] c: country)
//            {
//                System.out.println(Arrays.toString(c));
//            }
//            System.out.println();
//            for(int[] c: current)
//            {
//                System.out.println(Arrays.toString(c));
//            }
//            System.out.println();
            answer++;

            resetVisited();
        }

        System.out.println(answer);
    }

    static int findCountry() {
        int countries = 0;
        int all = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    all = 0;
                    countries++;
                    Queue<Node> q = new LinkedList<>();
                    q.offer(new Node(i, j));

                    while(!q.isEmpty()) {
                        Node now = q.poll();
                        if(visited[now.x][now.y]) continue;
                        visited[now.x][now.y] = true;
//                        System.out.println(now.x + " " + now.y + " " + countries);
                        all += current[now.x][now.y];
                        country[now.x][now.y] = countries;

                        if(now.x != 0) {
                            int dif = Math.abs(current[now.x - 1][now.y] - current[now.x][now.y]);
                            if(dif >= L && dif <= R) {
                                q.offer(new Node(now.x - 1, now.y));
                            }
                        }

                        if(now.y != 0) {
                            int dif = Math.abs(current[now.x][now.y - 1] - current[now.x][now.y]);
                            if(dif >= L && dif <= R) {
                                q.offer(new Node(now.x, now.y - 1));
                            }
                        }

                        if(now.x != N - 1) {
                            int dif = Math.abs(current[now.x + 1][now.y] - current[now.x][now.y]);
                            if(dif >= L && dif <= R) {
                                q.offer(new Node(now.x + 1, now.y));
                            }
                        }

                        if(now.y != N - 1) {
                            int dif = Math.abs(current[now.x][now.y + 1] - current[now.x][now.y]);
                            if(dif >= L && dif <= R) {
                                q.offer(new Node(now.x, now.y + 1));
                            }
                        }
                    }
                }
            }
        }
        return countries;
    }

    static void resetVisited() {
        for(boolean[] v: visited) {
            Arrays.fill(v, false);
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
