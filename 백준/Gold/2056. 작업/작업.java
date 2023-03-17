import java.io.*;
import java.util.*;

public class Main {

    static List<List<Work>> order = new ArrayList<>();
    static List<List<Integer>> before = new ArrayList<>();
    static int[] beforeNum;
    static int[] time;
    static int[] answer;

    static class Work {
        int num;
        int time;

        public Work(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        beforeNum = new int[N + 1];
        time = new int[N + 1];
        answer = new int[N + 1];
        for(int i = 0; i < N + 1; i++) {
            order.add(new ArrayList<>());
            before.add(new ArrayList<>());
        }
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            time[i + 1] = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            beforeNum[i + 1] = n;
            for(int j = 0; j < n; j++) {
                int l = Integer.parseInt(st.nextToken());
                order.get(l).add(new Work(i + 1, time[i + 1]));
                before.get(i + 1).add(l);
            }
        }

        Queue<Work> q = new LinkedList<>();
        for(int i = 1; i < beforeNum.length; i++) {
            if(beforeNum[i] == 0) {
                q.offer(new Work(i, time[i]));
            }
        }

        int a = 0;
        while(!q.isEmpty()) {
            Work work = q.poll();
            answer[work.num] = work.time;
            a = Math.max(a, work.time);

            for(Work next: order.get(work.num)) {
                beforeNum[next.num]--;
                if(beforeNum[next.num] == 0) {
                    int max = -1;
                    for(int b: before.get(next.num)) {
                        if(max < answer[b]) {
                            max = answer[b];
                        }
                    }
                    q.offer(new Work(next.num, max + next.time));
                }
            }
        }
        System.out.println(a);
    }
}
