import java.io.*;
import java.util.*;

public class Main {

    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] info = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i < Math.pow(2, N - 1); i++){
            String num = Integer.toBinaryString(i);
            while(num.length() < N) {
                num = "0" + num;
            }
            List<Integer> ones = new ArrayList<>();
            List<Integer> zeros = new ArrayList<>();
            for(int j = 0; j < num.length(); j++) {
                int n = Integer.parseInt(num.substring(j, j + 1));
                if(n == 1) {
                    ones.add(j);
                } else {
                    zeros.add(j);
                }
            }
            int oness = 0;
            int zeorss = 0;
            for(int j = 0; j < ones.size(); j++) {
                for(int k = 0; k < ones.size(); k++) {
                    oness += info[ones.get(j)][ones.get(k)];
                }
            }
            for(int j = 0; j < zeros.size(); j++) {
                for(int k = 0; k < zeros.size(); k++) {
                    zeorss += info[zeros.get(j)][zeros.get(k)];
                }
            }
            if(Math.abs(oness - zeorss) < min)
                min = Math.abs(oness - zeorss);
        }
        System.out.println(min);
    }
}