import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] status = new boolean[N + 1];

        int count = 0;
        for(int i = 2; i < N + 1; i++) {
            for(int j = 1; i * j < N + 1; j++) {
                if(!status[i * j]) {
                    status[i * j] = true;
                    count++;
                    if(count == K) {
                        System.out.println(i * j);
                        return;
                    }
                }
            }
        }
    }
    
}
