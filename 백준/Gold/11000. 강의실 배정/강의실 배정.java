import java.io.*;
import java.util.*;

public class Main {

    static class Lecture implements Comparable<Lecture> {
        int start;
        int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            if(this.start == o.start) {
                return this.end - o.end;
            } else {
                return this.start - o.start;
            }
        }

        @Override
        public String toString() {
            return "Lecture{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        List<Lecture> lectures = new ArrayList<Lecture>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Lecture l = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            lectures.add(l);
        }
        Collections.sort(lectures);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(Lecture lec: lectures) {
            if(pq.size() == 0) {
                pq.add(lec.end);
            } else {
                int minEnd = pq.peek();
                if(lec.start < minEnd) {
                    pq.add(lec.end);
                } else {
                    pq.poll();
                    pq.offer(lec.end);
                }
            }
        }

        System.out.println(pq.size());
    }
}