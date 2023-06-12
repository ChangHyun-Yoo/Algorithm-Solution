import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int K;
    static int[] before;
    static int[] current;
    static List<List<Integer>> next = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        before = new int[N + 1];
        current = new int[N + 1];

        for(int i = 0; i < N + 1; i++) {
            next.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            next.get(X).add(Y);
            before[Y]++;
        }

        String answer = "King-God-Emperor";
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            if(X == 1) {
                if(before[Y] == 0) {
                    if(current[Y] == 0) {
                        for(int n: next.get(Y)) {
                            before[n]--;
                        }
                    }
                    current[Y]++;
                } else {
                    answer = "Lier!";
                    break;
                }
            } else {
                if(current[Y] == 0) {
                    answer = "Lier!";
                    break;
                } else if(current[Y] == 1) {
                    for(int n: next.get(Y)) {
                        before[n]++;
                    }
                    current[Y]--;
                } else {
                    current[Y]--;
                }
            }
        }
        System.out.println(answer);
    }
}