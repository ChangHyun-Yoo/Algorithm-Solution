import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int[][] g;
    static int[][] minus;
    static int N;
    static int Q;
    static int L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        N = (int) Math.pow(2, N);
        map = new int[N][N];
        minus = new int[N][N];
        g = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int q = 0; q < Q; q++) {
            L = Integer.parseInt(st.nextToken());
            L = (int) Math.pow(2, L);
            for(int i = 0; i * L < N; i++) {
                for(int j = 0; j * L < N; j++) {
                    rotation(i * L, j * L);
                }
            }

            for(int[] mi: minus) {
                Arrays.fill(mi, 0);
            }
            for(int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    ice(i, j);
                }
            }
            for(int k = 0; k < N; k++) {
                for(int l = 0; l < N; l++) {
                    map[k][l] += minus[k][l];
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sum += map[i][j];
            }
        }
        int group = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] > 0 && !visited[i][j]) {
                    group++;
                    group(i, j, group);
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= group; i++) {
            int num = 0;
            for(int j = 0; j < N;j++) {
                for(int k = 0 ; k < N; k++) {
                    if(g[j][k] == i) {
                        num++;
                    }
                }
            }
            max = Math.max(num, max);
        }
        System.out.println(sum);
        System.out.println(max);
    }

    static void group(int i, int j, int group) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        q.offer(j);
        while(!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();

            if(x >= 0 && x < N && y >= 0 && y < N) {
                if(!visited[x][y]) {
                    if(map[x][y] > 0) {
                        visited[x][y] = true;
                        g[x][y] = group;
                        q.offer(x - 1);
                        q.offer(y);
                        q.offer(x + 1);
                        q.offer(y);
                        q.offer(x);
                        q.offer(y - 1);
                        q.offer(x);
                        q.offer(y + 1);
                    }
                }
            }
        }
    }

    static void ice(int i, int j) {
        if(map[i][j] > 0) {
            int sum = ic(i - 1, j) + ic(i + 1, j) + ic(i, j + 1) + ic(i, j - 1);
            if(sum <= 2) minus[i][j]--;
        }
    }

    static int ic(int i, int j) {
        if(i >= 0 && i < N && j >= 0 && j < N) {
            if(map[i][j] > 0) {
                return 1;
            }
        }
        return 0;
    }

    static void rotation(int i1, int j1) {
        int[][] origin = new int[L][L];
        int[][] copy = new int[L][L];

        for(int i = i1; i < i1 + L; i++) {
            for(int j = j1; j < j1 + L; j++) {
                origin[i - i1][j - j1] = map[i][j];
            }
        }

        for(int i = 0; i < L; i++) {
            for(int j = 0; j < L; j++) {
                copy[i][j] = origin[L - 1 - j][i];
            }
        }

        for(int i = i1; i < i1 + L; i++) {
            for(int j = j1; j < j1 + L; j++) {
                map[i][j] = copy[i - i1][j - j1];
            }
        }
    }
}

