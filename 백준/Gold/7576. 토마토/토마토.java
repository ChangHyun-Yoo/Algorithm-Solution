import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] tomatoes = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        int all = 0;
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                int t = Integer.parseInt(st.nextToken());
                tomatoes[i][j] = t;
                if(t == 0)
                    all++;
                else if(t == 1) {
                    all++;
                    queue.add(i);
                    queue.add(j);
                    queue.add(0);
                    visited[i][j] = true;
                }
            }
        }

        int currentLevel = -1;
        while(!queue.isEmpty()) {
            int row = queue.poll();
            int col = queue.poll();
            int level = queue.poll();
            if(currentLevel != level) {//레벨이 바뀌면
                currentLevel = level;
            }

            try {
                if(tomatoes[row-1][col] == 0) {
                    tomatoes[row-1][col] = 1;
                    queue.add(row-1);
                    queue.add(col);
                    queue.add(level + 1);
                }
            } catch(Exception e) {

            }

            try {
                if(tomatoes[row+1][col] == 0) {
                    tomatoes[row+1][col] = 1;
                    queue.add(row+1);
                    queue.add(col);
                    queue.add(level + 1);
                }
            } catch(Exception e) {

            }

            try {
                if(tomatoes[row][col-1] == 0) {
                    tomatoes[row][col-1] = 1;
                    queue.add(row);
                    queue.add(col-1);
                    queue.add(level + 1);
                }
            } catch(Exception e) {

            }

            try {
                if(tomatoes[row][col+1] == 0) {
                    tomatoes[row][col+1] = 1;
                    queue.add(row);
                    queue.add(col+1);
                    queue.add(level + 1);
                }
            } catch(Exception e) {

            }
        }

        int hmm = 0;
        for(int[] tom: tomatoes) {
            for(int t: tom) {
                if(t == 1)
                    hmm++;
            }
        }

        if(hmm != all) {
            System.out.println(-1);
        } else {
            System.out.println(currentLevel);
        }
    }

}