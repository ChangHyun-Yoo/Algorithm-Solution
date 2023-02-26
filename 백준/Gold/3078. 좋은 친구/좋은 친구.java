import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] length = new int[N];
        for(int i = 0; i < N; i++) {
            length[i] = br.readLine().length();
        }

        long answer = 0;
        int[] nums = new int[21];

        Queue<Integer> q = new LinkedList<>();

        if(N == K) {
            int i = 0;
            while(q.size() != N) {
                answer += nums[length[i]];
                nums[length[i]]++;
                i++;
            }
            return;
        }

        int i = 0;
        while(q.size() != K + 1) {
            q.offer(length[i]);
            answer += nums[length[i]];
            nums[length[i]]++;
            i++;
        }

        int r = K + 1;
        while(r < length.length) {
            int top = q.poll();
            nums[top]--;
            answer += nums[length[r]];
            q.offer(length[r]);
            nums[length[r]]++;
            r++;
        }
        System.out.println(answer);
    }
}