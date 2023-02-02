import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine(), 2);

        int count = 0;
        while(num != 0) {
            int copy1 = num;
            int copy2 = num;
            num = ~num + 1;
            num &= copy1;
            num = copy2 - num;
            count++;
        }

        System.out.println(count);
    }
}