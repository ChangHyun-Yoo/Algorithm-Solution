import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int K;
    static int[] min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        min = new int[200001];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[N] = 0;

        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.offer(new Info(N, 0));

        while(!pq.isEmpty()) {
            Info now = pq.poll();

            if(now.time > min[now.place]) continue;

            now.time = min[now.place];
            if(now.place != 200000) {
                if(min[now.place + 1] > now.time + 1) {
                    min[now.place + 1] = now.time + 1;
                    pq.offer(new Info(now.place + 1, now.time + 1));
                }
            }
            if(now.place != 0) {
                if(min[now.place - 1] > now.time + 1) {
                    min[now.place - 1] = now.time + 1;
                    pq.offer(new Info(now.place - 1, now.time + 1));
                }
            }
            if(now.place <= 100000) {
                if(min[now.place * 2] > now.time) {
                    min[now.place * 2] = now.time;
                    pq.offer(new Info(now.place * 2, now.time));
                }
            }
        }
        System.out.println(min[K]);
    }

    static class Info implements Comparable<Info> {
        int place;
        int time;

        public Info(int place, int time) {
            this.place = place;
            this.time = time;
        }

        public int compareTo(Info i) {
            return this.time - i.time;
        }
    }
}