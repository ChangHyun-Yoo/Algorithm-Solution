import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] lst = new int[20000];

        int current = 0;
        int n = 1;
        while(true) {
            lst[current++] = 0;
            lst[current++] = 1;
            lst[current++] = 0;
            lst[current++] = 1;

            for(int i = current; i < current + (n + 1) * 2; i++) {
                if(i < current + n + 1) {
                    lst[i] = 0;
                } else {
                    lst[i] = 1;
                }
            }
            current += (n + 1) * 2;
            n++;
            if(current > 10001) break;
        }

        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int S = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i = 0; i < 10001; i++) {
            if(lst[i] == S) {
                count++;
                if(count == T) {
                    System.out.println(i % A);
                    return;
                }
            }
        }
    }
}