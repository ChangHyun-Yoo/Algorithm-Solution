import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[M];
        st =  new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st =  new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while(i < N || j < M) {
            if(i == N) {
                sb.append(B[j] + " ");
                j++;
                continue;
            }

            if(j == M) {
                sb.append(A[i] + " ");
                i++;
                continue;
            }

            if(A[i] < B[j]) {
                sb.append(A[i] + " ");
                i++;
            } else {
                sb.append(B[j] + " ");
                j++;
            }
        }

        System.out.println(sb);
    }
}
