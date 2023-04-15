import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] lst;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        lst = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                lst[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(N > 1) {
            int[][] newLst = new int[N / 2][N / 2];

            for(int i = 0; 2 * i < N; i++) {
                for(int j = 0; 2 * j < N; j++) {
                    newLst[i][j] = secondMax(i * 2, i * 2 + 2, j * 2, j * 2 + 2);
                }
            }

            lst = newLst;
            N /= 2;
        }
        System.out.println(lst[0][0]);
    }

    static int secondMax(int sx, int fx, int sy, int fy) {
        List<Integer> l = new ArrayList<>();
        for(int i = sx; i < fx; i++) {
            for(int j = sy; j < fy; j++) {
                l.add(lst[i][j]);
            }
        }
        Collections.sort(l);
        return l.get(2);
    }
}