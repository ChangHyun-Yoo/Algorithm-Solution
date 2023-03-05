import java.io.*;
import java.util.*;

public class Main {

    static long[] nums;
    static long[] answer = new long[3];
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        nums = new long[N];
        for(int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(nums);
        for(int i = 0; i < N - 2; i++) {
            for(int j = i + 1; j < N - 1; j++) {
                long sum = nums[i] + nums[j];
                int index = lowerBound(j + 1, N, -sum);
                if(index == j + 1) {
                    if(min > Math.abs(sum + nums[j + 1])) {
                        min = Math.abs(sum + nums[j + 1]);
                        answer[0] = nums[i];
                        answer[1] = nums[j];
                        answer[2] = nums[j + 1];
                    }
                } else if(index == N) {
                    if(min > Math.abs(sum + nums[index - 1])) {
                        min = Math.abs(sum + nums[index - 1]);
                        answer[0] = nums[i];
                        answer[1] = nums[j];
                        answer[2] = nums[index - 1];
                    }
                } else if(index == N - 1) {
                    if(Math.abs(sum + nums[N - 1]) > Math.abs(sum + nums[N - 2])) {
                        if(min > Math.abs(sum + nums[N - 2])) {
                            min = Math.abs(sum + nums[N - 2]);
                            answer[0] = nums[i];
                            answer[1] = nums[j];
                            answer[2] = nums[N - 2];
                        }
                    } else {
                        if(min > Math.abs(sum + nums[N - 1])) {
                            min = Math.abs(sum + nums[N - 1]);
                            answer[0] = nums[i];
                            answer[1] = nums[j];
                            answer[2] = nums[N - 1];
                        }
                    }
                } else {
                    if(nums[index] == -sum) {
                        System.out.println(nums[i] + " " + nums[j] + " " + nums[index]);
                        return;
                    } else {
                        if(Math.abs(sum + nums[index]) > Math.abs(sum + nums[index - 1])) {
                            if(min > Math.abs(sum + nums[index - 1])) {
                                min = Math.abs(sum + nums[index - 1]);
                                answer[0] = nums[i];
                                answer[1] = nums[j];
                                answer[2] = nums[index - 1];
                            }
                        } else {
                            if(min > Math.abs(sum + nums[index])) {
                                min = Math.abs(sum + nums[index]);
                                answer[0] = nums[i];
                                answer[1] = nums[j];
                                answer[2] = nums[index];
                            }
                        }
                    }
                }
            }
        }
        for(long a: answer) {
            System.out.print(a + " ");
        }
    }

    private static int lowerBound(int start, int end, long value) {
        int low = start;
        int high = end;

        while(low < high) {
            int mid = low + (high - low) / 2;

            if(value <= nums[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

}
