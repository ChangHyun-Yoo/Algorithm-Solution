import java.io.*;
import java.util.*;

public class Main {

    static int[][] sky;
    static int[][] move;
    static int N;
    static int M;
    static Queue<Goorm> goorms;
    static boolean[][] gone;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sky = new int[N][N];
        move = new int[M][2];
        gone = new boolean[N][N];
        goorms = new LinkedList<>();
        goorms.add(new Goorm(N - 1, 0));
        goorms.add(new Goorm(N - 1, 1));
        goorms.add(new Goorm(N - 2, 0));
        goorms.add(new Goorm(N - 2, 1));

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                sky[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            move[i][0] = Integer.parseInt(st.nextToken());
            move[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++) {
            int size = goorms.size();
            int dir = move[i][0];
            int dis = move[i][1];

            for(int j = 0; j < size; j++) {
                Goorm now = goorms.poll();
                int x = now.x;
                int y = now.y;

                if(dir == 1) {
                    goorms.add(new Goorm(x, (y + (N * 25 - dis)) % N));
                    continue;
                }
                if(dir == 2) {
                    goorms.add(new Goorm((x + (N * 25 - dis)) % N, (y + (N * 25 - dis)) % N));
                    continue;
                }
                if(dir == 3) {
                    goorms.add(new Goorm((x + (N * 25 - dis)) % N, y));
                    continue;
                }
                if(dir == 4) {
                    goorms.add(new Goorm((x + (N * 25 - dis)) % N, (y + dis) % N));
                    continue;
                }
                if(dir == 5) {
                    goorms.add(new Goorm(x, (y + dis) % N));
                    continue;
                }
                if(dir == 6) {
                    goorms.add(new Goorm((x + dis) % N, (y + dis) % N));
                    continue;
                }
                if(dir == 7) {
                    goorms.add(new Goorm((x + dis) % N, y));
                    continue;
                }
                if(dir == 8) {
                    goorms.add(new Goorm((x + dis) % N, (y + (N * 25 - dis)) % N));
                    continue;
                }
            }
            for (Goorm goorm : goorms) {
                sky[goorm.x][goorm.y]++;
            }
            for(boolean[] g: gone) {
                Arrays.fill(g, false);
            }
            while(!goorms.isEmpty()) {
                Goorm goorm = goorms.poll();
                gone[goorm.x][goorm.y] = true;
                magic(goorm.x, goorm.y);
            }
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    if(sky[j][k] >= 2 && !gone[j][k]) {
                        goorms.add(new Goorm(j, k));
                        sky[j][k] -= 2;
                    }
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                answer += sky[i][j];
            }
        }
        System.out.println(answer);
    }

    static void magic(int x, int y) {
        sky[x][y] += fill(x - 1, y - 1) + fill(x - 1, y + 1) + fill(x + 1, y - 1) + fill(x + 1, y + 1);
    }

    static int fill(int x, int y) {
        if(x >= 0 && x <= N - 1 && y >= 0 && y <= N - 1 && sky[x][y] > 0) return 1;
        else return 0;
    }

    static class Goorm {
        int x = 0;
        int y = 0;

        public Goorm(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

