import java.io.*;
import java.util.*;

public class Main {
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int red = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            answer = 0;

            dp(1, red, blue);

            sb.append(answer % (1000000007)).append('\n');
        }

        System.out.println(sb);
    }

    public static void dp(int r, int red, int blue) {
        if(red >= r) {
            answer++;
            dp(r + 1, red - r, blue);
        }

        if(blue >= r) {
            answer++;
            dp(r + 1, red, blue - r);
        }
    }

}