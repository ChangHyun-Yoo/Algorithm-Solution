import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int fMax = n / 5;

        int answer = -1;
        for(int i = fMax; i >= 0; i--) {
            int r = n - i * 5;
            if(r % 2 == 0) {
                answer = i + r / 2;
                break;
            }
        }
        System.out.println(answer);
    }
}

