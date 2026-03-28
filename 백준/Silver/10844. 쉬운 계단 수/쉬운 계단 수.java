import java.util.*;
import java.io.*;

public class Main {

    static int DIV = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());

        int[][] table = new int[10][N + 1];

        for(int i = 0; i < 10; i++) {
            table[i][1] = 1;
        }

        for(int i = 2; i < N + 1; i++) {
            for(int j = 0; j < 10; j++) {
                if(j == 0) table[j][i] = table[j + 1][i - 1] % DIV;
                else if(j > 0 && j < 9) table[j][i] = ((table[j - 1][i - 1] % DIV) + (table[j + 1][i - 1] % DIV)) % DIV;
                else table[j][i] = table[j - 1][i - 1] % DIV;
            }
        }

        int answer = 0;
        for(int i = 1; i < 10; i++) {
            answer = ((answer % DIV) + (table[i][N] % DIV)) % DIV;
        }
        System.out.println(answer);
    }
}
