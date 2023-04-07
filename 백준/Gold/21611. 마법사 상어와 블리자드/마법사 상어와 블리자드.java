import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static int[] map1d;
    static boolean[][] visited;
    static int[][] breaker;
    static int mid;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        map1d = new int[N * N];
        visited = new boolean[N][N];
        breaker = new int[M][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        mid = (N - 1) / 2;
        map[mid][mid] = -1;

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            breaker[i][0] = Integer.parseInt(st.nextToken());
            breaker[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++) {
            int di = breaker[i][0];
            int si = breaker[i][1];

            if(di == 1) {
                for(int j = mid - 1; j > mid - 1 - si && j >= 0; j--) {
                    map[j][mid] = 0;
                }
            } else if(di == 2) {
                for(int j = mid + 1; j < mid + 1 + si && j <= N - 1; j++) {
                    map[j][mid] = 0;
                }
            } else if(di == 3) {
                for(int j = mid - 1; j > mid - 1 - si && j >= 0; j--) {
                    map[mid][j] = 0;
                }
            } else {
                for(int j = mid + 1; j < mid + 1 + si && j <= N - 1; j++) {
                    map[mid][j] = 0;
                }
            }
            copyTwoToOne();
            fillEmpty();
            fire();
            map1d = grouping();
            copyOneToTwo();
        }
        System.out.println(answer);
    }

    static int[] grouping() {
        int index = 1;
        int[] replace = new int[N * N];
        replace[0] = -1;
        int value = 0;
        int con = 0;
        for(int i = 1; i < N * N && index < N * N; i++) {
            if(value == 0) {
                value = map1d[i];
                con = 1;
                continue;
            }

            if(map1d[i] == 0) {
                replace[index++] = con;
                if(index == N * N) break;
                else replace[index++] = value;
                break;
            }

            if(map1d[i] == value) {
                con++;
                if(i == N * N - 1) {
                    replace[index++] = con;
                    if(index == N * N) break;
                    else replace[index++] = value;
                }
                continue;
            }

            if(map1d[i] != value) {
                replace[index++] = con;
                if(index == N * N) break;
                else replace[index++] = value;
                value = map1d[i];
                con = 1;
                continue;
            }
        }
        return replace;
    }

    static void fire() {
        while(true) {
            boolean check = false;
            int value = 0;
            int con = 0;
            for(int i = 1; i < N * N; i++) {
                if(value == 0) {
                    value = map1d[i];
                    con = 1;
                    continue;
                }

                if(map1d[i] == 0) {
                    if(con >= 4) {
                        check = true;
                        if(value == 3) {
                            answer += 3 * con;
                        } else if(value == 2) {
                            answer += 2 * con;
                        } else {
                            answer += con;
                        }

                        for(int j = i - 1; j > i - 1 - con; j--) {
                            map1d[j] = 0;
                        }
                    }
                    break;
                }

                if(map1d[i] == value) {
                    con++;
                    if(i == N * N - 1 && con >= 4) {
                        if(value == 3) {
                            answer += 3 * con;
                        } else if(value == 2) {
                            answer += 2 * con;
                        } else {
                            answer += con;
                        }

                        for(int j = i; j > i - 1 - con; j--) {
                            map1d[j] = 0;
                        }
                    }
                    continue;
                }

                if(map1d[i] != value) {
                    if(con >= 4) {
                        check = true;
                        if(value == 3) {
                            answer += 3 * con;
                        } else if(value == 2) {
                            answer += 2 * con;
                        } else {
                            answer += con;
                        }

                        for(int j = i - 1; j > i - 1 - con; j--) {
                            map1d[j] = 0;
                        }
                        value = map1d[i];
                        con = 1;
                        continue;
                    } else {
                        value = map1d[i];
                        con = 1;
                        continue;
                    }
                }
            }
            if(check) {
                fillEmpty();
            } else {
                break;
            }
        }
    }

    static void fillEmpty() {
        for(int i = 1; i < N * N; i++) {
            if(map1d[i] == 0) {
                int find = -1;
                for(int j = i + 1; j < N * N; j++) {
                    if(map1d[j] != 0) {
                        find = j;
                        break;
                    }
                }
                if(find == -1) {
                    break;
                } else {
                    map1d[i] = map1d[find];
                    map1d[find] = 0;
                }
            }
        }
    }

    static void copyTwoToOne() {
        for(boolean[] v: visited) {
            Arrays.fill(v, false);
        }
        int index = N * N - 1;

        int x = 0;
        int y = 0;
        int dir = 3;

        while(x != (N - 1) / 2 || y != (N - 1) / 2) {
            if(!visited[x][y]) {
                map1d[index] = map[x][y];
                index--;
                visited[x][y] = true;
            }
            //좌
            if(dir == 1) {
                if(y == 0) {
                    dir = 2;
                    x--;
                    continue;
                } else {
                    if(!visited[x][y - 1]) {
                        y--;
                        continue;
                    } else {
                        dir = 2;
                        x--;
                        continue;
                    }
                }
            }
            //상
            if(dir == 2) {
                if(x == 0) {
                    dir = 3;
                    y++;
                    continue;
                } else {
                    if(!visited[x - 1][y]) {
                        x--;
                        continue;
                    } else {
                        dir = 3;
                        y++;
                        continue;
                    }
                }
            }
            //우
            if(dir == 3) {
                if(y == N - 1) {
                    dir = 4;
                    x++;
                    continue;
                } else {
                    if(!visited[x][y + 1]) {
                        y++;
                        continue;
                    } else {
                        dir = 4;
                        x++;
                        continue;
                    }
                }
            }
            //하
            if(dir == 4) {
                if(x == N - 1) {
                    dir = 1;
                    y--;
                    continue;
                } else {
                    if(!visited[x + 1][y]) {
                        x++;
                        continue;
                    } else {
                        dir = 1;
                        y--;
                        continue;
                    }
                }
            }
        }
        map1d[0] = -1;
    }

    static void copyOneToTwo() {
        for(boolean[] v: visited) {
            Arrays.fill(v, false);
        }
        int index = N * N - 1;

        int x = 0;
        int y = 0;
        int dir = 3;

        while(x != (N - 1) / 2 || y != (N - 1) / 2) {
            if(!visited[x][y]) {
                map[x][y] = map1d[index];
                index--;
                visited[x][y] = true;
            }
            //좌
            if(dir == 1) {
                if(y == 0) {
                    dir = 2;
                    x--;
                    continue;
                } else {
                    if(!visited[x][y - 1]) {
                        y--;
                        continue;
                    } else {
                        dir = 2;
                        x--;
                        continue;
                    }
                }
            }
            //상
            if(dir == 2) {
                if(x == 0) {
                    dir = 3;
                    y++;
                    continue;
                } else {
                    if(!visited[x - 1][y]) {
                        x--;
                        continue;
                    } else {
                        dir = 3;
                        y++;
                        continue;
                    }
                }
            }
            //우
            if(dir == 3) {
                if(y == N - 1) {
                    dir = 4;
                    x++;
                    continue;
                } else {
                    if(!visited[x][y + 1]) {
                        y++;
                        continue;
                    } else {
                        dir = 4;
                        x++;
                        continue;
                    }
                }
            }
            //하
            if(dir == 4) {
                if(x == N - 1) {
                    dir = 1;
                    y--;
                    continue;
                } else {
                    if(!visited[x + 1][y]) {
                        x++;
                        continue;
                    } else {
                        dir = 1;
                        y--;
                        continue;
                    }
                }
            }
        }
        map1d[0] = -1;
    }
}

