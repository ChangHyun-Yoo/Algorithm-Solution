import java.io.*;
import java.util.*;

public class Main {

    static int[][] pop;
    static int[][] country;
    static boolean[][] visited;
    static int N;
    static int L;
    static int R;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        System.out.println(Integer.parseInt(st.nextToken())*Integer.parseInt(st.nextToken()));
    }

    static void checkPop(int n) {
        for(int i = 1; i <= n; i++) {
            int countries = 0;
            int pops = 0;
            for(int j = 0; j < N ;j++) {
                for(int k = 0; k < N; k++) {
                    if(country[j][k] == i) {
                        countries++;
                        pops += pop[j][k];
                    }
                }
            }
            for(int j = 0; j < N ;j++) {
                for(int k = 0; k < N; k++) {
                    if(country[j][k] == i) {
                        pop[j][k] = pops / countries;
                    }
                }
            }
        }
    }

    static int findCountry() {
        initCountry();
        initVisited();
        int n = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(country[i][j] == 0) {
                    n++;
                    country[i][j] = n;
                    visited[i][j] = true;
                    Queue<Country> q = new LinkedList<>();
                    q.offer(new Country(i, j, n));
                    while(!q.isEmpty()) {
                        Country polled = q.poll();
                        int x = polled.x;
                        int y = polled.y;
                        int c = polled.c;
                        //왼쪽
                        if(y != 0) {
                            if(Math.abs(pop[x][y] - pop[x][y - 1]) >= L && Math.abs(pop[x][y] - pop[x][y - 1]) <= R && !visited[x][y - 1]) {
                                country[x][y - 1] = c;
                                visited[x][y - 1] = true;
                                q.offer(new Country(x, y - 1, c));
                            }
                        }

                        //오른쪽
                        if(y != N - 1) {
                            if(Math.abs(pop[x][y] - pop[x][y + 1]) >= L && Math.abs(pop[x][y] - pop[x][y + 1]) <= R && !visited[x][y + 1]) {
                                country[x][y + 1] = c;
                                visited[x][y + 1] = true;
                                q.offer(new Country(x, y + 1, c));
                            }
                        }
                        //위쪽
                        if(x != 0) {
                            if(Math.abs(pop[x - 1][y] - pop[x][y]) >= L && Math.abs(pop[x - 1][y] - pop[x][y]) <= R && !visited[x - 1][y]) {
                                country[x - 1][y] = c;
                                visited[x - 1][y] = true;
                                q.offer(new Country(x - 1, y, c));
                            }
                        }
                        //아래쪽
                        if(x != N - 1) {
                            if(Math.abs(pop[x + 1][y] - pop[x][y]) >= L && Math.abs(pop[x + 1][y] - pop[x][y]) <= R && !visited[x + 1][y]) {
                                country[x + 1][y] = c;
                                visited[x + 1][y] = true;
                                q.offer(new Country(x + 1, y, c));
                            }
                        }
                    }
                }
            }
        }
        return n;
    }

    static void initVisited() {
        for(boolean[] v: visited) {
            Arrays.fill(v, false);
        }
    }

    static void initCountry() {
        for(int[] c: country) {
            Arrays.fill(c, 0);
        }
    }

    static class Country {
        int x;
        int y;
        int c;

        public Country(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
}

