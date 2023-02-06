import java.io.*;
import java.util.*;

public class Main {

    public static int minL = -1;
    public static int w = 0;
    public static int h = 0;
    public static int answer = Integer.MAX_VALUE;
    public static boolean[] nodeV;
    public static int[][] nodes;
    public static char[][] info;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0)
                break;

            info = new char[h][w];
            int[][] point = new int[11][2];
            int dirty = 0;
            for(int i = 0; i < h; i++) {
                String s = br.readLine();
                for(int j = 0; j < w; j++) {
                    char c = s.charAt(j);
                    info[i][j] = c;
                    if(c == 'o') {
                        point[0][0] = i;
                        point[0][1] = j;
                    } else if(c == '*') {
                        point[dirty + 1][0] = i;
                        point[dirty + 1][1] = j;
                        dirty++;
                    }
                }
            }

            nodes = new int[dirty + 1][dirty + 1];

            boolean check = false;
            for(int i = 0; i < dirty; i++) {
                for(int j = i + 1; j < dirty + 1; j++) {
                    boolean[][] visited = new boolean[h][w];
                    minLength(point[i][0], point[i][1], point[j][0], point[j][1], visited);
                    if(minL == -1) {
                        check = true;
                        break;
                    } else {
                        nodes[i][j] = minL;
                        nodes[j][i] = minL;
                    }
                    minL = -1;
                }
                if(check)
                    break;
            }

            if(check) {
                System.out.println(-1);
                continue;
            }


            nodeV = new boolean[dirty + 1];
            nodeV[0] = true;

            dfs(dirty, 0, 0, 0);
            System.out.println(answer);
            answer = Integer.MAX_VALUE;
        }
    }

    public static void dfs(int dirty, int progress, int length, int current) {
        if(answer <= length)
            return;

        if(progress == dirty) {
            if(answer > length) {
                answer = length;
                return;
            }
        }
        for(int i = 1; i < dirty + 1; i++) {
            if(!nodeV[i]) {//방문한 적이 없으면
                nodeV[i] = true;
                dfs(dirty, progress + 1, length + nodes[current][i], i);
                nodeV[i] = false;
            }
        }
    }

    public static void minLength(int x, int y, int xx, int yy, boolean[][] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(y);
        queue.add(0);
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int row = queue.poll();
            int col = queue.poll();
            int length = queue.poll();
//            System.out.println(row);

            if(row == xx && col == yy) {
                minL = length;
                return;
            }

            if(row != 0) {
                if(!visited[row - 1][col] && info[row - 1][col] != 'x') {
                    queue.add(row - 1);
                    queue.add(col);
                    queue.add(length + 1);
                    visited[row - 1][col] = true;
                }
            }

            if(col != 0) {
                if(!visited[row][col - 1] && info[row][col - 1] != 'x') {
                    queue.add(row);
                    queue.add(col - 1);
                    queue.add(length + 1);
                    visited[row][col - 1] = true;
                }
            }

            if(row != h - 1) {
                if(!visited[row + 1][col] && info[row + 1][col] != 'x') {
                    queue.add(row + 1);
                    queue.add(col);
                    queue.add(length + 1);
                    visited[row + 1][col] = true;
                }
            }

            if(col != w - 1) {
                if(!visited[row][col + 1] && info[row][col + 1] != 'x') {
                    queue.add(row);
                    queue.add(col + 1);
                    queue.add(length + 1);
                    visited[row][col + 1] = true;
                }
            }
        }
    }

}