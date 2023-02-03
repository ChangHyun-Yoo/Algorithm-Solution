import java.io.*;
import java.util.*;

public class Main {

    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] dif = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            dif[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < Math.pow(2, N); i++) {
            String num = Integer.toBinaryString(i);
            while(num.length() < N) {
                num = "0" + num;
            }

            int sum = 0;
            int most = 0;
            int less = 1000000;
            for(int j = 0; j < num.length(); j++) {
                if(num.substring(j, j + 1).equals("1")) {
                    sum += dif[j];
                    if(dif[j] > most)
                        most = dif[j];
                    if(dif[j] < less)
                        less = dif[j];
                }
            }
            if(sum >= L && sum <= R && less != most && most - less >= X)
                answer++;
        }
        System.out.println(answer);
    }
}