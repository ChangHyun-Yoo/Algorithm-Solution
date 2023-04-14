import java.io.*;
import java.util.*;

public class Main {

    static long[] lst = new long[91];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Arrays.fill(lst, -1);
        int n = Integer.parseInt(br.readLine());
        lst[0] = 0;
        lst[1] = 1;

        check(90);
        System.out.println(lst[n]);
    }

    static long check(int i) {
        if(lst[i] != -1) return lst[i];

        lst[i] = check(i - 1) + check(i - 2);
        return lst[i];
    }
}