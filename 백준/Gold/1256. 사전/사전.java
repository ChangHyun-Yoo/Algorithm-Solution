import java.io.*;
import java.util.*;

public class Main {

    static int[][] com;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int a = N;
        int b = M;
        com = new int[201][101];

        if(com(a + b, b) < K) {
            System.out.println(-1);
            return;
        }


        String answer = "";

        int current = 1;

        while(answer.length() < N + M) {
            if(a == 0 && b != 0) {
                answer += "z";
                b--;
                continue;
            }

            if(a != 0 && b == 0) {
                answer += "a";
                a--;
                continue;
            }

            if(a == 0 && b == 0) {
                System.out.println(-1);
                return;
            }

            if(current + com(a + b - 1, b) - 1 >= K) {//a에 포함
                answer += "a";
                a--;
            } else {
                answer += "z";
                current += com(a + b - 1, b);
                b--;
            }
        }

        System.out.println(answer);
    }

    static int com(int n, int r) {
        if(com[n][r] != 0) {
            return com[n][r];
        }

        if(r == 0 || n == r) {
            com[n][r] = 1;
            return 1;
        }

        if(com(n - 1, r - 1) + com(n - 1, r) > 1000000000) {
            com[n][r] = 1000000001;
        } else {
            com[n][r] = com(n - 1, r - 1) + com(n - 1, r);
        }
        return com[n][r];
    }
}
