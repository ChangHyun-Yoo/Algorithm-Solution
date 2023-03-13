import java.io.*;
import java.util.*;

public class Main {

    static int[][] dp;
    static int[][] alt;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        dp = new int[M][N];

        for(int i = 0; i < M; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[M - 1][N - 1] = 1;
        alt = new int[M][N];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                alt[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(cases(0, 0));
    }

    static int cases(int row, int col) {

        if(dp[row][col] != -1) {
            return dp[row][col];
        }

        //경로가 없을 때
        int result = 0;
        try {
            if(alt[row - 1][col] < alt[row][col]) {
                result += cases(row - 1, col);
            }
        } catch(IndexOutOfBoundsException e) {

        }
        try {
            if(alt[row + 1][col] < alt[row][col]) {
                result += cases(row + 1, col);
            }
        } catch(IndexOutOfBoundsException e) {

        }
        try {
            if(alt[row][col - 1] < alt[row][col]) {
                result += cases(row, col - 1);
            }
        } catch(IndexOutOfBoundsException e) {

        }
        try {
            if(alt[row][col + 1] < alt[row][col]) {
                result += cases(row, col + 1);
            }
        } catch(IndexOutOfBoundsException e) {

        }
        dp[row][col] = result;
        return result;
    }
}
