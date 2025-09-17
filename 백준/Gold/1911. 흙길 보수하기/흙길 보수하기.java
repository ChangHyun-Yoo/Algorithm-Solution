import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        List<Hole> holes = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            holes.add(new Hole(start, end));
        }

        Collections.sort(holes);

        int answer = 0;
        int max = 0;

        for(int i = 0; i < holes.size(); i++) {
            Hole current = holes.get(i);
            int newStart = Math.max(max, current.start);

            if(newStart >= current.end) continue;

            int need = (current.end - newStart + L - 1) / L;
            answer += need;

            max = newStart + need * L;
        }

        System.out.println(answer);
    }

    static class Hole implements Comparable<Hole> {
        int start;
        int end;

        public Hole(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Hole h) {
            return this.start - h.start;
        }
    }
}
