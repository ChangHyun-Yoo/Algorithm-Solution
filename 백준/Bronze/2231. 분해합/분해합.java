import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = -1;
        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i < N; i++) {
            if(con(i) == N) {
                answer = i;
                break;
            }
        }
        if(answer != -1)
            System.out.println(answer);
        else
            System.out.println(0);
    }

    static int con(int i) {
        int copy = i;
        int result = 0;
        if(i / 100000 >= 1) {
            result += (i / 100000);
            i -= (i / 100000) * 100000;
        }
        if(i / 10000 >= 1) {
            result += (i / 10000);
            i -= (i / 10000) * 10000;
        }
        if(i / 1000 >= 1) {
            result += (i / 1000);
            i -= (i / 1000) * 1000;
        }
        if(i / 100 >= 1) {
            result += (i / 100);
            i -= (i / 100) * 100;
        }
        if(i / 10 >= 1) {
            result += (i / 10);
            i -= (i / 10) * 10;
        }
        result += i;
        return result + copy;
    }
}