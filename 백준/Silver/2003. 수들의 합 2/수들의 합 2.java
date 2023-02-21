import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] info = new int[N];
        st =  new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }

        int first = 0;
        int last = 0;
        int answer = 0;
        int current = info[0];
        while(first < N) {
            if(current > M) {
                current -= info[first];
                first++;
            } else if(current < M) {
                if(last != N - 1) {
                    last++;
                    current += info[last];
                } else {
                    break;
                }
            } else {
                answer++;
                current -= info[first];
                first++;
                if(last != N - 1) {
                    last++;
                    current += info[last];
                }
            }
        }

        System.out.println(answer);
    }
}
