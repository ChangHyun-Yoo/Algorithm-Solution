import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] likes;
    static int[][] map;
    static List<Integer> ls = new ArrayList<>();
    static int x;
    static int y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());

        likes = new int[N * N][5];
        map = new int[N][N];

        for(int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            likes[i][0] = Integer.parseInt(st.nextToken());
            likes[i][1] = Integer.parseInt(st.nextToken());
            likes[i][2] = Integer.parseInt(st.nextToken());
            likes[i][3] = Integer.parseInt(st.nextToken());
            likes[i][4] = Integer.parseInt(st.nextToken());
        }

        for(int n = 0; n < N * N; n++) {
            int m = likes[n][0];
            ls.clear();
            ls.add(likes[n][1]);
            ls.add(likes[n][2]);
            ls.add(likes[n][3]);
            ls.add(likes[n][4]);

            findPlace();


            map[x][y] = m;
        }
        int answer = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                answer += happy(i, j, map[i][j]);
            }
        }
        System.out.println(answer);
    }

    static int happy(int i, int j, int m) {
        ls.clear();
        for(int k = 0; k < N * N; k++) {
            if(likes[k][0] == m) {
                m = k;
                break;
            }
        }
        ls.add(likes[m][1]);
        ls.add(likes[m][2]);
        ls.add(likes[m][3]);
        ls.add(likes[m][4]);

        int l = checkLikes(i - 1, j)
                + checkLikes(i + 1, j)
                + checkLikes(i, j - 1)
                + checkLikes(i, j + 1);

        if(l == 4) return 1000;
        if(l == 3) return 100;
        if(l == 2) return 10;
        if(l == 1) return 1;
        return 0;
    }

    static int checkLikes(int i, int j) {
        if(i >= 0 && i < N && j >= 0 && j < N) {
            if(ls.contains(map[i][j])) return 1;
        }
        return 0;
    }

    static void findPlace() {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 0) {
                    int empty = 0;
                    int like = 0;
                    if(check(i - 1, j) == 1)
                        like++;
                    else if(check(i - 1, j) == 2)
                        empty++;

                    if(check(i + 1, j) == 1)
                        like++;
                    else if(check(i + 1, j) == 2)
                        empty++;

                    if(check(i, j - 1) == 1)
                        like++;
                    else if(check(i, j - 1) == 2)
                        empty++;

                    if(check(i, j + 1) == 1)
                        like++;
                    else if(check(i, j + 1) == 2)
                        empty++;

                    pq.offer(new Info(i, j, empty, like));
                }
            }
        }
        x = pq.peek().x;
        y = pq.peek().y;
    }

    static int check(int i, int j) {
        if(i >= 0 && i < N && j >= 0 && j < N) {
            if(ls.contains(map[i][j])) return 1;
            else if(map[i][j] == 0) return 2;
            else return 0;
        }
        return 0;
    }

    static class Info implements Comparable<Info> {
        int x;
        int y;
        int empty;
        int like;

        public Info(int x, int y, int empty, int like) {
            this.x = x;
            this.y = y;
            this.empty = empty;
            this.like = like;
        }

        public int compareTo(Info o) {
            if(this.like == o.like) {
                if(this.empty == o.empty) {
                    if(this.x == o.x) {
                        return this.y - o.y;
                    } else {
                        return this.x - o.x;
                    }
                } else {
                    return o.empty - this.empty;
                }
            } else {
                return o.like - this.like;
            }
        }
    }
}

