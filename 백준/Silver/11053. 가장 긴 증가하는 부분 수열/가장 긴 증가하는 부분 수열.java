import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[N];
        answer[0] = 1;
        for(int i = 1; i < N; i++) {
            int value = nums[i];
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(nums[j] < value && max < answer[j]) {
                    max = answer[j];
                }
            }
            answer[i] = max + 1;
        }

        int m = 0;
        for(int i = 0; i < N; i++) {
            if(answer[i] > m)
                m = answer[i];
        }
        System.out.println(m);
    }
}
