import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] road = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                road[i][j] = Integer.parseInt((line.substring(j, j+1)));
            }
        }

        visited[0][0] = true;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        queue.add(0);
        queue.add(1);

        while(true) {

            int row = queue.poll();
            int col = queue.poll();
            int level = queue.poll();
            if(row == N-1 && col == M-1) {
                System.out.println(level);
                return;
            }
            try {
                if(road[row-1][col] == 1 && !visited[row-1][col]) {//왼쪽 길이 있으면
                    queue.add(row-1);
                    queue.add(col);
                    queue.add(level+1);
                    visited[row-1][col] = true;
                }
            } catch(Exception e) {

            }
            try {
                if(road[row+1][col] == 1 && !visited[row+1][col]) {//오른쪽 길이 있으면
                    queue.add(row+1);
                    queue.add(col);
                    queue.add(level+1);
                    visited[row+1][col] = true;
                }
            } catch(Exception e) {

            }
            try {
                if(road[row][col-1] == 1 && !visited[row][col-1]) {//위쪽 길이 있으면
                    queue.add(row);
                    queue.add(col-1);
                    queue.add(level+1);
                    visited[row][col-1] = true;
                }
            } catch(Exception e) {

            }
            try {
                if(road[row][col+1] == 1 && !visited[row][col+1]) {//아래쪽 길이 있으면
                    queue.add(row);
                    queue.add(col+1);
                    queue.add(level+1);
                    visited[row][col+1] = true;
                }
            } catch(Exception e) {

            }
        }
    }

}