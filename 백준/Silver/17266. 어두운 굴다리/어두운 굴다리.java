import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        if(M == 1) {
            int i = Integer.parseInt(br.readLine());
            System.out.println(Math.max(i, N - i));
            return;
        }

        int current = 0;
        int between = 0;
        int end = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
            int s = Integer.parseInt(st.nextToken());
            if(i == 0) {//처음일 때
                end = s;
            } else if(i == M - 1) {//끝일 때
                if(N - s > end)
                    end = N - s;
                if(s - current > between) {
                    between = s - current;
                }
            } else {
                if(s - current > between) {
                    between = s - current;
                }
            }
            current = s;
        }

        if(between % 2 == 1) {
            between = between / 2 + 1;
        } else {
            between /= 2;
        }

        System.out.println(Math.max(between, end));
    }
}