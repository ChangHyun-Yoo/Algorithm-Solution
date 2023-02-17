import java.io.*;
import java.util.*;

public class Main {

    static class Water implements Comparable<Water> {
        int start;
        int end;

        public Water(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Water w) {
            return this.start - w.start;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        PriorityQueue<Water> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.offer(new Water(s, e));
        }

        Queue<Water> q = new LinkedList<>();

        Water first = pq.poll();
        int start = first.start;
        int end = first.end;

        while(!pq.isEmpty()) {
            Water w = pq.poll();
            if(end < w.start) {
                q.offer(new Water(start, end));
                start = w.start;
                end = w.end;
                continue;
            }

            end = Math.max(end, w.end);
        }
        q.offer(new Water(start, end));

        int answer = 0;
        Water f = q.poll();
        int current = f.start;
        while(current < f.end) {
            current += L;
            answer++;
        }

        while(!q.isEmpty()) {
            Water ww = q.poll();
            if(ww.start < current) {//새로운 웅덩이의 출발 지점이 이미 덮혀졌을 때
                while(current < ww.end) {
                    current += L;
                    answer++;
                }
            } else {//반대
                current = ww.start;
                while(current < ww.end) {
                    current += L;
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}