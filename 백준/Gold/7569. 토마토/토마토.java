import java.util.*;
import java.io.*;
import java.util.LinkedList;

public class Main {

    static int[][][] tomatoes;
    static int N;
    static int M;
    static int H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomatoes = new int[N][M][H];

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int k = 0; k < M; k++) {
                    tomatoes[j][k][i] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int day = 0;
        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i < N ; i++) {
            for(int j = 0; j < M; j++) {
                for(int k = 0; k < H; k++) {
                    if(tomatoes[i][j][k] == 1) {
                        q.offer(new Node(i,j,k));
                    }
                }
            }
        }
        while(true) {

            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node now = q.poll();

                if(now.x != 0)
                    if(tomatoes[now.x - 1][now.y][now.z] == 0) {
                        tomatoes[now.x - 1][now.y][now.z] = 1;
                        q.offer(new Node(now.x - 1, now.y, now.z));
                    }

                if(now.x != N - 1)
                    if(tomatoes[now.x + 1][now.y][now.z] == 0) {
                        tomatoes[now.x + 1][now.y][now.z] = 1;
                        q.offer(new Node(now.x + 1, now.y, now.z));
                    }

                if(now.y != 0)
                    if(tomatoes[now.x][now.y - 1][now.z] == 0) {
                        tomatoes[now.x][now.y - 1][now.z] = 1;
                        q.offer(new Node(now.x, now.y - 1, now.z));
                    }

                if(now.y != M - 1)
                    if(tomatoes[now.x][now.y + 1][now.z] == 0) {
                        tomatoes[now.x][now.y + 1][now.z] = 1;
                        q.offer(new Node(now.x, now.y + 1, now.z));
                    }

                if(now.z != 0)
                    if(tomatoes[now.x][now.y][now.z - 1] == 0) {
                        tomatoes[now.x][now.y][now.z - 1] = 1;
                        q.offer(new Node(now.x, now.y, now.z - 1));
                    }

                if(now.z != H - 1)
                    if(tomatoes[now.x][now.y][now.z + 1] == 0) {
                        tomatoes[now.x][now.y][now.z + 1] = 1;
                        q.offer(new Node(now.x, now.y, now.z + 1));
                    }
            }

            if(q.isEmpty()) break;
            day++;
        }

        // 모든 토마토가 익었으면 return day, 그렇지 않으면 return -1
        if(check()) System.out.println(day);
        else System.out.println(-1);
    }

    static boolean check() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                for(int k = 0; k < H; k++) {
                    if(tomatoes[i][j][k] == 0) return false;
                }
            }
        }
        return true;
    }

    static class Node {
        int x;
        int y;
        int z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}