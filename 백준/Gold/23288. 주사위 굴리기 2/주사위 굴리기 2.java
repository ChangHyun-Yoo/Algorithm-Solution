import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static int[][] scores;
    static boolean[][] visited;
    static int[][] thr = new int[4][3];
    static int N;
    static int M;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        scores = new int[N][M];
        visited = new boolean[N][M];
        thr[0][1] = 2;
        thr[1][0] = 4;
        thr[1][1] = 1;
        thr[1][2] = 3;
        thr[2][1] = 5;
        thr[3][1] = 6;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        checkScore();

        int cX = 0;
        int cY = 0;
        int cD = 1;
        int answer = 0;
        for(int i = 0; i < K; i++) {
            if(cD == 1 && cY == M - 1) {
                cD = 3;
            } else if(cD == 2 && cX == N - 1) {
                cD = 0;
            } else if(cD == 3 && cY == 0) {
                cD = 1;
            } else if(cD == 0 && cX == 0) {
                cD = 2;
            }

            if(cD == 1) {
                cY++;
            } else if(cD == 2) {
                cX++;
            } else if(cD == 3) {
                cY--;
            } else {
                cX--;
            }
            roll(cD);

            int A = thr[3][1];
            int B = map[cX][cY];

            if(A > B) {
                cD = (cD + 1) % 4;
            } else if(A < B) {
                cD = (cD + 3) % 4;
            }
            answer += scores[cX][cY];
        }
        System.out.println(answer);
    }

    static void roll(int d) {
        if(d == 1) {//동쪽
            int t31 = thr[1][2];
            int t11 = thr[1][0];
            int t12 = thr[1][1];
            int t10 = thr[3][1];
            thr[3][1] = t31;
            thr[1][0] = t10;
            thr[1][2] = t12;
            thr[1][1] = t11;
            return;
        }

        if(d == 2) {//남쪽
            int t21 = thr[1][1];
            int t11 = thr[0][1];
            int t31 = thr[2][1];
            int t01 = thr[3][1];
            thr[2][1] = t21;
            thr[1][1] = t11;
            thr[3][1] = t31;
            thr[0][1] = t01;
            return;
        }

        if(d == 3) {//서쪽
            int t31 = thr[1][0];
            int t11 = thr[1][2];
            int t12 = thr[3][1];
            int t10 = thr[1][1];
            thr[3][1] = t31;
            thr[1][0] = t10;
            thr[1][2] = t12;
            thr[1][1] = t11;
            return;
        }

        if(d == 0) {//북쪽
            int t21 = thr[3][1];
            int t11 = thr[2][1];
            int t31 = thr[0][1];
            int t01 = thr[1][1];
            thr[2][1] = t21;
            thr[1][1] = t11;
            thr[3][1] = t31;
            thr[0][1] = t01;
            return;
        }
    }

    static void checkScore() {
        int n = -1;
        List<Integer> v = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j]) {
                    int sum = 0;
                    int s = map[i][j];
                    n++;
                    Queue<Node> q = new LinkedList<Node>();
                    q.add(new Node(i, j));
                    visited[i][j] = true;
                    while(!q.isEmpty()) {
                        Node now = q.poll();
                        int nowX = now.x;
                        int nowY = now.y;
                        scores[nowX][nowY] = n;

                        if(map[nowX][nowY] == s) {
                            sum += s;
                            if(nowX != 0) {
                                if(!visited[nowX - 1][nowY] && map[nowX - 1][nowY] == s) {
                                    visited[nowX - 1][nowY] = true;
                                    q.add(new Node(nowX - 1, nowY));
                                }
                            }
                            if(nowX != N - 1) {
                                if(!visited[nowX + 1][nowY] && map[nowX + 1][nowY] == s) {
                                    visited[nowX + 1][nowY] = true;
                                    q.add(new Node(nowX + 1, nowY));
                                }
                            }
                            if(nowY != 0) {
                                if(!visited[nowX][nowY - 1] && map[nowX][nowY - 1] == s) {
                                    visited[nowX][nowY - 1] = true;
                                    q.add(new Node(nowX, nowY - 1));
                                }
                            }
                            if(nowY != M - 1) {
                                if(!visited[nowX][nowY + 1] && map[nowX][nowY + 1] == s) {
                                    visited[nowX][nowY + 1] = true;
                                    q.add(new Node(nowX, nowY + 1));
                                }
                            }
                        }
                    }
                    v.add(sum);
                }
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                scores[i][j] = v.get(scores[i][j]);
            }
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

