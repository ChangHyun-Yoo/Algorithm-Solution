import java.io.*;
import java.util.*;

public class Main {

    public static int answer = 100;
    public static int[][] info = new int[10][10];
    public static int[] paper = {0, 5, 5, 5, 5, 5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 10; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        if(answer == 100)
            System.out.println(-1);
        else
            System.out.println(answer);
    }

    public static void dfs(int row, int col, int count) {
        if(row >= 9 && col > 9) {
            answer = Math.min(answer, count);
            return;
        }

        if(answer <= count) {
            return;
        }

        if(col > 9) {
            dfs(row + 1, 0, count);
            return;
        }

        if(info[row][col] == 0) {
            dfs(row, col + 1, count);
        } else {
            for(int i = 5; i >= 1; i--) {
                if(paper[i] > 0 && isAttached(row, col, i)) {
                    attach(row, col, i , 0);
                    paper[i]--;
                    dfs(row, col + 1, count + 1);
                    attach(row, col, i , 1);
                    paper[i]++;
                }
            }
        }
    }

    public static boolean isAttached(int row, int col, int size) {
        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(i > 9 || j > 9) {
                    return false;
                }

                if(info[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    public static void attach(int row, int col, int size, int state) {
        for(int i = row; i < row + size; i++)
            for(int j = col; j < col + size; j++)
                info[i][j] = state;
    }
}