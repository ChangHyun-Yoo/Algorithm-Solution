import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        int length = (int) Math.pow(2, K);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int y = Integer.parseInt(st.nextToken()) - 1;
        int x = (int) Math.pow(2, K) - Integer.parseInt(st.nextToken());

        int[][] answer = new int[length][length];
        StringBuilder sb = new StringBuilder();

        if(K == 1) {
            answer[0][0] = 1;
            answer[0][1] = 1;
            answer[1][0] = 1;
            answer[1][1] = 1;
            answer[x][y] = -1;
        } else {
            for(int i = 0; i < 2; i++) {
                for(int j = 0; j < 2; j++) {
                    answer[i][j] = 1;
                }
            }

            for(int i = 0; i < 2; i++) {
                for(int j = 2; j < 4; j++) {
                    answer[i][j] = 2;
                }
            }

            for(int i = 2; i < 4; i++) {
                for(int j = 0; j < 2; j++) {
                    answer[i][j] = 3;
                }
            }

            for(int i = 2; i < 4; i++) {
                for(int j = 2; j < 4; j++) {
                    answer[i][j] = 4;
                }
            }

            for(int i = 1; i < 3; i++) {
                for(int j = 1; j < 3; j++) {
                    answer[i][j] = 5;
                }
            }

            if(answer[x][y] == 1) {
                answer[1][1] = 1;
            } else if(answer[x][y] == 2) {
                answer[1][2] = 2;
            } else if(answer[x][y] == 3) {
                answer[2][1] = 3;
            } else if(answer[x][y] == 4) {
                answer[2][2] = 4;
            }
            answer[x][y] = -1;
        }

        for(int[] a: answer) {
            for(int aa: a) {
                sb.append(aa).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
