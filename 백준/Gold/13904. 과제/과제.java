import java.io.*;
import java.util.*;

public class Main {

    static class Homework implements Comparable<Homework> {
        int deadline;
        int score;

        public Homework(int deadline, int score) {
            this.deadline = deadline;
            this.score = score;
        }

        @Override
        public int compareTo(Homework h) {
            if(this.deadline == h.deadline) {
                return this.score - h.score;
            } else {
                return this.deadline - h.deadline;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Homework> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            pq.add(new Homework(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        PriorityQueue<Integer> scores = new PriorityQueue<>();
        while(!pq.isEmpty()) {
            Homework h = pq.poll();
            if(scores.size() < h.deadline) {
                scores.add(h.score);
            } else {
                if(scores.peek() < h.score) {
                    scores.remove();
                    scores.add(h.score);
                }
            }
        }

        int answer = 0;
        while(!scores.isEmpty()) {
            answer += scores.poll();
        }
        System.out.println(answer);
    }
}