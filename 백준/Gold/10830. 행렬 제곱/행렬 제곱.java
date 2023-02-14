import java.io.*;
import java.util.*;

public class Main {

    static int[][] nums;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        nums = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] current = dq(B);

        for(int[] c: current) {
            for(int i: c) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static int[][] dq(long B) {
        if(B == 1) {
            return nums;
        }

        if(B % 2 == 0) {//짝수일 때
            return mulSame(dq(B / 2));
        } else {
            return mul1(dq(B - 1), dq(1));
        }
    }

    static int[][] mul1(int[][] mat, int[][] mat2) {
        int l = mat.length;
        int[][] output = new int[l][l];

        for(int i = 0; i < l; i++) {
            for(int j = 0; j < l; j++) {
                long sum = 0;
                for(int k = 0; k < l; k++) {
                    sum += (mat[i][k] % 1000) * (mat2[k][j] % 1000);
                }
                output[i][j] = (int) (sum % 1000);
            }
        }

        return output;
    }

    static int[][] mulSame(int[][] mat) {
        int l = mat.length;
        int[][] output = new int[l][l];

        for(int i = 0; i < l; i++) {
            for(int j = 0; j < l; j++) {
                long sum = 0;
                for(int k = 0; k < l; k++) {
                    sum += (mat[i][k] % 1000) * (mat[k][j] % 1000);
                }
                output[i][j] = (int) (sum % 1000);
            }
        }

        return output;
    }
}