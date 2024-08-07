import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static int r;
    static int c;
    static int d;
    static int[][] status;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        status = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                status[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while(true) {
            if(status[r][c] == 0) {
                status[r][c] = 2;
                answer++;
            }

            boolean empty = false;
            if(r != 0 && status[r - 1][c] == 0) empty = true;
            if(r != N - 1 && status[r + 1][c] == 0) empty = true;
            if(c != 0 && status[r][c - 1] == 0) empty = true;
            if(c != M - 1 && status[r][c + 1] == 0) empty = true;

            if(!empty) {
                // 북
                if(d == 0) {
                    // 후진 가능하면
                    if(r != N - 1 && status[r + 1][c] != 1) {
                        r++;
                        continue;
                    } else break;
                }
                // 동
                else if(d == 1) {
                    // 후진 가능하면
                    if(c != 0 && status[r][c - 1] != 1) {
                        c--;
                        continue;
                    } else break;
                }
                // 남
                else if(d == 2) {
                    // 후진 가능하면
                    if(r != 0 && status[r - 1][c] != 1) {
                        r--;
                        continue;
                    } else break;
                }
                // 서
                else {
                    // 후진 가능하면
                    if(c != M - 1 && status[r][c + 1] != 1) {
                        c++;
                        continue;
                    } else break;
                }
            } else {
                if(d == 0) d = 3;
                else d--;
                // 북
                if(d == 0) {
                    if(r != 0 && status[r - 1][c] == 0) r--;
                }
                // 동
                else if(d == 1) {
                    if(c != M - 1 && status[r][c + 1] == 0) c++;
                }
                // 남
                else if(d == 2) {
                    if(r != N - 1 && status[r + 1][c] == 0) r++;
                }
                // 서
                else {
                    if(c != 0 && status[r][c - 1] == 0) c--;
                }
            }
        }
        System.out.println(answer);
    }

}


