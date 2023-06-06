import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] lights = new int[N];
        for(int i = 0; i < N; i++) {
            lights[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int command = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            
            if(command == 1) {
                lights[l - 1] = r;
            } else if(command == 2) {
                for(int j = l - 1; j <= r - 1; j++) {
                    if(lights[j] == 1) lights[j] = 0;
                    else lights[j] = 1;
                }
            } else if(command == 3) {
                for(int j = l - 1; j <= r - 1; j++) {
                    lights[j] = 0;
                }
            } else {
                for(int j = l - 1; j <= r - 1; j++) {
                    lights[j] = 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int light: lights) {
            sb.append(light + " ");
        }
        System.out.println(sb);
    }
}