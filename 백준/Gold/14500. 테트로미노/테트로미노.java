import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] nums = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        //1번째
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M - 3; j++) {
                int sum = nums[i][j] + nums[i][j+1] + nums[i][j+2] + nums[i][j+3];
                if(sum > max)
                    max = sum;
            }
        }
        //2번째
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N - 3; j++) {
                int sum = nums[j][i] + nums[j+1][i] + nums[j+2][i] + nums[j+3][i];
                if(sum > max)
                    max = sum;
            }
        }
        //3번째
        for(int i = 0; i < N - 1; i++) {
            for(int j = 0; j < M - 1; j++) {
                int sum = nums[i][j] + nums[i+1][j] + nums[i][j+1] + nums[i+1][j+1];
                if(sum > max)
                    max = sum;
            }
        }
        //4~11번째
        for(int i = 0; i < N - 2; i++) {
            for(int j = 0; j < M - 1; j++) {
                int i11 = nums[i][j];
                int i12 = nums[i][j+1];
                int i21 = nums[i+1][j];
                int i22 = nums[i+1][j+1];
                int i31 = nums[i+2][j];
                int i32 = nums[i+2][j+1];
                if(i11+i21+i31+i12 > max)
                    max = i11+i21+i31+i12;
                if(i11+i12+i22+i32 > max)
                    max = i11+i12+i22+i32;
                if(i11+i21+i31+i32 > max)
                    max = i11+i21+i31+i32;
                if(i31+i12+i22+i32 > max)
                    max = i31+i12+i22+i32;
                if(i11+i21+i22+i32 > max)
                    max = i11+i21+i22+i32;
                if(i21+i31+i12+i22 > max)
                    max = i21+i31+i12+i22;
                if(i21+i12+i22+i32 > max)
                    max = i21+i12+i22+i32;
                if(i11+i21+i31+i22 > max)
                    max = i11+i21+i31+i22;
            }
        }
        //12~19번째
        for(int i = 0; i < N - 1; i++) {
            for(int j = 0; j < M - 2; j++) {
                int i11 = nums[i][j];
                int i12 = nums[i][j+1];
                int i13 = nums[i][j+2];
                int i21 = nums[i+1][j];
                int i22 = nums[i+1][j+1];
                int i23 = nums[i+1][j+2];
                if(i11+i21+i22+i23 > max)
                    max = i11+i21+i22+i23;
                if(i21+i22+i23+i13 > max)
                    max = i21+i22+i23+i13;
                if(i11+i12+i13+i21 > max)
                    max = i11+i12+i13+i21;
                if(i11+i12+i13+i23 > max)
                    max = i11+i12+i13+i23;
                if(i12+i13+i21+i22 > max)
                    max = i12+i13+i21+i22;
                if(i11+i12+i22+i23 > max)
                    max = i11+i12+i22+i23;
                if(i12+i21+i22+i23 > max)
                    max = i12+i21+i22+i23;
                if(i11+i12+i13+i22 > max)
                    max = i11+i12+i13+i22;
            }
        }
        System.out.println(max);
    }
}