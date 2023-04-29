import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int K;
    static Queue<FireBall> q = new LinkedList<>();
    static int[][] mass;
    static int[][] v;
    static int[][] dir;
    static int[][] dSum;
    static int[][] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        mass = new int[N][N];
        v = new int[N][N];
        dir = new int[N][N];
        dSum = new int[N][N];
        num = new int[N][N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            q.offer(new FireBall(r, c, m, s, d));
        }

        for(int i = 0; i < K; i++) {
            for(int[] m: mass) {
                Arrays.fill(m, 0);
            }
            for(int[] vv: v) {
                Arrays.fill(vv, 0);
            }
            for(int[] vv: dSum) {
                Arrays.fill(vv, 0);
            }
            for(int[] m: dir) {
                Arrays.fill(m, 0);
            }
            for(int[] m: num) {
                Arrays.fill(m, 0);
            }

            //파이어볼 이동
            move();

            for(int k = 0; k < N; k++) {
                for(int j = 0; j < N; j++) {
                    if(num[k][j] == 1) {
                        q.offer(new FireBall(k, j, mass[k][j], v[k][j], dSum[k][j]));
                    } else if(num[k][j] > 1) {
                        int md = mass[k][j] / 5;
                        if(md == 0) continue;

                        int vd = v[k][j] / num[k][j];
                        if(dir[k][j] == 3) {
                            q.offer(new FireBall(k, j, md, vd, 1));
                            q.offer(new FireBall(k, j, md, vd, 3));
                            q.offer(new FireBall(k, j, md, vd, 5));
                            q.offer(new FireBall(k, j, md, vd, 7));
                        } else {
                            q.offer(new FireBall(k, j, md, vd, 0));
                            q.offer(new FireBall(k, j, md, vd, 2));
                            q.offer(new FireBall(k, j, md, vd, 4));
                            q.offer(new FireBall(k, j, md, vd, 6));
                        }
                    }
                }
            }
        }

        int answer = 0;
        while(!q.isEmpty()) {
            answer += q.poll().m;
        }
        System.out.println(answer);
    }

    static void move() {
        while(!q.isEmpty()) {
            FireBall now = q.poll();

            int r = now.r;
            int c = now.c;
            int m = now.m;
            int s = now.s;
            int d = now.d;

            if(now.d == 0) {
                for(int j = 0; j < s; j++) {
                    r += N - 1;
                }
                r %= N;
            }
            if(now.d == 1) {
                for(int j = 0; j < s; j++) {
                    r += N - 1;
                    c++;
                }
                r %= N;
                c %= N;
            }
            if(now.d == 2) {
                for(int j = 0; j < s; j++) {
                    c++;
                }
                c %= N;
            }
            if(now.d == 3) {
                for(int j = 0; j < s; j++) {
                    r++;
                    c++;
                }
                r %= N;
                c %= N;
            }
            if(now.d == 4) {
                for(int j = 0; j < s; j++) {
                    r++;
                }
                r %= N;
            }
            if(now.d == 5) {
                for(int j = 0; j < s; j++) {
                    r++;
                    c += N - 1;
                }
                r %= N;
                c %= N;
            }
            if(now.d == 6) {
                for(int j = 0; j < s; j++) {
                    c += N - 1;
                }
                c %= N;
            }
            if(now.d == 7) {
                for(int j = 0; j < s; j++) {
                    r += N - 1;
                    c += N - 1;
                }
                r %= N;
                c %= N;
            }

            mass[r][c] += m;
            v[r][c] += s;
            dSum[r][c] += d;
            if(d % 2 == 0) {
                dir[r][c] |= 1;
            } else {
                dir[r][c] |= 2;
            }
            num[r][c]++;
        }
    }

    static class FireBall {
        int r;
        int c;
        int m;
        int s;
        int d;

        public FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}