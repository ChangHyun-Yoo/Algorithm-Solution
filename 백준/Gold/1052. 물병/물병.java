import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int current = N;
        while(true) {
            String s = Integer.toBinaryString(current);
            int count = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '1') count++;
            }

            if(count <= K) break;

            current++;
        }

        System.out.println(current - N);
    }
}
