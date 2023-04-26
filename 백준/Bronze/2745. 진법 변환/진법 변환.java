import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String N = new StringBuffer(st.nextToken()).reverse().toString();
        int B = Integer.parseInt(st.nextToken());

        int answer = 0;
        for(int i = 0; i < N.length(); i++) {
            int n = (int) N.charAt(i);
            if(n >= 65 && n <= 90) {
                answer += (n - 55) * Math.pow(B, i);
            } else {
                answer += (n - 48) * Math.pow(B, i);
            }
        }
        System.out.println(answer);
    }
}