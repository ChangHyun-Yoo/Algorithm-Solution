import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[][] lst = new long[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                lst[i][j] = Long.parseLong(st.nextToken());
            }
        }

        long[][] first = new long[N][N];

        int half = M / 2;
        for(int i = 0; i <= N - M; i++) {
            for(int j = 0; j <= N - M; j++) {
                if(j == 0) {
                    first[i + half][j + half] = -lst[i][j];
                } else {
                    first[i + half][j + half] = lst[i][j - 1] - lst[i][j];
                    if(j - M >= 0) {
                        first[i + half][j + half] += first[i + half][j + half - M];
                    }
                }
            }
        }

        for(int i = half + M; i < N - half; i++) {
            for(int j = half; j < N - half; j++) {
                first[i][j] += first[i - M][j];
            }
        }

        for(int i = N - half - 1; i > half; i--) {
            for(int j = half; j < N - half; j++) {
                first[i][j] -= first[i - 1][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(long[] f: first) {
            for(int i = 0; i < f.length; i++) {
                sb.append(f[i]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
