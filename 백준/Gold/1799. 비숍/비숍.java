import java.io.*;
import java.util.*;

public class Main {

    public static int[][] map;
    public static int max = 0;
    public static int N;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) == 1 ? 0 : 1;
            }
        }

        dfs(0, 0, 0);

        System.out.println(max);
    }

    public static int[] find(int x, int y) {//없애는 공백이 최소가 되는 좌표를 출력
        int xx = x;
        int yy = y;
        Queue<Integer> queue = new LinkedList<>();
        int min = 100;
        while(xx != 0 && yy != 0) {
            xx--;
            yy--;
        }
        while(xx < N && yy < N) {
            if(map[xx][yy] == 0) {
                queue.add(xx);
                queue.add(yy);
            }
            xx++;
            yy++;
        }
        xx = x;
        yy = y;
        while(xx != 0 && yy != N - 1) {
            xx--;
            yy++;
        }
        while(xx < N && yy >= 0) {
            if(map[xx][yy] == 0) {
                queue.add(xx);
                queue.add(yy);
            }
            xx++;
            yy--;
        }
        int[] answer = new int[2];
        while(!queue.isEmpty()) {
            int testX = queue.poll();
            int testY = queue.poll();
            int c = check(testX, testY);
            if(c < min) {
                min = c;
                answer[0] = testX;
                answer[1] = testY;
            }
        }
        return answer;
    }

    public static int check(int x, int y) {
        int xx = x;
        int yy = y;
        int count = 0;
        while(xx != 0 && yy != 0) {
            xx--;
            yy--;
        }
        while(xx < N && yy < N) {
            if(map[xx][yy] == 0) {
                count++;
            }
            xx++;
            yy++;
        }
        xx = x;
        yy = y;
        while(xx != 0 && yy != N - 1) {
            xx--;
            yy++;
        }
        while(xx < N && yy >= 0) {
            if(map[xx][yy] == 0) {
                count++;
            }
            xx++;
            yy--;
        }
        count--;
        return count;
    }

    public static void dfs(int current, int x, int y) {
        count++;
        int zero = 0;
        for(int[] m: map)
            for(int i: m)
                if(i == 0)
                    zero++;
        if(max > current + zero)
            return;

        if(x >= N - 1 && y > N - 1) {
            max = Math.max(max, current);
            return;
        }

        if(y > N - 1) {
            dfs(current, x + 1, 0);
            return;
        }

        if(map[x][y] == 0) {//놓을 수 있다면
            int[] found = find(x, y);
            int fx = found[0];
            int fy = found[1];

            int xx = fx;
            int yy = fy;
            while(xx != 0 && yy != 0) {
                xx--;
                yy--;
            }
            while(xx < N && yy < N) {
                map[xx][yy]++;
                xx++;
                yy++;
            }
            xx = fx;
            yy = fy;
            while(xx != 0 && yy != N - 1) {
                xx--;
                yy++;
            }
            while(xx < N && yy >= 0) {
                map[xx][yy]++;
                xx++;
                yy--;
            }
            dfs(current + 1, x, y + 1);
        } else {
            dfs(current, x, y + 1);
        }
    }
}