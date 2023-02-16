import java.io.*;
import java.util.*;

public class Main {

    static class time implements Comparable<time> {
        int start;
        int end;

        public time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(time t) {
            return this.start - t.start;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<time> pq = new PriorityQueue<>();
        for(int i = 0; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            start = start / 100 * 60 + start - (start / 100 * 100) - 10;
            end = end / 100 * 60 + end - (end / 100 * 100) + 10;
            pq.offer(new time(start, end));
        }

        int max = -1;
        int cStart = -1;
        int cEnd = -1;
        while(!pq.isEmpty()) {
            time t = pq.poll();
            if(cStart == -1 && cEnd == -1) {
                cStart = t.start;
                cEnd = t.end;
                if(cStart > 600) {
                    max = cStart - 600;
                } else {
                    max = 0;
                }
                continue;
            }

            if(cEnd < t.start) {//쉬는 시간이 생길 때
                max = Math.max(max, t.start - cEnd);
                cStart = t.start;
                cEnd = Math.max(cEnd, t.end);
            } else {
                cEnd = Math.max(cEnd, t.end);
            }
        }
        if(cEnd >= 1320) {
            System.out.println(max);
        } else {
            System.out.println(Math.max(max, 1320 - cEnd));
        }
    }
}