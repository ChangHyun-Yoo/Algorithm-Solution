import java.io.*;
import java.util.*;

public class Main {

    private static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] info = new int[N][M];

        List<Integer> cctvs = new ArrayList<>();


        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                int cctv = Integer.parseInt(st.nextToken());
                if(cctv != 0 && cctv != 6) {
                    cctvs.add(i);
                    cctvs.add(j);
                }
                info[i][j] = cctv;
            }
        }

        dfs(0, info, cctvs);

        System.out.println(min);
    }

    public static void dfs(int current, int[][] info, List<Integer> cctvs) {
        if(current == cctvs.size()) {
            int sum = 0;
            for(int[] inf: info)
                for(int in: inf)
                    if(in == 0)
                        sum++;
            if(min > sum)
                min = sum;
        } else {
            int row = cctvs.get(current);
            int col = cctvs.get(current + 1);

            if(info[row][col] == 1) {//cctv가 1번
                int[][] copy1 = left(row, col, info);
                dfs(current + 2, copy1, cctvs);

                int[][] copy2 = right(row, col, info);
                dfs(current + 2, copy2, cctvs);

                int[][] copy3 = up(row, col, info);
                dfs(current + 2, copy3, cctvs);

                int[][] copy4 = down(row, col, info);
                dfs(current + 2, copy4, cctvs);
            } else if(info[row][col] == 2) {//2번
                int[][] copy1 = right(row, col, left(row, col, info));
                dfs(current + 2, copy1, cctvs);

                int[][] copy2 = down(row, col, up(row, col, info));
                dfs(current + 2, copy2, cctvs);
            } else if(info[row][col] == 3) {//3번
                int[][] copy1 = up(row, col, left(row, col, info));
                dfs(current + 2, copy1, cctvs);

                int[][] copy2 = up(row, col, right(row, col, info));
                dfs(current + 2, copy2, cctvs);

                int[][] copy3 = down(row, col, left(row, col, info));
                dfs(current + 2, copy3, cctvs);

                int[][] copy4 = down(row, col, right(row, col, info));
                dfs(current + 2, copy4, cctvs);
            } else if(info[row][col] == 4) {//4번
                int[][] copy1 = up(row, col, right(row, col, left(row, col, info)));
                dfs(current + 2, copy1, cctvs);

                int[][] copy2 = right(row, col, down(row, col, up(row, col, info)));
                dfs(current + 2, copy2, cctvs);

                int[][] copy3 = down(row, col, right(row, col, left(row, col, info)));
                dfs(current + 2, copy3, cctvs);

                int[][] copy4 = left(row, col, down(row, col, up(row, col, info)));
                dfs(current + 2, copy4, cctvs);
            } else {//5번
                int[][] copy1 = down(row, col, up(row, col, right(row, col, left(row, col, info))));
                dfs(current + 2, copy1, cctvs);
            }
        }
    }

    public static int[][] left(int row, int col, int[][] info) {
        int[][] copy = new int[info.length][info[0].length];
        for(int i = 0; i < info.length; i++)
            copy[i] = info[i].clone();
        for(int i = col - 1; i >= 0; i--) {
            if(info[row][i] == 0) {//빈 칸
                copy[row][i] = 7;
            } else if(info[row][i] == 1 || info[row][i] == 2 || info[row][i] == 3 || info[row][i] == 4 || info[row][i] == 5 || info[row][i] == 7) {//CCTV 일 때
                continue;
            } else {//벽인 경우
                break;
            }
        }
        return copy;
    }

    public static int[][] right(int row, int col, int[][] info) {
        int[][] copy = new int[info.length][info[0].length];
        for(int i = 0; i < info.length; i++)
            copy[i] = info[i].clone();
        for(int i = col + 1; i < info[0].length; i++) {
            if(info[row][i] == 0) {//빈 칸
                copy[row][i] = 7;
            } else if(info[row][i] == 1 || info[row][i] == 2 || info[row][i] == 3 || info[row][i] == 4 || info[row][i] == 5 || info[row][i] == 7) {//CCTV 일 때
                continue;
            } else {//벽인 경우
                break;
            }
        }
        return copy;
    }

    public static int[][] up(int row, int col, int[][] info) {
        int[][] copy = new int[info.length][info[0].length];
        for(int i = 0; i < info.length; i++)
            copy[i] = info[i].clone();
        for (int i = row - 1; i >= 0; i--) {
            if (info[i][col] == 0) {//빈 칸
                copy[i][col] = 7;
            } else if (info[i][col] == 1 || info[i][col] == 2 || info[i][col] == 3 || info[i][col] == 4 || info[i][col] == 5 || info[i][col] == 7) {//CCTV 일 때
                continue;
            } else {//벽인 경우
                break;
            }
        }
        return copy;
    }

    public static int[][] down(int row, int col, int[][] info) {
        int[][] copy = new int[info.length][info[0].length];
        for(int i = 0; i < info.length; i++)
            copy[i] = info[i].clone();
        for(int i = 0; i < info.length; i++)
            copy[i] = info[i].clone();
        for(int i = row + 1; i < info.length; i++) {
            if(info[i][col] == 0) {//빈 칸
                copy[i][col] = 7;
            } else if(info[i][col] == 1 || info[i][col] == 2 || info[i][col] == 3 || info[i][col] == 4 || info[i][col] == 5 || info[i][col] == 7) {//CCTV 일 때
                continue;
            } else {//벽인 경우
                break;
            }
        }
        return copy;
    }
}