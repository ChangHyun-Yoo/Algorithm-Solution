import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[1000];

        for(int i = 0; i < 1000; i++) {
            int current = i + 1;
            if(current < 10) {//일의 자리
                check[i] = true;
            } else if(current < 100) {//십의 자리
                check[i] = true;
            } else {//세 자리
                if(current / 100 - (current % 100) / 10 == (current % 100) / 10 - (current % 10)) {
                    check[i] = true;
                }
            }
        }

        int answer = 0;
        for(int i = 0; i < N; i++) {
            if(check[i])
                answer++;
        }
        System.out.println(answer);
    }

}