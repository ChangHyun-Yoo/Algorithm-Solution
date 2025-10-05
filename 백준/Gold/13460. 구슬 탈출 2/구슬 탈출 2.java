import java.util.*;
import java.io.*;

public class Main {

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int bx = 0;
        int by = 0;
        int rx = 0;
        int ry = 0;

        char[][] map = new char[N][M];
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                char ch = input.charAt(j);
                if(ch == 'B') {
                    bx = i;
                    by = j;
                    map[i][j] = '.';
                } else if(ch == 'R') {
                    rx = i;
                    ry = j;
                    map[i][j] = '.';
                } else map[i][j] = ch;
            }
        }

        dfs(bx, by, rx, ry, map, 1);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static void dfs(int bx, int by, int rx, int ry, char[][] map, int move) {
        if(move > 10 || move >= min) return;

        int cbx = bx;
        int cby = by;
        int crx = rx;
        int cry = ry;
        // 오른쪽 기울이기 y + 1
        // 파란색이 오른쪽
        if(cby >= cry) {
            boolean flag = false;
            // 파란색 이동
            while(true) {
                char next = map[cbx][cby + 1];
                if(next == '#') break;
                else if(next == 'O') {
                    flag = true;
                    break;
                } else cby++;
            }
            // 빨간색 이동
            while(!flag) {
                if(crx == cbx && cry + 1 == cby) break;
                char next = map[crx][cry + 1];
                if(next == '#') break;
                else if(next == 'O') {
                    min = move;
                    return;
                } else cry++;
            }
            if(!flag) dfs(cbx, cby, crx, cry, map, move + 1);
        }
        // 빨간색이 오른쪽
        else {
            boolean flag1 = false;
            // 빨간색 이동
            while(true) {
                char next = map[crx][cry + 1];
                if(next == '#') break;
                else if(next == 'O') {
                    flag1 = true;
                    crx = 0;
                    cry = 0;
                    break;
                } else cry++;
            }
            boolean flag = false;
            // 파란색 이동
            while(true) {
                if(cbx == crx && cby + 1 == cry) break;
                char next = map[cbx][cby + 1];
                if(next == '#') break;
                else if(next == 'O') {
                    flag = true;
                    break;
                } else cby++;
            }
            if(flag1 && !flag) {
                min = move;
                return;
            } else if(!flag1 && !flag) dfs(cbx, cby, crx, cry, map, move + 1);
        }

        cbx = bx;
        cby = by;
        crx = rx;
        cry = ry;
        // 왼쪽 기울이기 y - 1
        // 파란색이 왼쪽
        if(cby <= cry) {
            boolean flag = false;
            // 파란색 이동
            while(true) {
                char next = map[cbx][cby - 1];
                if(next == '#') break;
                else if(next == 'O') {
                    flag = true;
                    break;
                } else cby--;
            }
            // 빨간색 이동
            while(!flag) {
                if(crx == cbx && cry - 1 == cby) break;
                char next = map[crx][cry - 1];
                if(next == '#') break;
                else if(next == 'O') {
                    min = move;
                    return;
                } else cry--;
            }
            if(!flag) dfs(cbx, cby, crx, cry, map, move + 1);
        }
        // 빨간색이 왼쪽
        else {
            boolean flag1 = false;
            // 빨간색 이동
            while(true) {
                char next = map[crx][cry - 1];
                if(next == '#') break;
                else if(next == 'O') {
                    flag1 = true;
                    crx = 0;
                    cry = 0;
                    break;
                } else cry--;
            }
            boolean flag = false;
            // 파란색 이동
            while(true) {
                if(cbx == crx && cby - 1 == cry) break;
                char next = map[cbx][cby - 1];
                if(next == '#') break;
                else if(next == 'O') {
                    flag = true;
                    break;
                } else cby--;
            }
            if(flag1 && !flag) {
                min = move;
                return;
            } else if(!flag1 && !flag) dfs(cbx, cby, crx, cry, map, move + 1);
        }

        cbx = bx;
        cby = by;
        crx = rx;
        cry = ry;
        // 위쪽 기울이기 x - 1
        // 파란색이 위쪽
        if(cbx <= crx) {
            boolean flag = false;
            // 파란색 이동
            while(true) {
                char next = map[cbx - 1][cby];
                if(next == '#') break;
                else if(next == 'O') {
                    flag = true;
                    break;
                } else cbx--;
            }
            // 빨간색 이동
            while(!flag) {
                if(crx - 1 == cbx && cry == cby) break;
                char next = map[crx - 1][cry];
                if(next == '#') break;
                else if(next == 'O') {
                    min = move;
                    return;
                } else crx--;
            }
            if(!flag) dfs(cbx, cby, crx, cry, map, move + 1);
        }
        // 빨간색이 위쪽
        else {
            boolean flag1 = false;
            // 빨간색 이동
            while(true) {
                char next = map[crx - 1][cry];
                if(next == '#') break;
                else if(next == 'O') {
                    flag1 = true;
                    crx = 0;
                    cry = 0;
                    break;
                } else crx--;
            }
            boolean flag = false;
            // 파란색 이동
            while(true) {
                if(cbx - 1 == crx && cby == cry) break;
                char next = map[cbx - 1][cby];
                if(next == '#') break;
                else if(next == 'O') {
                    flag = true;
                    break;
                } else cbx--;
            }
            if(flag1 && !flag) {
                min = move;
                return;
            } else if(!flag1 && !flag) dfs(cbx, cby, crx, cry, map, move + 1);
        }

        cbx = bx;
        cby = by;
        crx = rx;
        cry = ry;
        // 아래쪽 기울이기 x + 1
        // 파란색이 아래쪽
        if(cbx >= crx) {
            boolean flag = false;
            // 파란색 이동
            while(true) {
                char next = map[cbx + 1][cby];
                if(next == '#') break;
                else if(next == 'O') {
                    flag = true;
                    break;
                } else cbx++;
            }
            // 빨간색 이동
            while(!flag) {
                if(crx + 1 == cbx && cry == cby) break;
                char next = map[crx + 1][cry];
                if(next == '#') break;
                else if(next == 'O') {
                    min = move;
                    return;
                } else crx++;
            }
            if(!flag) dfs(cbx, cby, crx, cry, map, move + 1);
        }
        // 빨간색이 아래쪽
        else {
            boolean flag1 = false;
            // 빨간색 이동
            while(true) {
                char next = map[crx + 1][cry];
                if(next == '#') break;
                else if(next == 'O') {
                    flag1 = true;
                    crx = 0;
                    cry = 0;
                    break;
                } else crx++;
            }
            boolean flag = false;
            // 파란색 이동
            while(true) {
                if(cbx + 1 == crx && cby == cry) break;
                char next = map[cbx + 1][cby];
                if(next == '#') break;
                else if(next == 'O') {
                    flag = true;
                    break;
                } else cbx++;
            }
            if(flag1 && !flag) {
                min = move;
                return;
            } else if(!flag1 && !flag) dfs(cbx, cby, crx, cry, map, move + 1);
        }
    }
}
