import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Long num = Long.parseLong(br.readLine(), 2);

        int count = 0;
        while(num != 0) {
            long copy1 = num;
            long copy2 = num;
            num = ~num + 1;
            num &= copy1;
            num = copy2 - num;
            count++;
        }

        System.out.println(count);
    }
}