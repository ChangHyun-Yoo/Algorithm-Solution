import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] nums = new int[4];

        char[] info = br.readLine().toCharArray();

        int[] min = new int[4];
        st = new StringTokenizer(br.readLine(), " ");
        min[0] = Integer.parseInt(st.nextToken());
        min[1] = Integer.parseInt(st.nextToken());
        min[2] = Integer.parseInt(st.nextToken());
        min[3] = Integer.parseInt(st.nextToken());

        for(int i = 0; i < P; i++) {
            if(info[i] == 'A') {
                nums[0]++;
            } else if(info[i] == 'C') {
                nums[1]++;
            } else if(info[i] == 'G') {
                nums[2]++;
            } else {
                nums[3]++;
            }
        }

        int answer = 0;

        int l = 0;
        int r = P - 1;

        while(true) {
            if(nums[0] >= min[0] && nums[1] >= min[1] && nums[2] >= min[2] && nums[3] >= min[3]) {
                answer++;
            }

            if(info[l] == 'A') {
                nums[0]--;
            } else if(info[l] == 'C') {
                nums[1]--;
            } else if(info[l] == 'G') {
                nums[2]--;
            } else {
                nums[3]--;
            }
            l++;
            r++;
            if(r == info.length)
                break;
            if(info[r] == 'A') {
                nums[0]++;
            } else if(info[r] == 'C') {
                nums[1]++;
            } else if(info[r] == 'G') {
                nums[2]++;
            } else {
                nums[3]++;
            }
        }

        System.out.println(answer);
    }
}