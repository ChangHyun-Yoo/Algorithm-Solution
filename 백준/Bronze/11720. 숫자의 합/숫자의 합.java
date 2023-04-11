import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        String s = br.readLine();
        for(int i = 0; i < N; i++) {
            answer += Integer.parseInt(s.substring(i, i + 1));
        }

        System.out.println(answer);
    }
}