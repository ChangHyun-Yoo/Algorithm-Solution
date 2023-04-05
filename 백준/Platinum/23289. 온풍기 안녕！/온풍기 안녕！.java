import java.io.*;
import java.util.*;

public class Main {

    static int[][] tem;
    static List<Node> check = new ArrayList<>();
    static int[][] wall;
    static int[][] plus;
    static List<Heater> heaters = new ArrayList<>();
    static boolean[][] visited;
    static int R;
    static int C;
    static int K;
    static int[][] control;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        tem = new int[R][C];
        wall = new int[R][C];
        plus = new int[R][C];
        control = new int[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < C; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n >= 1 && n <= 4) {
                    heaters.add(new Heater(i, j, n));
                } else if(n == 5) {
                    check.add(new Node(i, j));
                }
            }
        }

        int W = Integer.parseInt(br.readLine());
        for(int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int t = Integer.parseInt(st.nextToken());
            if(t == 0) {
                wall[x][y] |= 1;//위쪽에 벽
            } else {
                wall[x][y] |= 2;//오른쪽에 벽
            }
        }

        initPlus();

        int choco = 0;
        while(choco <= 100) {
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    if(plus[i][j] != 0) {
                        tem[i][j] += plus[i][j];
                    }
                }
            }

            control();
            decrease();

            choco++;
            if(choco == 101) break;

            boolean ok = true;
            for(Node n: check) {
                if(tem[n.x][n.y] < K) {
                    ok = false;
                    break;
                }
            }
            if (ok) break;
        }
        System.out.println(choco);
    }

    static void control() {
        for(int[] c: control) {
            Arrays.fill(c, 0);
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(i != 0) {
                    if(tem[i][j] > tem[i - 1][j] && (wall[i][j] & 1) != 1) {
                        control[i][j] -= (tem[i][j] - tem[i - 1][j]) / 4;
                        control[i - 1][j] += (tem[i][j] - tem[i - 1][j]) / 4;
                    }
                }

                if(i != R - 1) {
                    if(tem[i][j] > tem[i + 1][j] && (wall[i + 1][j] & 1) != 1) {
                        control[i][j] -= (tem[i][j] - tem[i + 1][j]) / 4;
                        control[i + 1][j] += (tem[i][j] - tem[i + 1][j]) / 4;
                    }
                }

                if(j != 0) {
                    if(tem[i][j] > tem[i][j - 1] && (wall[i][j - 1] & 2) != 2) {
                        control[i][j] -= (tem[i][j] - tem[i][j - 1]) / 4;
                        control[i][j - 1] += (tem[i][j] - tem[i][j - 1]) / 4;
                    }
                }

                if(j != C - 1) {
                    if(tem[i][j] > tem[i][j + 1] && (wall[i][j] & 2) != 2) {
                        control[i][j] -= (tem[i][j] - tem[i][j + 1]) / 4;
                        control[i][j + 1] += (tem[i][j] - tem[i][j + 1]) / 4;
                    }
                }
            }
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(control[i][j] != 0)
                    tem[i][j] += control[i][j];
            }
        }
    }

    static void decrease() {
        for(int i = 1; i < R - 1; i++) {
            if(tem[i][0] > 0)
                tem[i][0]--;
            if(tem[i][C - 1] > 0)
                tem[i][C - 1]--;
        }
        for(int i = 0; i < C; i++) {
            if(tem[0][i] > 0)
                tem[0][i]--;
            if(tem[R - 1][i] > 0)
                tem[R - 1][i]--;
        }
    }

    static void initPlus() {
        for(Heater now: heaters) {
            for(boolean[] v: visited) {
                Arrays.fill(v, false);
            }
            int x = now.x;
            int y = now.y;
            int dir = now.dir;

            if(dir == 1) {//오른쪽
                right(x, y, 6);
                continue;
            }

            if(dir == 2) {//왼쪽
                left(x, y, 6);
            }

            if(dir == 3) {//위
                up(x, y, 6);
            }

            if(dir == 4) {//아래
                down(x, y, 6);
            }
        }
    }

    static void right(int x, int y, int t) {
        if(y != C - 1 && t > 1) {
            if((wall[x][y] & 2) != 2 && !visited[x][y + 1]) {
                plus[x][y + 1] += t - 1;
                visited[x][y + 1] = true;
                upRight(x, y + 1, t - 1);
                right(x, y + 1, t - 1);
                downRight(x, y + 1, t - 1);
            }
        }
    }
    static void left(int x, int y, int t) {
        if(y != 0 && t > 1) {
            if((wall[x][y - 1] & 2) != 2 && !visited[x][y - 1]) {
                plus[x][y - 1] += t - 1;
                visited[x][y - 1] = true;
                upLeft(x, y - 1, t - 1);
                left(x, y - 1, t - 1);
                downLeft(x, y - 1, t - 1);
            }
        }
    }
    static void up(int x, int y, int t) {
        if(x != 0 && t > 1) {
            if((wall[x][y] & 1) != 1 && !visited[x - 1][y]) {
                plus[x - 1][y] += t - 1;
                visited[x - 1][y] = true;
                rightUp(x - 1, y, t - 1);
                up(x - 1, y, t - 1);
                leftUp(x - 1, y, t - 1);
            }
        }
    }
    static void down(int x, int y, int t) {
        if(x != R - 1 && t > 1) {
            if((wall[x + 1][y] & 1) != 1 && !visited[x + 1][y]) {
                plus[x + 1][y] += t - 1;
                visited[x + 1][y] = true;
                rightDown(x + 1, y, t - 1);
                down(x + 1, y, t - 1);
                leftDown(x + 1, y, t - 1);
            }
        }
    }
    static void rightUp(int x, int y, int t) {
        if(x != 0 && y != C - 1 && t > 1) {
            if((wall[x][y] & 2) != 2 && (wall[x][y + 1] & 1) != 1 && !visited[x - 1][y + 1]) {
                plus[x - 1][y + 1] += t - 1;
                visited[x - 1][y + 1] = true;
                rightUp(x - 1, y + 1, t - 1);
                up(x - 1, y + 1, t - 1);
                leftUp(x - 1, y + 1, t - 1);
            }
        }
    }
    static void rightDown(int x, int y, int t) {
        if(x != R - 1 && y != C - 1 && t > 1) {
            if((wall[x][y] & 2) != 2 && (wall[x + 1][y + 1] & 1) != 1 && !visited[x + 1][y + 1]) {
                plus[x + 1][y + 1] += t - 1;
                visited[x + 1][y + 1] = true;
                rightDown(x + 1, y + 1, t - 1);
                down(x + 1, y + 1, t - 1);
                leftDown(x + 1, y + 1, t - 1);
            }
        }
    }
    static void leftUp(int x, int y, int t) {
        if(x != 0 && y != 0 && t > 1) {
            if((wall[x][y - 1] & 2) != 2 && (wall[x][y - 1] & 1) != 1 && !visited[x - 1][y - 1]) {
                plus[x - 1][y - 1] += t - 1;
                visited[x - 1][y - 1] = true;
                leftUp(x - 1, y - 1, t - 1);
                rightUp(x - 1, y - 1, t - 1);
                up(x - 1, y - 1, t - 1);
            }
        }
    }
    static void leftDown(int x, int y, int t) {
        if(x != R - 1 && y != 0 && t > 1) {
            if((wall[x][y - 1] & 2) != 2 && (wall[x + 1][y - 1] & 1) != 1 && !visited[x + 1][y - 1]) {
                plus[x + 1][y - 1] += t - 1;
                visited[x + 1][y - 1] = true;
                rightDown(x + 1, y - 1, t - 1);
                down(x + 1, y - 1, t - 1);
                leftDown(x + 1, y - 1, t - 1);
            }
        }
    }
    static void upRight(int x, int y, int t) {
        if(x != 0 && y != C - 1 && t > 1) {
            if((wall[x][y] & 1) != 1 && (wall[x - 1][y] & 2) != 2 && !visited[x - 1][y + 1]) {
                plus[x - 1][y + 1] += t - 1;
                visited[x - 1][y + 1] = true;
                downRight(x - 1, y + 1, t - 1);
                right(x - 1, y + 1, t - 1);
                upRight(x - 1, y + 1, t - 1);
            }
        }
    }
    static void upLeft(int x, int y, int t) {
        if(x != 0 && y != 0 && t > 1) {
            if((wall[x][y] & 1) != 1 && (wall[x - 1][y - 1] & 2) != 2 && !visited[x - 1][y - 1]) {
                plus[x - 1][y - 1] += t - 1;
                visited[x - 1][y - 1] = true;
                downLeft(x - 1, y - 1, t - 1);
                left(x - 1, y - 1, t - 1);
                upLeft(x - 1, y - 1, t - 1);
            }
        }
    }
    static void downRight(int x, int y, int t) {
        if(x != R - 1 && y != C - 1 && t > 1) {
            if((wall[x + 1][y] & 1) != 1 && (wall[x + 1][y] & 2) != 2 && !visited[x + 1][y + 1]) {
                plus[x + 1][y + 1] += t - 1;
                visited[x + 1][y + 1] = true;
                downRight(x + 1, y + 1, t - 1);
                right(x + 1, y + 1, t - 1);
                upRight(x + 1, y + 1, t - 1);
            }
        }
    }
    static void downLeft(int x, int y, int t) {
        if(x != R - 1 && y != 0 && t > 1) {
            if((wall[x + 1][y] & 1) != 1 && (wall[x + 1][y - 1] & 2) != 2 && !visited[x + 1][y - 1]) {
                plus[x + 1][y - 1] += t - 1;
                visited[x + 1][y - 1] = true;
                downLeft(x + 1, y - 1, t - 1);
                left(x + 1, y - 1, t - 1);
                upLeft(x + 1, y - 1, t - 1);
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

    static class Heater {
        int x;
        int y;
        int dir;

        public Heater(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

}

