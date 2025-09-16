import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<C> classes = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            classes.add(new C(start, end));
        }

        PriorityQueue<Integer> times = new PriorityQueue<>();
        while(!classes.isEmpty()) {
            C now = classes.poll();

            if(times.isEmpty()) {
                times.add(now.end);
                continue;
            }

            int minTime = times.peek();
            if(minTime > now.start) {
                times.add(now.end);
            } else {
                times.poll();
                times.add(now.end);
            }
        }

        System.out.println(times.size());
    }

    static class C implements Comparable<C> {
       int start;
       int end;

       public C(int start, int end) {
           this.start = start;
           this.end = end;
       }

       public int compareTo(C c) {
           if(this.start == c.start) return this.end - c.end;
           return this.start - c.start;
       }
    }
}
