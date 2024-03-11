import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int K = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            List<List<Integer>> roads = new ArrayList<>();
            int[] before = new int[M + 1];
            int[][] nums = new int[M + 1][2];
            for(int i = 0; i < M + 1; i++) {
                roads.add(new ArrayList<>());
            }

            for(int p = 0; p < P; p++) {
                st = new StringTokenizer(br.readLine(), " ");

                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                roads.get(A).add(B);
                before[B]++;
            }

            Queue<Integer> q = new LinkedList<>();
            for(int i = 1; i < before.length; i++) {
                if(before[i] == 0) {
                    q.add(i);
                    nums[i][1] = 1;
                }
            }

            while(!q.isEmpty()) {
                int now = q.poll();

                for(int next: roads.get(now)) {
                    if(nums[next][0] < nums[now][1]) {
                        nums[next][0] = nums[now][1];
                        nums[next][1] = nums[now][1];
                    } else if(nums[next][0] == nums[now][1]) {
                        nums[next][1] = nums[now][1] + 1;
                    }
                }

                for(int next: roads.get(now)) {
                    before[next]--;
                    if(before[next] == 0) {
                        q.add(next);
                    }
                }
            }

            System.out.println(K + " " + nums[M][1]);
        }
    }

    static class Node {
        int num;
        int value;

        public Node(int num, int value) {
            this.num = num;
            this.value = value;
        }
    }
}