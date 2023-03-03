import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] houses = new int[N][3];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            houses[i][0] = Integer.parseInt(st.nextToken());
            houses[i][1] = Integer.parseInt(st.nextToken());
            houses[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N - 1; i++) {
            int one = houses[i + 1][0] + Math.min(houses[i][1], houses[i][2]);
            int two = houses[i + 1][1] + Math.min(houses[i][0], houses[i][2]);
            int three = houses[i + 1][2] + Math.min(houses[i][1], houses[i][0]);

            houses[i + 1][0] = one;
            houses[i + 1][1] = two;
            houses[i + 1][2] = three;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            if(houses[N - 1][i] < min)
                min = houses[N - 1][i];
        }
        System.out.println(min);
    }
}
