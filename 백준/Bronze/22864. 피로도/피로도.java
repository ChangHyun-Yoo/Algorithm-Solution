import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int tired = 0;
        int work = 0;
        for(int i = 0; i < 24; i++) {
            if(tired + A <= M) {
                work += B;
                tired += A;
            } else {
                tired = Math.max(0, tired - C);
            }
        }
        System.out.println(work);
    }
}