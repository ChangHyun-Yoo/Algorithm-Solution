import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;
    static int[][] remove;
    static int[] height;
    static int[] nums;
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for(int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }
        height = new int[N + 1];
        Arrays.fill(height, 1);
        nums = new int[N + 1];
        Arrays.fill(nums, 1);
        remove = new int[M][3];
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            remove[i][0] = Integer.parseInt(st.nextToken());
            remove[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < Q; i++) {
            int index = Integer.parseInt(br.readLine()) - 1;
            s.push(index);
            remove[index][2] = 1;
        }

        for(int i = 0; i < remove.length; i++) {
            if(remove[i][2] != 1) {
                union(remove[i][0], remove[i][1], false);
            }
        }

        while(!s.isEmpty()) {
            int poped = s.pop();
            union(remove[poped][0], remove[poped][1],  true);
        }

        System.out.println(answer);
    }

    static int findRoot(int i) {
        if(i == parent[i])
            return i;

        return findRoot(parent[i]);
    }

    static void union(int i, int j, boolean cal) {
        int rootI = findRoot(i);
        int rootJ = findRoot(j);
        if(rootI == rootJ)
            return;

        if(height[rootI] < height[rootJ]) {
            parent[rootI] = rootJ;
            if(cal)
                answer += (long) nums[rootI] * (long) nums[rootJ];
            nums[rootJ] += nums[rootI];
        } else if(height[rootI] > height[rootJ]) {
            parent[rootJ] = rootI;
            if(cal)
                answer += (long) nums[rootI] * (long) nums[rootJ];
            nums[rootI] += nums[rootJ];
        } else {
            parent[rootJ] = rootI;
            height[rootI]++;
            if(cal)
                answer += (long) nums[rootI] * (long) nums[rootJ];
            nums[rootI] += nums[rootJ];
        }
    }
}
