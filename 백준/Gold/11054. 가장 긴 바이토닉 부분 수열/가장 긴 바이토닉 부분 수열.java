import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] nums = new int[N];

        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] in = new int[N];
        in[0] = 1;
        for(int i = 1; i < in.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j] && in[i] < in[j] + 1) {
                    in[i] = in[j] + 1;
                }
            }
            if(in[i] == 0) {
                in[i] = 1;
            }
        }

        int[] de = new int[N];
        de[N - 1] = 1;
        for(int i = N - 2; i >= 0; i--) {
            for(int j = N - 1; j > i; j--) {
                if(nums[i] > nums[j] && de[i] < de[j] + 1) {
                    de[i] = de[j] + 1;
                }
            }
            if(de[i] == 0) {
                de[i] = 1;
            }
        }

        for(int i = 0; i < N; i++) {
            in[i] = in[i] + de[i] - 1;
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            if(in[i] > max)
                max = in[i];
        }

        System.out.println(max);
    }
}
