import java.io.*;
import java.util.*;

public class Main {
    public static List<List<Integer>> col = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] info = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        boolean[][] visited2 = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                info[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);//row
        queue.add(0);//col
        queue.add(1);//level
        queue.add(0);//벽을 깼는지
        visited[0][0] = true;

        int answer = 0;
        while(!queue.isEmpty()) {
            int row = queue.poll();
            int col = queue.poll();
            int level = queue.poll();
            int check = queue.poll();

            if(row == N-1 && col == M-1) {
                answer = level;
                break;
            }

            try {
                if(info[row+1][col] == 1 && check == 0 && !visited[row+1][col]) {//벽이고 깬적 없으면
                    queue.add(row+1);
                    queue.add(col);
                    queue.add(level + 1);
                    queue.add(check + 1);
                    visited[row+1][col] = true;
                } else if(info[row+1][col] == 0 && check == 0 && !visited[row+1][col]) {
                    queue.add(row+1);
                    queue.add(col);
                    queue.add(level + 1);
                    queue.add(check);
                    visited[row+1][col] = true;
                } else if(info[row+1][col] == 0 && check == 1 && !visited2[row+1][col]) {
                    queue.add(row+1);
                    queue.add(col);
                    queue.add(level + 1);
                    queue.add(check);
                    visited2[row+1][col] = true;
                }
            } catch(Exception e) {

            }

            try {
                if(info[row-1][col] == 1 && check == 0 && !visited[row-1][col]) {//벽이고 깬적 없으면
                    queue.add(row-1);
                    queue.add(col);
                    queue.add(level + 1);
                    queue.add(check + 1);
                    visited[row-1][col] = true;
                } else if(info[row-1][col] == 0 && check == 0 && !visited[row-1][col]) {
                    queue.add(row-1);
                    queue.add(col);
                    queue.add(level + 1);
                    queue.add(check);
                    visited[row-1][col] = true;
                } else if(info[row-1][col] == 0 && check == 1 && !visited2[row-1][col]) {
                    queue.add(row-1);
                    queue.add(col);
                    queue.add(level + 1);
                    queue.add(check);
                    visited2[row-1][col] = true;
                }
            } catch(Exception e) {

            }

            try {
                if(info[row][col+1] == 1 && check == 0 && !visited[row][col+1]) {//벽이고 깬적 없으면
                    queue.add(row);
                    queue.add(col+1);
                    queue.add(level + 1);
                    queue.add(check + 1);
                    visited[row][col+1] = true;
                } else if(info[row][col+1] == 0 && check == 0 && !visited[row][col+1]) {
                    queue.add(row);
                    queue.add(col+1);
                    queue.add(level + 1);
                    queue.add(check);
                    visited[row][col+1] = true;
                } else if(info[row][col+1] == 0 && check == 1 && !visited2[row][col+1]) {
                    queue.add(row);
                    queue.add(col+1);
                    queue.add(level + 1);
                    queue.add(check);
                    visited2[row][col+1] = true;
                }
            } catch(Exception e) {

            }

            try {
                if(info[row][col-1] == 1 && check == 0 && !visited[row][col-1]) {//벽이고 깬적 없으면
                    queue.add(row);
                    queue.add(col-1);
                    queue.add(level + 1);
                    queue.add(check + 1);
                    visited[row][col-1] = true;
                } else if(info[row][col-1] == 0 && check == 0 && !visited[row][col-1]) {
                    queue.add(row);
                    queue.add(col-1);
                    queue.add(level + 1);
                    queue.add(check);
                    visited[row][col-1] = true;
                } else if(info[row][col-1] == 0 && check == 1 && !visited2[row][col-1]) {
                    queue.add(row);
                    queue.add(col-1);
                    queue.add(level + 1);
                    queue.add(check);
                    visited2[row][col-1] = true;
                }
            } catch(Exception e) {

            }
        }

        if(answer == 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

}