import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());

            sb.append(lcm(a, b) + "\n");
        }

        System.out.println(sb);
    }

    static long lcm(double a, double b) {
        if(a == b) return (int) a;
        double min = Math.min(a, b);

        int result = 1;
        for (int i = 2; i <= (int) min / 2; i++) {
            if(a / i == (int) (a / i) && b / i == (int) (b / i)) {
                result = i;
            }
        }
        return (long) (result * (a / result) * (b / result));
    }
}