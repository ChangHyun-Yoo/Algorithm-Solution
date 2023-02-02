import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] info = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] result = new int[N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                result[i] |= info[i][j];
            }
        }
        for(int r: result)
            System.out.print(r + " ");
    }
}