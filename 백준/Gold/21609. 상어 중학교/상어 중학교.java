import java.io.*;
import java.util.*;

public class Main {

    static int[][] blocks;
    static boolean[][] visited;
    static final int empty = -10;
    static int N;
    static int M;
    static int nums;
    static int gizunX;
    static int gizunY;
    static PriorityQueue<Group> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        blocks = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                blocks[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int score = 0;
        while(true) {
            if(!grouping()) break;

            Group big = pq.peek();
            int x = big.checkX;
            int y = big.checkY;
            int color = big.color;
            score += big.num * big.num;

            fire(x, y, color);

            weight();

            blocks = rotation();

            weight();
        }
        System.out.println(score);
    }

    static int[][] rotation() {
        int[][] rotated = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                rotated[i][j] = blocks[j][N - 1 - i];
            }
        }
        return rotated;
    }

    static void weight() {
        for(int i = N - 2; i >= 0; i--) {
            for(int j = 0; j < N; j++) {
                if(blocks[i][j] >= 0) {
                    int cx = i;
                    int cy = j;
                    while(cx < N - 1) {
                        if(blocks[cx + 1][cy] == empty) {
                            blocks[cx + 1][cy] = blocks[cx][cy];
                            blocks[cx][cy] = empty;
                            cx++;
                        } else
                            break;
                    }
                }
            }
        }
    }

    static void fire(int x, int y, int color) {
        for(boolean[] v: visited) {
            Arrays.fill(v, false);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        q.offer(y);
        while(!q.isEmpty()) {
            int xx = q.poll();
            int yy = q.poll();

            if(xx >= 0 && xx < N && yy >= 0 && yy < N) {
                if(!visited[xx][yy]) {
                    if(blocks[xx][yy] == 0 || blocks[xx][yy] == color) {
                        blocks[xx][yy] = empty;
                        visited[xx][yy] = true;
                        q.offer(xx - 1);
                        q.offer(yy);
                        q.offer(xx + 1);
                        q.offer(yy);
                        q.offer(xx);
                        q.offer(yy - 1);
                        q.offer(xx);
                        q.offer(yy + 1);
                    }
                }
            }
        }
    }

    static boolean grouping() {
        pq.clear();
        for(boolean[] v: visited) {
            Arrays.fill(v, false);
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(blocks[i][j] > 0 && !visited[i][j]) {
                    int color = blocks[i][j];
                    gizunX = i;
                    gizunY = j;
                    nums = 0;
                    check(i, j, color);
                    int rb = 0;
                    for(int k = 0; k < N; k++) {
                        for(int l = 0; l < N; l++) {
                            if(blocks[k][l] == 0 && visited[k][l]) {
                                rb++;
                                visited[k][l] = false;
                            }
                        }
                    }
                    if(nums > 1)
                        pq.offer(new Group(nums, rb, color, gizunX, gizunY));
                }
            }
        }
        return pq.size() != 0;
    }

    static void check(int x, int y, int color) {
        if(x >= 0 && x < N && y >= 0 && y < N) {
            if(!visited[x][y]) {
                if(blocks[x][y] == 0 || blocks[x][y] == color) {//무지개 또는 일반이면
                    if(blocks[x][y] == color) {
                        if(gizunX > x) {
                            gizunX = x;
                        } else if(gizunX == x && gizunY > y) {
                            gizunY = y;
                        }
                    }
                    visited[x][y] = true;
                    nums++;
                    check(x - 1, y, color);
                    check(x + 1, y, color);
                    check(x, y - 1, color);
                    check(x, y + 1, color);
                }
            }
        }
    }

    static class Group implements Comparable<Group> {
        int num;
        int rBlocks;//무지개 block 개수
        int color;
        int checkX;
        int checkY;

        public Group(int num, int rBlocks, int color, int checkX, int checkY) {
            this.num = num;
            this.rBlocks = rBlocks;
            this.color = color;
            this.checkX = checkX;
            this.checkY = checkY;
        }

        public int compareTo(Group o) {
            if(this.num == o.num) {
                if(this.rBlocks == o.rBlocks) {
                    if(this.checkX == o.checkX) {
                        return o.checkY - this.checkY;
                    } else {
                        return o.checkX - this.checkX;
                    }
                } else {
                    return o.rBlocks - this.rBlocks;
                }
            } else {
                return o.num - this.num;
            }
        }
    }
}

