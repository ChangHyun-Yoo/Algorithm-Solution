import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] b = new boolean[1001];
        b[1] = true;
        for(int i = 2; i < 1001; i++) {
            for(int j = 2; i * j < 1001; j++) {
                b[i * j] = true;
            }
        }
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            if(!b[Integer.parseInt(st.nextToken())]) answer++;
        }
        System.out.println(answer);
    }
}

