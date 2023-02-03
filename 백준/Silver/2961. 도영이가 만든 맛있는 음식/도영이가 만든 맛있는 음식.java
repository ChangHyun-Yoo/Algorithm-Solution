import java.io.*;
import java.util.*;

public class Main {

    public static int min = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] sheen = new int[N];
        int[] sweet = new int[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            sheen[i] = Integer.parseInt(st.nextToken());
            sweet[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < Math.pow(2, N); i++) {
            String test = Integer.toBinaryString(i);
            if(test.length() < N) {
                while(test.length() < N) {
                    test = "0" + test;
                }
            }

            int sw = 0;
            int sh = 1;
            for(int j = 0; j < test.length(); j++) {
                int t = Integer.parseInt(test.substring(j, j + 1));
                if(t == 1) {
                    sw += sweet[j];
                    sh *= sheen[j];
                }
            }
            if(Math.abs(sw - sh) < min)
                min = Math.abs(sw - sh);
        }

        System.out.println(min);

    }
}