import java.io.*;
import java.util.*;

public class Main {

    public static int N = 0;
    public static int M = 0;
    public static int H = 0;
    public static int answer = 10000;
    public static boolean[][] info;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        info = new boolean[H][N - 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            info[row-1][col-1] = true;
        }

        dfs(0, 0, 0);

        if(answer == 10000)
            System.out.println(-1);
        else
            System.out.println(answer);
    }

    public static void dfs(int count, int row, int col) {
        if(count >= answer) {
            return;
        }

        if(col >= N - 1)
            dfs(count, row + 1, 0);

        boolean check = false;
        for(int i = 0; i < N; i++) {
            if(!progress(i)) {
                check = true;
                break;
            }
        }
        if(!check) {
            answer = count;
            return;
        }

        if(count < 3 && answer > count) {
            for(int i = row; i < H; i++) {
                int start = 0;
                if(i == row) {
                    start = col;
                }
                for(int j = start; j < N - 1; j++) {
                    if(!info[i][j]) {//현재 자리에 없음
                        boolean b1 = false;
                        boolean b2 = false;
                        try {
                            if(!info[i][j-1])
                                b1 = true;
                        } catch(Exception e) {
                            b1 = true;
                        }

                        try {
                            if(!info[i][j+1])
                                b2 = true;
                        } catch(Exception e) {
                            b2 = true;
                        }

                        if(b1 && b2) {
                            info[i][j] = true;
                            dfs(count + 1, i, j + 1);
                            info[i][j] = false;
                        }
                    }
                }
            }
        }
    }

    public static boolean progress(int num) {
        int start = num;
        int height = 0;
        while(height < H) {
            boolean check = false;
            try {
                if(info[height][start]) {
                    start++;
                    height++;
                    check = true;
                }
            } catch(Exception e) {

            }

            try {
                if(info[height][start-1]) {
                    start--;
                    height++;
                    check = true;
                }
            } catch(Exception e){

            }

            if(!check)
                height++;
        }
        return num == start;
    }
}